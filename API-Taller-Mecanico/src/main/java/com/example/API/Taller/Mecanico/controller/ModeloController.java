package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.model.Vehiculo;
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

    // aca estan los parametros que pide el filtro
    // modelo tiene: String nombre, Marca marca
    @GetMapping
    public ResponseEntity<List<Modelo>> listarModelos(
            @RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "marca", required = false) String marca) {
        // aca agrego los parametros que se piden para el filtro
        List<Modelo> modelos = serviceModelo.listarModelos();
        if (nombre != null || marca != null) {
            List<Modelo> buscarModelos = serviceModelo.listarModelosPorConsultaAnidada(nombre, marca);
            List<Modelo> modelosConFiltro = new ArrayList<>();
            for (Modelo modelo : buscarModelos) {
                Modelo modeloFiltrado = new Modelo();
                // en modelo me hace falta una clave foranea a una marca
                Marca marcaObj = new Marca();
                // seteo el ID del objeto marca
                marcaObj.setId(modelo.getMarca().getId());
                // seteo la descripcion de la marca
                marcaObj.setDescripcion(modelo.getMarca().getNombre());

                modeloFiltrado.setMarca(marcaObj);
                modeloFiltrado.setId(modelo.getId());
                modeloFiltrado.setNombre(modelo.getNombre());

                modelosConFiltro.add(modeloFiltrado);
            }
            return new ResponseEntity<List<Modelo>>(modelosConFiltro, HttpStatus.OK);
        };

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
            for (Modelo modelo : modelos) {
                Marca marcaObj = new Marca();
                marcaObj.setId(modelo.getMarca().getId());
                marcaObj.setDescripcion(modelo.getMarca().getNombre());
                modelo.setMarca(marcaObj);
            }
            // Si select es false, devolver la lista de técnicos sin formato
            return new ResponseEntity<List<Modelo>>(modelos, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody Modelo modelo) {
        Modelo resModelo = serviceModelo.registrar(modelo);
        return new ResponseEntity<>(resModelo, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Modelo modelo) {

        serviceModelo.actualizar(id, modelo.getNombre(), modelo.getMarca());
        return ResponseEntity.ok("El modelo se actualizo correctamente");
    }

    // Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        serviceModelo.eliminar(id);

        return ResponseEntity.ok("El modelo se elimino correctamente");
    }
}
