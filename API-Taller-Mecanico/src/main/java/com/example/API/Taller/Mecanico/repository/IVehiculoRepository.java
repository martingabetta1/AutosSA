package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    List<Vehiculo> findByEliminadoFalse();

    Vehiculo findByIdAndEliminadoFalse(Integer vehiculoId);
    
    @Modifying
    @Query("UPDATE Vehiculo v SET v.patente = :patente, v.observaciones = :observaciones, v.anio = :anio, v.kilometros = :kilometros, v.cliente = :cliente, v.modelo = :modelo WHERE v.id = :vehiculoId")
    void actualizarVehiculo(@Param("vehiculoId") Integer vehiculoId, @Param("patente") String patente, @Param("observaciones") String observaciones, @Param("anio") Integer anio, @Param("kilometros") Float kilometros, @Param("cliente") Cliente cliente, @Param("modelo") Modelo modelo);  

    @Modifying
    @Query("UPDATE Vehiculo v SET v.eliminado = true WHERE v.id = :vehiculoId")
    void eliminar(@Param("vehiculoId") Integer vehiculoId);

    @Query("SELECT v FROM Vehiculo v " +
    "WHERE (:patente IS NULL OR v.patente = :patente)" +
    "AND (:observaciones IS NULL OR v.observaciones = :observaciones) " +
    "AND (:anio IS NULL OR v.anio = :anio) " +
    "AND (:kilometros IS NULL OR v.kilometros = :kilometros)" +
    "AND (:cliente IS NULL OR v.cliente = :cliente)" +
    "AND (:modeo IS NULL OR v.modelo = :modelo)")
    List<Vehiculo> findByParams(String patente, String observaciones, Integer anio, Float kilometros, Cliente cliente, Modelo modelo);
}
