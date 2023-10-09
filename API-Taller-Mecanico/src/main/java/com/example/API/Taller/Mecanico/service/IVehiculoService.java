package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Vehiculo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> listarVehiculos();

    Vehiculo registrar(Vehiculo vehiculo);

    void actualizar(Integer vehiculoId, String patente, String observaciones, Integer anio, float kilometros, Integer idCliente);

    void eliminar(Integer id);
}
