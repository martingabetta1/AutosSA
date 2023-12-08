package com.example.API.Taller.Mecanico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.API.Taller.Mecanico.model.Impuesto;

@Repository
public interface IImpuestoRepository extends JpaRepository<Impuesto, Integer> {

    List<Impuesto> findByEliminadoFalse();

    Impuesto findByIdAndEliminadoFalse(Integer marcaId);

    @Modifying
    @Query("UPDATE Impuesto i SET i.nombre = :nombre, i.porcentaje = :porcentaje WHERE i.id = :impuestoId")
    void actualizar(@Param("impuestoId") Integer marcaId, @Param("nombre") String nombre, @Param("porcentaje") Integer porcentaje);

    @Modifying
    @Query("UPDATE Impuesto i SET i.eliminado = true WHERE i.id = :impuestoId")
    void eliminar(@Param("impuestoId") Integer impuestoId);
}
