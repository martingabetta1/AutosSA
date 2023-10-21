package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Cliente;
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
    @Query("UPDATE Vehiculo v SET v.patente = :patente, v.observaciones = :observaciones, v.anio = :anio, v.kilometros = :kilometros WHERE v.id = :vehiculoId")
    void actualizar(@Param("vehiculoId") Integer vehiculoId, @Param("patente") String patente, @Param("observaciones") String observaciones, @Param("anio") Integer anio, @Param("kilometros") Float kilometros);

    @Modifying
    @Query("UPDATE Vehiculo v SET v.eliminado = true WHERE v.id = :vehiculoId")
    void eliminar(@Param("vehiculoId") Integer vehiculoId);
}
