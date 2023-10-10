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
    @Query("UPDATE OrdenTrabajo o SET o.fechaInicio = :fechaInicio, o.fechaFin = :fechaFin, o.vehiculo = :vehiculo, o.tecnico = :tecnico, o.estado = :estado, o.comentario = :comentario, o.cliente = :cliente WHERE o.id = :ordenId")
    void actualizar(@Param("ordenId") Integer odrdenId, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("vehiculo") Vehiculo vehiculo, @Param("tecnico") Tecnico tecnico, @Param("estado") String estado, @Param("comentario") String comentario, @Param("cliente") Cliente cliente);

    @Modifying
    @Query("UPDATE OrdenTrabajo o SET o.eliminado = true WHERE o.id = :ordenId")
    void eliminar(@Param("ordenId") Integer ordenId);
}
