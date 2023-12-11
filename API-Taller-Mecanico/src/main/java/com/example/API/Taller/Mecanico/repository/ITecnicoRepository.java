// esta 
package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITecnicoRepository extends JpaRepository<Tecnico, Integer> {

    List<Tecnico> findByEliminadoFalse();

    Tecnico findByIdAndEliminadoFalse(Integer tecnicoId);

    @Modifying
    @Query("UPDATE Tecnico t SET t.nombre = :nombre, t.apellido = :apellido, t.documento = :documento, t.telefono = :telefono, t.direccion = :direccion WHERE t.id = :tecnicoId")
    void actualizar(@Param("tecnicoId") Integer tecnicoId, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("documento") String documento, @Param("telefono") String telefono, @Param("direccion") String direccion);

    @Modifying
    @Query("UPDATE Tecnico t SET t.eliminado = true WHERE t.id = :tecnicoId")
    void eliminar(@Param("tecnicoId") Integer tecnicoId);

    @Query(
        "SELECT t FROM Tecnico t " +
        "WHERE (:nombre IS NULL OR t.nombre LIKE %:nombre%) " +
        "AND (:apellido IS NULL OR t.apellido LIKE %:apellido%) " +
        "AND (:documento IS NULL OR t.documento LIKE %:documento%) " +
        "AND (:telefono IS NULL OR t.telefono LIKE %:telefono%) " +
        "AND (:direccion IS NULL OR t.direccion LIKE %:direccion%) " +
        "AND t.eliminado = false")
    List<Tecnico> findByParams(String nombre, String apellido, String documento, String telefono, String direccion);
}
