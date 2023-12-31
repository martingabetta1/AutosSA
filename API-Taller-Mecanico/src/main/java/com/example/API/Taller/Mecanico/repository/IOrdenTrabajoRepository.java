package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IOrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Integer> {

    List<OrdenTrabajo> findByEliminadoFalse();
    List<OrdenTrabajo> findByFechaInicioBetween(Date fechaInicio, Date fechaFin);


    @Query("SELECT MAX(o.fechaInicio) FROM OrdenTrabajo o WHERE o.cliente.id = :clienteId")
    Date findUltimaFechaInicioPorCliente(@Param("clienteId") Integer clienteId);

    @Modifying
    @Query("UPDATE OrdenTrabajo o SET o.fechaInicio = :fechaInicio, o.fechaFin = :fechaFin, o.estado = :estado, o.comentario = :comentario, o.cliente =:cliente, o.vehiculo = :vehiculo, o.tecnico = :tecnico WHERE o.id = :ordenId")
    void actualizarOrden(@Param("ordenId") Integer ordenId, @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin, @Param("estado") Estado estado, @Param("comentario") String comentario,
            @Param("cliente") Cliente cliente, @Param("vehiculo") Vehiculo vehiculo, @Param("tecnico") Tecnico tecnico);

    @Modifying
    @Query("UPDATE OrdenTrabajo o SET o.eliminado = true WHERE o.id = :ordenId")
    void eliminar(@Param("ordenId") Integer ordenId);

    @Query("SELECT o, v.patente, t.nombre, e.nombre, c.nombre FROM OrdenTrabajo o " +
            "LEFT JOIN o.vehiculo v " +
            "LEFT JOIN o.tecnico t " +
            "LEFT JOIN o.cliente c " +
            "LEFT JOIN o.estado e " +
            "WHERE (:comentario IS NULL OR o.comentario LIKE %:comentario%) " +
            "AND (:cliente IS NULL OR c.nombre LIKE %:cliente%) " +
            "AND (:tecnico IS NULL OR t.nombre LIKE %:tecnico%)" +
            "AND (:estado IS NULL OR e.nombre LIKE %:estado%)" +
            "AND (:fechaInicio IS NULL OR o.fechaInicio = TO_DATE(:fechaInicio, 'dd-MM-yyyy'))" +
            "AND (:fechaFin IS NULL OR o.fechaFin = TO_DATE(:fechaFin, 'dd-MM-yyyy'))" +
            "AND (:vehiculo IS NULL OR v.patente LIKE %:vehiculo%)")
    List<OrdenTrabajo> findByParams(String vehiculo,
            String tecnico, String estado, String comentario, String cliente, String fechaInicio, String fechaFin);
}
