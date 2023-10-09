package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.service.IMarcaService;
import com.example.API.Taller.Mecanico.service.IModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    IModeloService serviceModelo;

    @Autowired
    IMarcaService serviceMarca;


    @GetMapping
    public ResponseEntity<List<Modelo>> listarModelos() {
        List<Modelo> modelos = serviceModelo.listarModelos();

        return new ResponseEntity<List<Modelo>>(modelos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody Modelo modelo) {

        if(serviceMarca.listarMarcaPorId(modelo.getIdMarca()) != null) {
            Modelo resModelo = serviceModelo.registrar(modelo);
            return new ResponseEntity<>(resModelo, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().body("No se encontró una marca con ese ID");
        }

    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Modelo modelo) {

        if(serviceMarca.listarMarcaPorId(modelo.getIdMarca()) != null) {
            serviceModelo.actualizar(id, modelo.getNombre(), modelo.getIdMarca());
            return ResponseEntity.ok("El vehiculo se actualizo correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se encontró una marca con ese ID");
        }

    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) {
        serviceModelo.eliminar(id);

        return ResponseEntity.ok("El modelo se elimino correctamente");
    }
}
