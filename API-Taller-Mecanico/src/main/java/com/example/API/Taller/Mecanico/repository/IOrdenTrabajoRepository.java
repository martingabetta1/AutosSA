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
    @Query("UPDATE OrdenTrabajo o SET o.fechaInicio = :fechaInicio, o.fechaFin = :fechaFin, o.estado = :estado, o.comentario = :comentario WHERE o.id = :ordenId")
    void actualizarOrden(@Param("ordenId") Integer ordenId, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("estado") String estado, @Param("comentario") String comentario);

    @Modifying
    @Query("UPDATE Cliente c SET c.nombre = :nombre WHERE c.id = :clienteId")
    void actualizarCliente(@Param("clienteId") Integer clienteId, @Param("nombre") String nombre);

    @Modifying
    @Query("UPDATE Vehiculo v SET v.patente = :patente WHERE v.id = :vehiculoId")
    void actualizarVehiculo(@Param("vehiculoId") Integer vehiculoId, @Param("patente") String patente);

    @Modifying
    @Query("UPDATE Tecnico t SET t.nombre = :nombre WHERE t.id = :tecnicoId")
    void actualizarTecnico(@Param("tecnicoId") Integer tecnicoId, @Param("nombre") String nombre);

    @Modifying
    @Query("UPDATE OrdenTrabajo o SET o.eliminado = true WHERE o.id = :ordenId")
    void eliminar(@Param("ordenId") Integer ordenId);
}
