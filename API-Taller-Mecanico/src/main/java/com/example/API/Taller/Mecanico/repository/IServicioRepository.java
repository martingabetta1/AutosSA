package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.OrdenTrabajo;
import com.example.API.Taller.Mecanico.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServicioRepository extends JpaRepository<Servicio, Integer> {

    List<Servicio> findByEliminadoFalse();
    List<Servicio> findByOrdenTrabajoIdAndEliminadoFalse(Integer idOrden);

    @Modifying
    @Query("UPDATE Servicio s SET s.tipoServicio = :tipoServicio, s.precio = :precio WHERE s.id = :servicioId")
    void actualizarServicio(@Param("servicioId") Integer servicioId, @Param("tipoServicio") String tipoServicio, @Param("precio") Double precio);

    @Modifying
    @Query("UPDATE OrdenTrabajo o SET o.comentario = :comentario WHERE o.id = :ordenId")
    void actualizarOrden(@Param("ordenId") Integer ordenId, @Param("comentario") String comentario);


    @Modifying
    @Query("UPDATE Servicio s SET s.eliminado = true WHERE s.id = :servicioId")
    void eliminar(@Param("servicioId") Integer servicioId);

}
