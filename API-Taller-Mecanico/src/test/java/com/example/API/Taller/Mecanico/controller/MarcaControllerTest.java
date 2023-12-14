package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.service.IMarcaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MarcaController.class)
class MarcaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IMarcaService serviceMarca;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private MarcaController marcaController;

    @Test
    @DisplayName("Test para validar correctamente la ruta del endpoint y devuelve un estado 200 al listar marcas sin campo select")
    void testListarMarcasOkSinCampoSelect() throws Exception {

        Marca marca1 = new Marca();
        marca1.setNombre("Mercedes");

        Marca marca2 = new Marca();
        marca2.setNombre("Renault");

        when(serviceMarca.listarMarcas()).thenReturn(Arrays.asList(marca1, marca2));

        mvc.perform(MockMvcRequestBuilders.get("/marcas"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.length()").value(2));

    }

    @Test
    @DisplayName("Test para validar marcas con campo select")
    void testListarMarcasOkConCampoSelect() throws Exception {

        Marca marca1 = new Marca();
        marca1.setId(1);
        marca1.setNombre("Mercedes");

        Marca marca2 = new Marca();
        marca2.setId(2);
        marca2.setNombre("Renault");

        when(serviceMarca.listarMarcas()).thenReturn(Arrays.asList(marca1, marca2));

        // Caso cuando select es nulo
        mvc.perform(MockMvcRequestBuilders.get("/marcas").param("select", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].descripcion").exists());

    }

    @Test
    @DisplayName("Test para registrar marca")
    void testRegistrarMarcasOk() throws Exception {

        Marca marca = new Marca();
        marca.setId(1);
        marca.setNombre("Fiat");

        when(serviceMarca.registrar(any())).thenReturn(marca);

        mvc.perform(MockMvcRequestBuilders.post("/marcas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(marca)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Fiat"))
                .andReturn();

    }

    @Test
    @DisplayName("Test para actualizar marca")
    void testActualizarMarca() throws Exception {

        Marca marca = new Marca();
        marca.setId(1);
        marca.setNombre("BMW");

        doNothing().when(serviceMarca).actualizar(eq(marca.getId()), eq(marca.getNombre()));

        mvc.perform(MockMvcRequestBuilders.put("/marcas/actualizar/{id}", marca.getId())
           .contentType(MediaType.APPLICATION_JSON)
           .content(objectMapper.writeValueAsString(marca)))
           .andExpect(status().isOk())
           .andExpect(content().string("La marca se actualizó correctamente"));


        //Verifico que se llamo bien el servicio:
        verify(serviceMarca, times(1)).actualizar(eq(marca.getId()), eq(marca.getNombre()));

    }

    @Test
    @DisplayName("Test para eliminar marca")
    void testEliminarMarca() throws Exception{

        Marca marca = new Marca();
        marca.setId(1);
        marca.setNombre("Toyota");

        doNothing().when(serviceMarca).eliminar(eq(marca.getId()));

        mvc.perform(MockMvcRequestBuilders.post("/marcas/eliminar/{id}", marca.getId())
           .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk());

        verify(serviceMarca, times(1)).eliminar(eq(marca.getId()));

    }
}
