package com.example.API.Taller.Mecanico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API.Taller.Mecanico.model.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Integer> {

    List<Marca> findByEliminadoFalse();
    List<Marca> findByEliminadoTrue();

    Marca findByIdAndEliminadoFalse(Integer marcaId);

    @Modifying
    @Query("UPDATE Marca m SET m.nombre = :nombre, m.impuesto = :impuesto WHERE m.id = :marcaId")
    void actualizar(@Param("marcaId") Integer marcaId, @Param("nombre") String nombre, @Param("impuesto") Impuesto impuesto);

    @Modifying
    @Query("UPDATE Marca m SET m.eliminado = true WHERE m.id = :marcaId")
    void eliminar(@Param("marcaId") Integer marcaId);

    @Query("SELECT m, i.nombre FROM Marca m " +
    "INNER JOIN m.impuesto i " +
    "WHERE (:nombre IS NULL OR m.nombre LIKE %:nombre%) " +
    "AND (:impuesto IS NULL OR i.nombre LIKE %:impuesto%)")
    List<Marca> findByParams(String nombre, String impuesto);

}