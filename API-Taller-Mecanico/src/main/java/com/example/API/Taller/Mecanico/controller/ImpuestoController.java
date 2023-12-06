package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Impuesto;
import com.example.API.Taller.Mecanico.service.IImpuestoService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/impuestos")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImpuestoController {

    @Autowired
    IImpuestoService serviceImpuesto;

    @GetMapping
    public ResponseEntity<List<Impuesto>> listarImpuestos(@RequestParam(name = "select", required = false, defaultValue = "false") boolean select) {
        List<Impuesto> impuestos = serviceImpuesto.listarImpuestos();

        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<Impuesto> impuestosConCamposSelect = new ArrayList<>();
            for (Impuesto impuesto : impuestos) {
                Impuesto impuestoConCamposSelect = new Impuesto();
                impuestoConCamposSelect.setId(impuesto.getId());
                impuestoConCamposSelect.setDescripcion(impuesto.getNombre() + " (" + impuesto.getPorcentaje()+"%)");
                impuestosConCamposSelect.add(impuestoConCamposSelect);    
            }

            return new ResponseEntity<List<Impuesto>>(impuestosConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de impuestos sin formato
            return new ResponseEntity<List<Impuesto>>(impuestos, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Impuesto> registrar(@RequestBody Impuesto reqImpuesto) {
        System.out.println(reqImpuesto);
        Impuesto resImpuesto = serviceImpuesto.registrar(reqImpuesto);

        return new ResponseEntity<Impuesto>(resImpuesto, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Impuesto impuesto) {

        serviceImpuesto.actualizar(id, impuesto.getNombre(), impuesto.getPorcentaje());

       return ResponseEntity.ok("El impuesto se actualizo correctamente");
    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceImpuesto.eliminar(id);
    }

}