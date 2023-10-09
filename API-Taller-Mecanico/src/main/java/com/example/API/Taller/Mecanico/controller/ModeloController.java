package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.service.IMarcaService;
import com.example.API.Taller.Mecanico.service.IModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    IModeloService serviceModelo;

    @GetMapping
    public ResponseEntity<List<Modelo>> listarModelos(@RequestParam(name = "select", required = false, defaultValue = "false") boolean select) {
        List<Modelo> modelos = serviceModelo.listarModelos();

        for (Modelo modelo : modelos) {
            Marca marca = new Marca();
            marca.setId(modelo.getMarca().getId());
            marca.setDescripcion(modelo.getMarca().getNombre());
            modelo.setMarca(marca);
        }

        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<Modelo> modelosConCamposSelect = new ArrayList<>();
            for (Modelo modelo : modelos) {
                Modelo modeloConCamposSelect = new Modelo();
                modeloConCamposSelect.setId(modelo.getId());
                modeloConCamposSelect.setDescripcion(modelo.getNombre());
                modelosConCamposSelect.add(modeloConCamposSelect);
            }

            return new ResponseEntity<List<Modelo>>(modelosConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de técnicos sin formato
            return new ResponseEntity<List<Modelo>>(modelos, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody Modelo modelo) {
    Modelo resModelo = serviceModelo.registrar(modelo);
    return new ResponseEntity<>(resModelo, HttpStatus.CREATED);
}



    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Modelo modelo) {

       serviceModelo.actualizar(id, modelo.getNombre());
       return ResponseEntity.ok("El modelo se actualizo correctamente");
    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) {
        serviceModelo.eliminar(id);

        return ResponseEntity.ok("El modelo se elimino correctamente");
    }
}
