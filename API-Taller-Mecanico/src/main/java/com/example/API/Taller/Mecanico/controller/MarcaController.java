package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.service.IMarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    IMarcaService serviceMarca;

    @GetMapping
    public ResponseEntity<List<Marca>> listarMarcas() {
        List<Marca> marcas = serviceMarca.listarMarcas();

        return new ResponseEntity<List<Marca>>(marcas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Marca> registrar(@RequestBody Marca reqMarca) {

        Marca resMarca = serviceMarca.registrar(reqMarca);

        return new ResponseEntity<Marca>(resMarca, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Marca> actualizar(@RequestBody Marca reqMarca) {

        Marca resMarca = serviceMarca.actualizar(reqMarca);

        return new ResponseEntity<>(resMarca, HttpStatus.CREATED);
    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceMarca.eliminar(id);
    }


}