package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.model.OrdenTrabajo;
import com.example.API.Taller.Mecanico.model.Servicio;
import com.example.API.Taller.Mecanico.service.IModeloService;
import com.example.API.Taller.Mecanico.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    IServicioService serviceServicio;

    @GetMapping
    public ResponseEntity<List<Servicio>> listarServicio() {
        List<Servicio> servicios = serviceServicio.listarServicios();

        for (Servicio servicio : servicios) {
            OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
            ordenTrabajo.setId(servicio.getOrdenTrabajo().getId());
            ordenTrabajo.setDescripcion(servicio.getOrdenTrabajo().getComentario());
            servicio.setOrdenTrabajo(ordenTrabajo);
        }

        return new ResponseEntity<List<Servicio>>(servicios, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody Servicio servicio) {

        Servicio resServicio = serviceServicio.registrar(servicio);

        return new ResponseEntity<>(resServicio, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Servicio servicio) {

        serviceServicio.actualizar(id, servicio.getNombre());
        return ResponseEntity.ok("El servicio se actualizo correctamente");
    }

    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) {
        serviceServicio.eliminar(id);

        return ResponseEntity.ok("El servicio se elimino correctamente");
    }
}
