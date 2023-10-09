package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITecnicoRepository extends JpaRepository<Tecnico, Integer> {

    List<Tecnico> findByEliminadoFalse();

    @Modifying
    @Query("UPDATE Tecnico t SET t.nombre = :nombre, t.apellido = :apellido, t.direccion = :direccion, t.telefono = :telefono, t.mail = :mail, t.localidad = :localidad WHERE t.id = :tecnicoId")
    void actualizar(@Param("tecnicoId") Integer tecnicoId, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("mail") String mail, @Param("localidad") String localidad);

    @Modifying
    @Query("UPDATE Tecnico t SET t.eliminado = true WHERE t.id = :tecnicoId")
    void eliminar(@Param("tecnicoId") Integer tecnicoId);
}
