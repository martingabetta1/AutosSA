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

    @Modifying
    @Query("UPDATE OrdenTrabajo o SET o.fechaInicio = :fechaInicio, o.fechaFin = :fechaFin, o.estado = :estado, o.comentario = :comentario, o.cliente =:cliente, o.vehiculo = :vehiculo, o.tecnico = :tecnico WHERE o.id = :ordenId")
    void actualizarOrden(@Param("ordenId") Integer ordenId, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("estado") String estado, @Param("comentario") String comentario, @Param("cliente") Cliente cliente, @Param("vehiculo") Vehiculo vehiculo, @Param("tecnico") Tecnico tecnico );

    @Modifying
    @Query("UPDATE OrdenTrabajo o SET o.eliminado = true WHERE o.id = :ordenId")
    void eliminar(@Param("ordenId") Integer ordenId);
}
