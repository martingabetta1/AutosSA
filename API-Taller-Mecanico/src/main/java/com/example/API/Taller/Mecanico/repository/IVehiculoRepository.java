package com.example.API.Taller.Mecanico.repository;

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
    void actualizarVehiculo(@Param("vehiculoId") Integer vehiculoId, @Param("patente") String patente, @Param("observaciones") String observaciones, @Param("anio") Integer anio, @Param("kilometros") Float kilometros);

    @Modifying
    @Query("UPDATE Cliente c SET c.nombre = :nombre WHERE c.id = :clienteId")
    void actualizarCliente(@Param("clienteId") Integer clienteId, @Param("nombre") String nombre);

    @Modifying
    @Query("UPDATE Modelo mod SET mod.nombre = :nombre WHERE mod.id = :modeloId")
    void actualizarModelo(@Param("modeloId") Integer modeloId, @Param("nombre") String nombre);

    @Modifying
    @Query("UPDATE Vehiculo v SET v.eliminado = true WHERE v.id = :vehiculoId")
    void eliminar(@Param("vehiculoId") Integer vehiculoId);
}
