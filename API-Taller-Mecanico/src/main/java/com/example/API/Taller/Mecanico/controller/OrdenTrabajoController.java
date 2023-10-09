package com.example.API.Taller.Mecanico.controller;


import com.example.API.Taller.Mecanico.model.*;
import com.example.API.Taller.Mecanico.service.IOrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenTrabajoController {

    @Autowired
    IOrdenTrabajoService serviceOrden;

    @GetMapping
    public ResponseEntity<List<OrdenTrabajo>> listarOrdenes(@RequestParam(name = "select", required = false, defaultValue = "false") boolean select) {
        List<OrdenTrabajo> ordenes = serviceOrden.listarOrdenes();

        for (OrdenTrabajo orden : ordenes) {
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setId(orden.getVehiculo().getId());
            vehiculo.setDescripcion(orden.getVehiculo().getModelo().getNombre());
            orden.setVehiculo(vehiculo);

            Tecnico tecnico = new Tecnico();
            tecnico.setId(orden.getTecnico().getId());
            tecnico.setDescripcion(orden.getTecnico().getNombre());
            orden.setTecnico(tecnico);

            Estado estado = new Estado();
            estado.setId(orden.getEstado().getId());
            estado.setDescripcion(orden.getEstado().getNombre().toString());
            orden.setEstado(estado);
        }

        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<OrdenTrabajo> ordenesConCamposSelect = new ArrayList<>();
            for (OrdenTrabajo orden : ordenes) {
                OrdenTrabajo ordenConCamposSelect = new OrdenTrabajo();
                ordenConCamposSelect.setId(orden.getId());
                ordenConCamposSelect.setDescripcion(orden.getComentario());
                ordenesConCamposSelect.add(ordenConCamposSelect);
            }

            return new ResponseEntity<List<OrdenTrabajo>>(ordenesConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de técnicos sin formato
            return new ResponseEntity<List<OrdenTrabajo>>(ordenes, HttpStatus.OK);
        }
    }


    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody OrdenTrabajo ordenTrabajo) {

        OrdenTrabajo resOrden = serviceOrden.registrar(ordenTrabajo);

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(resOrden.getVehiculo().getId());
        vehiculo.setDescripcion(resOrden.getVehiculo().getModelo().getNombre());

        Tecnico tecnico = new Tecnico();
        tecnico.setId(resOrden.getTecnico().getId());
        tecnico.setDescripcion(resOrden.getTecnico().getNombre());

        Cliente cliente = new Cliente();
        cliente.setId(resOrden.getCliente().getId());
        cliente.setDescripcion(resOrden.getCliente().getNombre());

        resOrden.setCliente(cliente);
        return new ResponseEntity<>(resOrden, HttpStatus.CREATED);

    }


    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody OrdenTrabajo ordenTrabajo) {

        serviceOrden.actualizar(id, ordenTrabajo.getFechaInicio(), ordenTrabajo.getFechaFin(), ordenTrabajo.getVehiculo(), ordenTrabajo.getTecnico(), ordenTrabajo.getEstado(), ordenTrabajo.getComentario(), ordenTrabajo.getCliente());
        return ResponseEntity.ok("La orden de trabajo se actualizo correctamente");
    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) {
        serviceOrden.eliminar(id);

        return ResponseEntity.ok("La orden se elimino correctamente");
    }
}
