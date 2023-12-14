package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.service.IModeloService;
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

@WebMvcTest(ModeloController.class)
class ModeloControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IModeloService serviceModelo;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private ModeloController modeloController;

    @Test
    @DisplayName("Test para validar correctamente la ruta del endpoint y devuelve un estado 200 al listar modelos sin campo select")
    void testListarModelosOkSinCampoSelect() throws Exception {

        Modelo modelo1 = new Modelo();
        modelo1.setNombre("Modelo1");

        Marca marca1 = new Marca();
        modelo1.setMarca(marca1);

        Modelo modelo2 = new Modelo();
        modelo2.setNombre("Modelo2");

        Marca marca2 = new Marca();
        modelo2.setMarca(marca2);

        when(serviceModelo.listarModelos()).thenReturn(Arrays.asList(modelo1, modelo2));

        mvc.perform(MockMvcRequestBuilders.get("/modelos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

    }

    @Test
    @DisplayName("Test para validar marcas con campo select")
    void testListarModelosOkConCampoSelect() throws Exception {

        Modelo modelo1 = new Modelo();
        modelo1.setId(1);
        modelo1.setNombre("Modelo1");

        Marca marca1 = new Marca();
        modelo1.setMarca(marca1);

        Modelo modelo2 = new Modelo();
        modelo2.setId(2);
        modelo2.setNombre("Modelo2");

        Marca marca2 = new Marca();
        modelo2.setMarca(marca2);

        when(serviceModelo.listarModelos()).thenReturn(Arrays.asList(modelo1, modelo2));

        // Caso cuando select es nulo
        mvc.perform(MockMvcRequestBuilders.get("/modelos").param("select", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].descripcion").exists());

    }

    @Test
    @DisplayName("Test para registrar modelo")
    void testRegistrarModelosOk() throws Exception {

        Modelo modelo = new Modelo();
        modelo.setId(1);
        modelo.setNombre("Modelo1");

        Marca marca = new Marca();
        modelo.setMarca(marca);

        when(serviceModelo.registrar(any())).thenReturn(modelo);

        mvc.perform(MockMvcRequestBuilders.post("/modelos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(modelo)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Modelo1"))
                .andReturn();

    }

    @Test
    @DisplayName("Test para actualizar modelo")
    void testActualizarModelo() throws Exception {

        Modelo modelo = new Modelo();
        modelo.setId(1);
        modelo.setNombre("Modelo1");

        Marca marca = new Marca();
        modelo.setMarca(marca);

        doNothing().when(serviceModelo).actualizar(eq(modelo.getId()), eq(modelo.getNombre()), eq(modelo.getMarca()));

        mvc.perform(MockMvcRequestBuilders.put("/modelos/actualizar/{id}", modelo.getId())
           .contentType(MediaType.APPLICATION_JSON)
           .content(objectMapper.writeValueAsString(modelo)))
           .andExpect(status().isOk())
           .andExpect(content().string("El modelo se actualizó correctamente"));
    }

    @Test
    @DisplayName("Test para eliminar marca")
    void testEliminarMarca() throws Exception{

        Modelo modelo = new Modelo();
        modelo.setId(1);
        modelo.setNombre("Modelo1");

        Marca marca = new Marca();
        modelo.setMarca(marca);

        doNothing().when(serviceModelo).eliminar(eq(modelo.getId()));

        mvc.perform(MockMvcRequestBuilders.post("/modelos/eliminar/{id}", modelo.getId())
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        verify(serviceModelo, times(1)).eliminar(eq(modelo.getId()));

    }
}
