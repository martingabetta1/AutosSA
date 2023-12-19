package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.repository.IMarcaRepository;
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

@WebMvcTest(MarcaServiceImpl.class)
class MarcaServiceImplTest {

    @Autowired
    private MarcaServiceImpl marcaService;

    @MockBean
    private IMarcaRepository marcaRepo;


   @Test
   @DisplayName("Test para listar todas las marcas")
   void testListarMarcas() {

       Marca marca1 = new Marca();
       Marca marca2 = new Marca();

       List<Marca> listaMarcas = Arrays.asList(marca1, marca2);
       when(marcaRepo.findByEliminadoFalse()).thenReturn(listaMarcas);

       List<Marca> response = marcaService.listarMarcas(false);

       assertNotNull(response);
       assertEquals(listaMarcas, response);
   }


    @Test
    @DisplayName("Test para listar marcas por id")
    void testListarMarcaPorId() {

        Marca marca = new Marca();
        marca.setId(1);
        marca.setNombre("Fiat");

        when(marcaRepo.findByIdAndEliminadoFalse(marca.getId())).thenReturn(marca);

        Marca response = marcaService.listarMarcaPorId(marca.getId());

        assertNotNull(response);
        assertEquals(marca, response);

    }

    @Test
    @DisplayName("Test para registrar una marca")
    void testRegistrarMarca() {

        Marca marca = new Marca();

        marcaService.registrar(marca);

        // Verifica que el método save del repositorio fue llamado una vez con la entidad correcta
        verify(marcaRepo, times(1)).save(marca);

    }

    @Test
    @DisplayName("Test para actualizar una marca")
    void testActualizarMarca() {

        Marca marca = new Marca();
        marca.setId(1);
        marca.setNombre("Renault");

        marcaService.actualizar(marca.getId(), marca.getNombre(), marca.getImpuesto(), marca.isEliminado());

        // Verifica que el método save del repositorio fue llamado una vez con la entidad correcta
        verify(marcaRepo, times(1)).actualizar(marca.getId(), marca.getNombre(), marca.getImpuesto(), marca.isEliminado());
    }

    @Test
    @DisplayName("Test para eliminar una marca")
    void testEliminarMarca() {

        Marca marca = new Marca();
        marca.setId(1);

        marcaService.eliminar(marca.getId());

        verify(marcaRepo, times(1)).eliminar(marca.getId());
    }



}
