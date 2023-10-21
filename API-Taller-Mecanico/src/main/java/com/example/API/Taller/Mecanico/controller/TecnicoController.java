package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.model.Tecnico;
import com.example.API.Taller.Mecanico.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {


    @Autowired
    ITecnicoService serviceTecnico;

    @GetMapping
    public ResponseEntity<List<Tecnico>> listarTecnicos(@RequestParam(name = "select", required = false, defaultValue = "false") boolean select) {
        List<Tecnico> tecnicos = serviceTecnico.listarTecnicos();


        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<Tecnico> tecnicosConCamposSelect = new ArrayList<>();
            for (Tecnico tecnico : tecnicos) {
                Tecnico tecnicoConCamposSelect = new Tecnico();
                tecnicoConCamposSelect.setId(tecnico.getId());
                tecnicoConCamposSelect.setDescripcion(tecnico.getNombre());
                tecnicosConCamposSelect.add(tecnicoConCamposSelect);
            }

            return new ResponseEntity<List<Tecnico>>(tecnicosConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de técnicos sin formato
            return new ResponseEntity<List<Tecnico>>(tecnicos, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<Tecnico> registrar(@RequestBody Tecnico tecnico) {

        Tecnico resTecnico = serviceTecnico.registrar(tecnico);

        return new ResponseEntity<Tecnico>(resTecnico, HttpStatus.CREATED);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Tecnico tecnico) {

        serviceTecnico.actualizar(id, tecnico.getNombre(), tecnico.getApellido(), tecnico.getDocumento(), tecnico.getTelefono(), tecnico.getDireccion());
        return ResponseEntity.ok("El tecnico se actualizo correctamente");
    }

    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        serviceTecnico.eliminar(id);

        return ResponseEntity.ok("El tecnico se elimino correctamente");
    }
}