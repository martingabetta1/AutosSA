package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Tecnico;

import com.example.API.Taller.Mecanico.service.ITecnicoService;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TecnicoController.class)
public class TecnicoControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ITecnicoService serviceTecnico;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private TecnicoController tecnicoController;

    @Test
    @DisplayName("Test para validar correctamente la ruta del endpoint y devuelve un estado 200 al listar tecnicos sin campo select")
    void testListarTecnicosOkSinCampoSelect() throws Exception {

        Tecnico tecnico1 = new Tecnico();
        tecnico1.setNombre("Matias");

        Tecnico tecnico2 = new Tecnico();
        tecnico2.setNombre("Martin");

        when(serviceTecnico.listarTecnicos()).thenReturn(Arrays.asList(tecnico1, tecnico2));

        mvc.perform(MockMvcRequestBuilders.get("/tecnicos"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.length()").value(2));

    }

    @Test
    @DisplayName("Test para validar tecnicos con campo select")
    void testListarTecnicosOkConCampoSelect() throws Exception {

        Tecnico tecnico1 = new Tecnico();
        tecnico1.setId(1);
        tecnico1.setNombre("Matias");

        Tecnico tecnico2 = new Tecnico();
        tecnico2.setId(2);
        tecnico2.setNombre("Martin");

        when(serviceTecnico.listarTecnicos()).thenReturn(Arrays.asList(tecnico1, tecnico2));

        // Caso cuando select es nulo
        mvc.perform(MockMvcRequestBuilders.get("/tecnicos").param("select", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].descripcion").exists());

    }

    @Test
    @DisplayName("Test para registrar tecnico")
    void testRegistrarTecnicosOk() throws Exception {

        Tecnico tecnico = new Tecnico();
        tecnico.setId(1);
        tecnico.setNombre("Gonzalo");

        when(serviceTecnico.registrar(any())).thenReturn(tecnico);

        mvc.perform(MockMvcRequestBuilders.post("/tecnicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tecnico)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Gonzalo"))
                .andReturn();

    }

    @Test
    @DisplayName("Test para actualizar tecnico")
    void testActualizarTecnico() throws Exception {

        Tecnico tecnico = new Tecnico();
        tecnico.setId(1);
        tecnico.setNombre("Franco");
        //Integer tecnicoId, String nombre, String apellido, String documento, String telefono, String direccion
        doNothing().when(serviceTecnico).actualizar(eq(tecnico.getId()), eq(tecnico.getNombre()), eq(tecnico.getApellido()), eq(tecnico.getDocumento()), eq(tecnico.getTelefono()), eq(tecnico.getDireccion()));

        mvc.perform(MockMvcRequestBuilders.put("/tecnicos/actualizar/{id}", tecnico.getId())
           .contentType(MediaType.APPLICATION_JSON)
           .content(objectMapper.writeValueAsString(tecnico)))
           .andExpect(status().isOk())
           .andExpect(content().string("El tecnico se actualizó correctamente"));


        //Verifico que se llamo bien el servicio:
        verify(serviceTecnico, times(1)).actualizar(eq(tecnico.getId()), eq(tecnico.getNombre()), eq(tecnico.getApellido()), eq(tecnico.getDocumento()), eq(tecnico.getTelefono()), eq(tecnico.getDireccion()));

    }

    @Test
    @DisplayName("Test para eliminar tecnico")
    void testEliminarTecnico() throws Exception{

        Tecnico tecnico = new Tecnico();
        tecnico.setId(1);
        tecnico.setNombre("Benjamin");

        doNothing().when(serviceTecnico).eliminar(eq(tecnico.getId()));

        mvc.perform(MockMvcRequestBuilders.post("/tecnicos/eliminar/{id}", tecnico.getId())
           .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk());

        verify(serviceTecnico, times(1)).eliminar(eq(tecnico.getId()));

    }
}
