package com.example.API.Taller.Mecanico.controller;


import com.example.API.Taller.Mecanico.model.*;
import com.example.API.Taller.Mecanico.service.IClienteService;
import com.example.API.Taller.Mecanico.service.IVehiculoService;
import com.example.API.Taller.Mecanico.service.IVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitas")
public class VisitaController {

    @Autowired
    IVisitaService serviceVisita;

    @Autowired
    IClienteService serviceCliente;

    @GetMapping
    public ResponseEntity<List<Visita>> listarVisitas() {
        List<Visita> visitas = serviceVisita.listarVisitas();

            for (Visita visita : visitas) {
                    Cliente cliente = new Cliente();
                    cliente.setId(visita.getCliente().getId());
                    cliente.setDescripcion(visita.getCliente().getNombre());
                    visita.setCliente(cliente);
            }

        return new ResponseEntity<List<Visita>>(visitas, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody Visita visita) {

      Visita resVisita = serviceVisita.registrar(visita);
      return new ResponseEntity<>(resVisita, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Visita visita) {

        serviceVisita.actualizar(id, visita.getFechaVisita());
        return ResponseEntity.ok("La visita se actualizo correctamente");

    }

    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) {
        serviceVisita.eliminar(id);

        return ResponseEntity.ok("La visita se elimino correctamente");
    }
}
