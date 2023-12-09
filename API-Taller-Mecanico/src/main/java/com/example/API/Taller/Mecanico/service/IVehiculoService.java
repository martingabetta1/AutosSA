package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> listarVehiculos();
    // pantente string, observaciones string, anio integer, kilometros float, cliente cliente, modelo modelo
    List<Vehiculo> listarVehiculosPorConsultaAnidada(String patente, String observaciones, Integer anio, Float kilometros, Cliente cliente, Modelo modelo);

    Vehiculo listarVehiculoPorId(Integer vehiculoId);

    Vehiculo registrar(Vehiculo vehiculo);

    void actualizar(Integer vehiculoId, String patente, String observaciones, Integer anio, Float kilometros, Cliente cliente, Modelo modelo);

    void eliminar(Integer id);
}
