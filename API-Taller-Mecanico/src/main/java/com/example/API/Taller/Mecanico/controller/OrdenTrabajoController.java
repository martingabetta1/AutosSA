package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.*;
import com.example.API.Taller.Mecanico.service.IOrdenTrabajoService;
import com.example.API.Taller.Mecanico.service.IServicioService;
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

    @Autowired
    IServicioService serviceServicio;

    @GetMapping
    public ResponseEntity<List<OrdenTrabajo>> listarOrdenes(
            @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
            @RequestParam(name = "ordenId", required = false) Integer ordenId,
            @RequestParam(name = "fechaInicio", required = false) String fechaInicio,
            @RequestParam(name = "fechaFin", required = false) String fechaFin,
            @RequestParam(name = "vehiculo", required = false) String vehiculo,
            @RequestParam(name = "tecnico", required = false) String tecnico,
            @RequestParam(name = "estado", required = false) String estado,
            @RequestParam(name = "comentario", required = false) String comentario,
            @RequestParam(name = "cliente", required = false) String cliente) {
        List<OrdenTrabajo> ordenes = serviceOrden.listarOrdenes();

        if (ordenId != null || fechaInicio != null || fechaFin != null || vehiculo != null || tecnico != null
                || estado != null || comentario != null || cliente != null) {
            List<OrdenTrabajo> buscarOrdenes = serviceOrden.listarOrdenesPorConsultaAnidada(ordenId, fechaInicio,
                    fechaFin, vehiculo, tecnico, estado, comentario, cliente);
            List<OrdenTrabajo> ordenesConFiltro = new ArrayList<>();
            for (OrdenTrabajo orden : buscarOrdenes) {
                OrdenTrabajo ordenFiltrada = new OrdenTrabajo();
                Vehiculo vehiculoObj = new Vehiculo();
                Estado estadoObj = new Estado();
                Cliente clienteObj = new Cliente();
                Tecnico tecnicoObj = new Tecnico();
                vehiculoObj.setId(orden.getVehiculo().getId());
                clienteObj.setId(orden.getCliente().getId());
                tecnicoObj.setId(orden.getTecnico().getId());
                estadoObj.setId(orden.getEstado().getId());
                vehiculoObj.setDescripcion(orden.getVehiculo().getPatente());
                clienteObj.setDescripcion(orden.getCliente().getNombre() + ' ' + orden.getCliente().getApellido());
                tecnicoObj.setDescripcion(orden.getTecnico().getNombre() + ' ' + orden.getTecnico().getApellido());
                estadoObj.setDescripcion(orden.getEstado().getNombre());
                ordenFiltrada.setCliente(clienteObj);
                ordenFiltrada.setEstado(estadoObj);
                ordenFiltrada.setVehiculo(vehiculoObj);
                ordenFiltrada.setTecnico(tecnicoObj);
                ordenFiltrada.setId(orden.getId());
                ordenFiltrada.setComentario(orden.getComentario());
                ordenFiltrada.setFechaFin(orden.getFechaFin());
                ordenFiltrada.setFechaInicio(orden.getFechaInicio());
                List<Servicio> serviciosPorOrden = serviceServicio.listarServiciosPorOrden(orden.getId());
                Double total = 0.0;
                for (Servicio servicio : serviciosPorOrden) {
                    total = 0.0;
                    total += servicio.getPrecio();
                }
                ordenFiltrada.setTotalCosto(total);

                ordenesConFiltro.add(ordenFiltrada);
            }
            return new ResponseEntity<List<OrdenTrabajo>>(ordenesConFiltro, HttpStatus.OK);
        }
        ;

        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<OrdenTrabajo> ordenesConCamposSelect = new ArrayList<>();
            for (OrdenTrabajo orden : ordenes) {
                OrdenTrabajo ordenConCamposSelect = new OrdenTrabajo();
                ordenConCamposSelect.setId(orden.getId());
                ordenConCamposSelect.setDescripcion(orden.getId().toString() + " (" + orden.getComentario() + ")");
                ordenesConCamposSelect.add(ordenConCamposSelect);
            }

            return new ResponseEntity<List<OrdenTrabajo>>(ordenesConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de técnicos sin formato
            for (OrdenTrabajo orden : ordenes) {
                Vehiculo vehiculoObj = new Vehiculo();
                vehiculoObj.setId(orden.getVehiculo().getId());
                vehiculoObj.setDescripcion(orden.getVehiculo().getPatente());
                vehiculoObj.setModelo(orden.getVehiculo().getModelo());
                orden.setVehiculo(vehiculoObj);

                Tecnico tecnicoObj = new Tecnico();
                tecnicoObj.setId(orden.getTecnico().getId());
                tecnicoObj.setDescripcion(orden.getTecnico().getNombre() + ' ' + orden.getTecnico().getApellido());
                orden.setTecnico(tecnicoObj);

                Cliente clienteObj = new Cliente();
                clienteObj.setId(orden.getCliente().getId());
                clienteObj.setDireccion(orden.getCliente().getDireccion());
                clienteObj.setLocalidad(orden.getCliente().getLocalidad());
                clienteObj.setDescripcion(orden.getCliente().getNombre() + ' ' + orden.getCliente().getApellido());
                orden.setCliente(clienteObj);

                Estado estadoObj = new Estado();
                estadoObj.setId(orden.getEstado().getId());
                estadoObj.setDescripcion(orden.getEstado().getNombre());
                orden.setEstado(estadoObj);

                List<Servicio> serviciosPorOrden = serviceServicio.listarServiciosPorOrden(orden.getId());
                Double total = 0.0;
                for (Servicio servicio : serviciosPorOrden) {
                    total = 0.0;
                    total += servicio.getPrecio();
                }
                orden.setTotalCosto(total);
            }
            return new ResponseEntity<List<OrdenTrabajo>>(ordenes, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody OrdenTrabajo ordenTrabajo) {

        OrdenTrabajo resOrden = serviceOrden.registrar(ordenTrabajo);

        return new ResponseEntity<>(resOrden, HttpStatus.CREATED);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody OrdenTrabajo ordenTrabajo) {

        serviceOrden.actualizar(id, ordenTrabajo.getFechaInicio(), ordenTrabajo.getFechaFin(),
                ordenTrabajo.getVehiculo(), ordenTrabajo.getTecnico(), ordenTrabajo.getEstado(),
                ordenTrabajo.getComentario(), ordenTrabajo.getCliente());
        return ResponseEntity.ok("La orden de trabajo se actualizo correctamente");
    }

    // Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        serviceOrden.eliminar(id);

        return ResponseEntity.ok("La orden se elimino correctamente");
    }
}
