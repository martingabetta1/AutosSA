<<<<<<< HEAD
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


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Vehiculo vehiculo) {

        if(serviceCliente.listarClientePorId(vehiculo.getIdCliente()) != null) {
            serviceVehiculo.actualizar(id, vehiculo.getPatente(), vehiculo.getObservaciones(), vehiculo.getAnio(), vehiculo.getKilometros(), vehiculo.getIdCliente());
            return ResponseEntity.ok("El vehiculo se actualizo correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se encontró un cliente con ese ID");
        }

    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) {
        serviceVehiculo.eliminar(id);

        return ResponseEntity.ok("El vehiculo se elimino correctamente");
    }

}
=======
package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Modelo;
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

        for (Vehiculo vehiculo : vehiculos) {
            Cliente cliente = new Cliente();
            cliente.setId(vehiculo.getCliente().getId());
            cliente.setDescripcion(vehiculo.getCliente().getNombre());
            vehiculo.setCliente(cliente);

            Modelo modelo = new Modelo();
            modelo.setId(vehiculo.getModelo().getId());
            modelo.setDescripcion(vehiculo.getModelo().getNombre());
            vehiculo.setModelo(modelo);
        }

        return new ResponseEntity<List<Vehiculo>>(vehiculos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody Vehiculo vehiculo) {

        Vehiculo resVehiculo = serviceVehiculo.registrar(vehiculo);

        Cliente cliente = new Cliente();
        cliente.setId(resVehiculo.getCliente().getId());
        cliente.setDescripcion(resVehiculo.getCliente().getNombre());

        resVehiculo.setCliente(cliente);

        Modelo modelo = new Modelo();
        modelo.setId(resVehiculo.getModelo().getId());
        modelo.setDescripcion(resVehiculo.getModelo().getNombre());

        resVehiculo.setModelo(modelo);

        return new ResponseEntity<>(resVehiculo, HttpStatus.CREATED);

    }

    @PutMapping("/actualiza/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Vehiculo vehiculo) {

        serviceVehiculo.actualizar(id, vehiculo.getPatente(), vehiculo.getObservaciones(), vehiculo.getAnio(), vehiculo.getKilometros());
        return ResponseEntity.ok("El vehiculo se actualizo correctamente");

    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) {
        serviceVehiculo.eliminar(id);

        return ResponseEntity.ok("El vehiculo se elimino correctamente");
    }

}
>>>>>>> origin/backend
