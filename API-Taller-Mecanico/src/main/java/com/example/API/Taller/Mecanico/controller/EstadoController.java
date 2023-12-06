package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Estado;
import com.example.API.Taller.Mecanico.service.IEstadoService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estados")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstadoController {

    @Autowired
    IEstadoService serviceEstado;

    @GetMapping
    public ResponseEntity<List<Estado>> listarEstados(@RequestParam(name = "select", required = false, defaultValue = "false") boolean select) {
        List<Estado> estados = serviceEstado.listarEstados();

        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<Estado> estadosConCamposSelect = new ArrayList<>();
            for (Estado estado : estados) {
                Estado estadoConCamposSelect = new Estado();
                estadoConCamposSelect.setId(estado.getId());
                estadoConCamposSelect.setDescripcion(estado.getNombre());
                estadosConCamposSelect.add(estadoConCamposSelect);
            }

            return new ResponseEntity<List<Estado>>(estadosConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de estados sin formato
            return new ResponseEntity<List<Estado>>(estados, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Estado> registrar(@RequestBody Estado reqEstado) {
        System.out.println(reqEstado);
        Estado resEstado = serviceEstado.registrar(reqEstado);

        return new ResponseEntity<Estado>(resEstado, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Estado estado) {

        serviceEstado.actualizar(id, estado.getNombre());

       return ResponseEntity.ok("El estado se actualizo correctamente");
    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceEstado.eliminar(id);
    }

}