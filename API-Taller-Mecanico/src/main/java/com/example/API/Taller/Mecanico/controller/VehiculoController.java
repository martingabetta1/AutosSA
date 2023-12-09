package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.*;
import com.example.API.Taller.Mecanico.service.IClienteService;
import com.example.API.Taller.Mecanico.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService serviceVehiculo;

    @Autowired
    IClienteService serviceCliente;
    // pantente string, observaciones string, anio integer, kilometros float, cliente cliente, modelo modelo
    @GetMapping
    public ResponseEntity<List<Vehiculo>> listarVehiculos(
            @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
            @RequestParam(name = "patente", required = false) String patente,
            @RequestParam(name = "observaciones", required = false) String observaciones,
            @RequestParam(name = "anio", required = false) Integer anio,
            @RequestParam(name = "kilometros", required = false) Float kilometros,
            @RequestParam(name = "cliente", required = false) String cliente,
            @RequestParam(name = "modelo", required = false) String modelo) {
        List<Vehiculo> vehiculos = serviceVehiculo.listarVehiculos();
        if(patente != null || observaciones != null || anio != null || kilometros != null || cliente != null || modelo != null){
            List<Vehiculo> buscarVehiculos = serviceVehiculo.listarVehiculosPorConsultaAnidada(patente, observaciones, anio, kilometros, cliente, modelo);
            List<Vehiculo> vehiculosConFiltro = new ArrayList<>();
            for(Vehiculo vehiculo : buscarVehiculos){
                Vehiculo vehiculoFiltrado = new Vehiculo();
                Modelo modeloObj = new Modelo();
                Cliente clienteObj = new Cliente();
                modeloObj.setId(vehiculo.getModelo().getId());
                clienteObj.setId(vehiculo.getCliente().getId());
                modeloObj.setDescripcion(vehiculo.getModelo().getNombre());
                clienteObj.setDescripcion(vehiculo.getCliente().getNombre() + ' ' + vehiculo.getCliente().getApellido());
                vehiculoFiltrado.setCliente(clienteObj);
                vehiculoFiltrado.setModelo(modeloObj);
                vehiculoFiltrado.setId(vehiculo.getId());
                vehiculoFiltrado.setPatente(vehiculo.getPatente());
                vehiculoFiltrado.setObservaciones(vehiculo.getObservaciones());
                vehiculoFiltrado.setAnio(vehiculo.getAnio());
                vehiculoFiltrado.setKilometros(vehiculo.getKilometros());

                vehiculosConFiltro.add(vehiculoFiltrado); 
            }
            return new ResponseEntity<List<Vehiculo>>(vehiculosConFiltro, HttpStatus.OK);
        };

       for (Vehiculo vehiculo : vehiculos) {
           Modelo modeloObj = new Modelo();
           modeloObj.setId(vehiculo.getModelo().getId());
           modeloObj.setDescripcion(vehiculo.getModelo().getNombre());
           vehiculo.setModelo(modeloObj);
           Cliente clienteObj = new Cliente();
           clienteObj.setId(vehiculo.getCliente().getId());
           clienteObj.setDescripcion(vehiculo.getCliente().getNombre() + ' ' + vehiculo.getCliente().getApellido());
           vehiculo.setCliente(clienteObj);
       }

        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<Vehiculo> vehiculosConCamposSelect = new ArrayList<>();
            for (Vehiculo vehiculo : vehiculos) {
                Vehiculo vehiculoConCamposSelect = new Vehiculo();
                vehiculoConCamposSelect.setId(vehiculo.getId());
                vehiculoConCamposSelect.setDescripcion(vehiculo.getPatente());
                vehiculosConCamposSelect.add(vehiculoConCamposSelect);
            }
            return new ResponseEntity<List<Vehiculo>>(vehiculosConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de técnicos sin formato
            return new ResponseEntity<List<Vehiculo>>(vehiculos, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody Vehiculo vehiculo) {

        Vehiculo resVehiculo = serviceVehiculo.registrar(vehiculo);

        return new ResponseEntity<>(resVehiculo, HttpStatus.CREATED);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Vehiculo vehiculo) {
        serviceVehiculo.actualizar(id, vehiculo.getPatente(), vehiculo.getObservaciones(), vehiculo.getAnio(), vehiculo.getKilometros(), vehiculo.getCliente(), vehiculo.getModelo());
        return ResponseEntity.ok("El vehiculo se actualizo correctamente");

    }

    // Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        serviceVehiculo.eliminar(id);

        return ResponseEntity.ok("El vehiculo se elimino correctamente");
    }

}
