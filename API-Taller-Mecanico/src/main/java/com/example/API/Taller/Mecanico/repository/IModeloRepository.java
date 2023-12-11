package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.model.Modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IModeloRepository extends JpaRepository<Modelo, Integer> {

    List<Modelo> findByEliminadoFalse();

    Modelo findByIdAndEliminadoFalse(Integer modeloId);

    @Modifying
    @Query("UPDATE Modelo mod SET mod.nombre = :nombre, mod.marca = :marca WHERE mod.id = :modeloId")
    void actualizarModelo(@Param("modeloId") Integer modeloId, @Param("nombre") String nombre, @Param("marca") Marca marca);

    @Modifying
    @Query("UPDATE Modelo m SET m.eliminado = true WHERE m.id = :modeloId")
    void eliminar(@Param("modeloId") Integer modeloId);

    //aca modelo es "mo" y marca es "ma"
    @Query("SELECT mo, ma.nombre FROM Modelo mo " +
    "LEFT JOIN mo.marca ma " +
    "WHERE (:nombre IS NULL OR mo.nombre LIKE %:nombre%) " +
    "AND (:marca IS NULL OR m.nombre LIKE %:marca%)")
    List<Modelo> findByParams(String nombre, String marca);

}
