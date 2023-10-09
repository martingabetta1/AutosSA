package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Vehiculo;
import com.example.API.Taller.Mecanico.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IVisitaRepository extends JpaRepository<Visita, Integer> {

    List<Visita> findByEliminadoFalse();

    @Modifying
    @Query("UPDATE Visita v SET v.fechaVisita = :fechaVisita WHERE v.id = :visitaId")
    void actualizar(@Param("visitaId") Integer visitaId, @Param("fechaVisita") Date fechaVisita);

    @Modifying
    @Query("UPDATE Visita v SET v.eliminado = true WHERE v.id = :visitaId")
    void eliminar(@Param("visitaId") Integer visitaId);
}
