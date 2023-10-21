package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.service.IMarcaService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marcas")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarcaController {

    @Autowired
    IMarcaService serviceMarca;

    @GetMapping
    public ResponseEntity<List<Marca>> listarMarcas(@RequestParam(name = "select", required = false, defaultValue = "false") boolean select) {
        List<Marca> marcas = serviceMarca.listarMarcas();

        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<Marca> marcasConCamposSelect = new ArrayList<>();
            for (Marca marca : marcas) {
                Marca marcaConCamposSelect = new Marca();
                marcaConCamposSelect.setId(marca.getId());
                marcaConCamposSelect.setDescripcion(marca.getNombre());
                marcasConCamposSelect.add(marcaConCamposSelect);
            }

            return new ResponseEntity<List<Marca>>(marcasConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de técnicos sin formato
            return new ResponseEntity<List<Marca>>(marcas, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Marca> registrar(@RequestBody Marca reqMarca) {
        System.out.println(reqMarca);
        Marca resMarca = serviceMarca.registrar(reqMarca);

        return new ResponseEntity<Marca>(resMarca, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Marca marca) {

        serviceMarca.actualizar(id, marca.getNombre());

       return ResponseEntity.ok("La marca se actualizo correctamente");
    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceMarca.eliminar(id);
    }

}