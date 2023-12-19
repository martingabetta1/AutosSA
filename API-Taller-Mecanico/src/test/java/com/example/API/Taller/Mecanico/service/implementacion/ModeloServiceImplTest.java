package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.repository.IModeloRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@WebMvcTest(ModeloServiceImpl.class)
class ModeloServiceImplTest {

    @Autowired
    private ModeloServiceImpl modeloService;

    @MockBean
    private IModeloRepository modeloRepo;


    @Test
    @DisplayName("Test para listar todos los modelos")
    void testListarModelos() {

        Modelo modelo1 = new Modelo();
        Modelo modelo2 = new Modelo();

        List<Modelo> listaModelos = Arrays.asList(modelo1, modelo2);
        when(modeloRepo.findByEliminadoFalse()).thenReturn(listaModelos);

        List<Modelo> response = modeloService.listarModelos();

        assertNotNull(response);
        assertEquals(listaModelos, response);
    }


    @Test
    @DisplayName("Test para registrar un modelo")
    void testRegistrarModelo() {

        Modelo modelo = new Modelo();

        modeloService.registrar(modelo);

        // Verifica que el método save del repositorio fue llamado una vez con la entidad correcta
        verify(modeloRepo, times(1)).save(modelo);

    }

    @Test
    @DisplayName("Test para actualizar un modelo")
    void testActualizarModelo() {

        Modelo modelo = new Modelo();
        modelo.setId(1);
        modelo.setNombre("Modelo1");

        Marca marca = new Marca();
        modelo.setMarca(marca);

        modeloService.actualizar(modelo.getId(), modelo.getNombre(), modelo.getMarca());

        // Verifica que el método save del repositorio fue llamado una vez con la entidad correcta
        verify(modeloRepo, times(1)).actualizarModelo(modelo.getId(), modelo.getNombre(), modelo.getMarca());
    }

    @Test
    @DisplayName("Test para eliminar una marca")
    void testEliminarMarca() {

        Marca marca = new Marca();
        marca.setId(1);

        modeloService.eliminar(marca.getId());

        verify(modeloRepo, times(1)).eliminar(marca.getId());
    }

}
