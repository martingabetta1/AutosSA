package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.model.Vehiculo;
import com.example.API.Taller.Mecanico.repository.IVehiculoRepository;
import com.example.API.Taller.Mecanico.service.IVehiculoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    IVehiculoRepository repoVehiculo;

    @Override
    public List<Vehiculo> listarVehiculos() {
        return repoVehiculo.findByEliminadoFalse();
    }

    @Override
    public Vehiculo listarVehiculoPorId(Integer vehiculoId) {
        return repoVehiculo.findByIdAndEliminadoFalse(vehiculoId);
    }

    @Override
    public Vehiculo registrar(Vehiculo vehiculo) {
        return repoVehiculo.save(vehiculo);
    }


    public void actualizar(Integer vehiculoId, String patente, String observaciones, Integer anio, Float kilometros, Cliente cliente, Modelo modelo) {
        repoVehiculo.actualizarVehiculo(vehiculoId, patente, observaciones, anio, kilometros, cliente, modelo);
    }


    @Override
    public void eliminar(Integer id) {
        repoVehiculo.eliminar(id);
    }
}
