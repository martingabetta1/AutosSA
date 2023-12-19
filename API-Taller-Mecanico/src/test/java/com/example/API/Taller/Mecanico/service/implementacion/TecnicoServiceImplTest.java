package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.Tecnico;

import com.example.API.Taller.Mecanico.repository.ITecnicoRepository;
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

@WebMvcTest(TecnicoServiceImpl.class)
public class TecnicoServiceImplTest {
    @Autowired
    private TecnicoServiceImpl tecnicoService;

    @MockBean
    private ITecnicoRepository tecnicoRepo;


   @Test
   @DisplayName("Test para listar todos los Tecnicos")
   void testListarTecnicos() {

       Tecnico tecnico1 = new Tecnico();
       Tecnico tecnico2 = new Tecnico();

       List<Tecnico> listaTecnicos = Arrays.asList(tecnico1, tecnico2);
       when(tecnicoRepo.findByEliminadoFalse()).thenReturn(listaTecnicos);

       List<Tecnico> response = tecnicoService.listarTecnicos();

       assertNotNull(response);
       assertEquals(listaTecnicos, response);
   }


    @Test
    @DisplayName("Test para listar tecnicos por id")
    void testListarTecnicoPorId() {

        Tecnico tecnico = new Tecnico();
        tecnico.setId(1);
        tecnico.setNombre("Tomas");

        when(tecnicoRepo.findByIdAndEliminadoFalse(tecnico.getId())).thenReturn(tecnico);

        Tecnico response = tecnicoService.listarTecnicoPorId(tecnico.getId());

        assertNotNull(response);
        assertEquals(tecnico, response);

    }

    @Test
    @DisplayName("Test para registrar un tecnico")
    void testRegistrarTecnico() {

        Tecnico tecnico = new Tecnico();

        tecnicoService.registrar(tecnico);

        // Verifica que el método save del repositorio fue llamado una vez con la entidad correcta
        verify(tecnicoRepo, times(1)).save(tecnico);

    }

    @Test
    @DisplayName("Test para actualizar un tecnico")
    void testActualizarTecnico() {

        Tecnico tecnico = new Tecnico();
        tecnico.setId(1);
        tecnico.setNombre("Tomaaas");
        //Integer tecnicoId, String nombre, String apellido, String documento, String telefono, String direccion
        tecnicoService.actualizar(tecnico.getId(), tecnico.getNombre(), tecnico.getApellido(), tecnico.getDocumento(), tecnico.getTelefono(), tecnico.getDireccion());

        // Verifica que el método save del repositorio fue llamado una vez con la entidad correcta
        verify(tecnicoRepo, times(1)).actualizar(tecnico.getId(), tecnico.getNombre(), tecnico.getApellido(), tecnico.getDocumento(), tecnico.getTelefono(), tecnico.getDireccion());
    }

    @Test
    @DisplayName("Test para eliminar un tecnico")
    void testEliminarTecnico() {

        Tecnico tecnico = new Tecnico();
        tecnico.setId(1);

        tecnicoService.eliminar(tecnico.getId());

        verify(tecnicoRepo, times(1)).eliminar(tecnico.getId());
    }



}
