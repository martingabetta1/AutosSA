package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.*;
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
    public ResponseEntity<List<Marca>> listarMarcas(
            @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
            @RequestParam(name = "nombre",required = false) String nombre,
            @RequestParam(name = "impuesto",required = false) String impuesto) {
        List<Marca> marcas = serviceMarca.listarMarcas();

        if (nombre != null || impuesto != null) {
            List<Marca> buscarMarcas = serviceMarca.listarMarcasPorConsultaAnidada(nombre, impuesto);
            List<Marca> marcasConFiltro = new ArrayList<>();
            for (Marca marca : buscarMarcas) {
                Marca marcaFiltrada = new Marca();
                Impuesto impuestoObj = new Impuesto();
                impuestoObj.setId(marca.getImpuesto().getId());
                impuestoObj.setDescripcion(marca.getImpuesto().getNombre());
                marcaFiltrada.setImpuesto(impuestoObj);
                marcaFiltrada.setId(marca.getId());
                marcaFiltrada.setNombre(marca.getNombre());

                marcasConFiltro.add(marcaFiltrada);
            }
            return new ResponseEntity<List<Marca>>(marcasConFiltro, HttpStatus.OK);
        }
        ;

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
            for (Marca marca : marcas) {
                Impuesto impuestoObj = new Impuesto();
                impuestoObj.setId(marca.getImpuesto().getId());
                impuestoObj.setDescripcion(
                        marca.getImpuesto().getNombre() + " ( " + marca.getImpuesto().getPorcentaje() + "% )");
                marca.setImpuesto(impuestoObj);
            }
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

        serviceMarca.actualizar(id, marca.getNombre(), marca.getImpuesto());

        return ResponseEntity.ok("La marca se actualizo correctamente");
    }

    // Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceMarca.eliminar(id);
    }

}