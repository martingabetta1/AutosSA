package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Vehiculo;
import com.example.API.Taller.Mecanico.service.IClienteService;
import com.example.API.Taller.Mecanico.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService serviceVehiculo;

    @Autowired
    IClienteService serviceCliente;

    @GetMapping
    public ResponseEntity<List<Vehiculo>> listarVehiculos() {
        List<Vehiculo> vehiculos = serviceVehiculo.listarVehiculos();

        return new ResponseEntity<List<Vehiculo>>(vehiculos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody Vehiculo vehiculo) {

        if(serviceCliente.listarClientePorId(vehiculo.getIdCliente()) != null) {
            Vehiculo resVehiculo = serviceVehiculo.registrar(vehiculo);
            return new ResponseEntity<>(resVehiculo, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().body("No se encontró un cliente con ese ID");
        }

    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Vehiculo vehiculo) {

        serviceVehiculo.actualizar(vehiculo.getId(), vehiculo.getPatente(), vehiculo.getObservaciones(), vehiculo.getAnio(), vehiculo.getKilometros(), vehiculo.getIdCliente());
        return ResponseEntity.ok("El vehiculo se actualizo correctamente");

    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) {
        serviceVehiculo.eliminar(id);

        return ResponseEntity.ok("El vehiculo se elimino correctamente");
    }

}
