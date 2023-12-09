package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.OrdenTrabajo;
import com.example.API.Taller.Mecanico.model.Servicio;
import com.example.API.Taller.Mecanico.model.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServicioRepository extends JpaRepository<Servicio, Integer> {

    List<Servicio> findByEliminadoFalse();
    List<Servicio> findByOrdenTrabajoIdAndEliminadoFalse(Integer idOrden);

    @Modifying
    @Query("UPDATE Servicio s SET s.tipoServicio = :tipoServicio, s.precio = :precio, s.ordenTrabajo = :ordenTrabajo WHERE s.id = :servicioId")
    void actualizarServicio(@Param("servicioId") Integer servicioId, @Param("tipoServicio") String tipoServicio, @Param("precio") Double precio, @Param("ordenTrabajo") OrdenTrabajo ordenTrabajo);

    @Modifying
    @Query("UPDATE Servicio s SET s.eliminado = true WHERE s.id = :servicioId")
    void eliminar(@Param("servicioId") Integer servicioId);

    @Query("SELECT s, o.id, o.comentario FROM Servicio s " +
    "INNER JOIN s.ordenTrabajo o " +
    "WHERE (:precio IS NULL OR s.precio BETWEEN :precio - 1000 AND :precio + 1000) " +
    "AND (:tipoServicio IS NULL OR s.tipoServicio LIKE %:tipoServicio%) " +
    "AND (:ordenId IS NULL OR o.id = :ordenId) " +
    "AND (:ordenComentario IS NULL OR o.comentario LIKE %:ordenComentario%)")
    List<Servicio> findByParams(String tipoServicio, Double precio, Integer ordenId, String ordenComentario);

}
