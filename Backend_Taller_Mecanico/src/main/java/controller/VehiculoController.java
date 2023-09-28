package controller;
import java.util.List;

import model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IVehiculoService;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    IVehiculoService service;

    @GetMapping("")
    public ResponseEntity<List<Vehiculo>> listarVehiculos() {
        List<Vehiculo> obj = service.listarVehiculos();
        return new ResponseEntity<List<Vehiculo>>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehiculo> registrar(@RequestBody Vehiculo vehiculo) {
        Vehiculo obj = service.registrar(vehiculo);
        return new ResponseEntity<Vehiculo>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Vehiculo> actualizar(@RequestBody Vehiculo vehiculo) {
        Vehiculo obj = service.actualizar(vehiculo);
        return new ResponseEntity<Vehiculo>(obj, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer idVehiculo) {
        service.eliminar(idVehiculo);
    }

    //@GetMapping("/{id}")
    //public ResponseEntity<Vehiculo> listarPorId(@PathVariable("id") Integer id)throws Exception{
    //    Vehiculo obj = service.listarPorId(id);

    //    if(obj == null) {
    //        throw  new Exception("No se encontro el ID");
    //    }

    //    service.eliminar(id);
    //    return new ResponseEntity<Vehiculo>(obj, HttpStatus.OK);
    //}

}


//package com.example.crudangular.controller;
//
//import com.example.crudangular.model.Pais;
//import com.example.crudangular.service.IPaisService;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/pais")
//public class PaisController {
//
//    @Autowired
//    IPaisService service;
//
//    @GetMapping
//    public ResponseEntity<List<Pais>> listar() {
//        List<Pais> obj = service.listar();
//        return new ResponseEntity<List<Pais>>(obj, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Pais> registrar(@RequestBody Pais pais) {
//        Pais obj = service.registrar(pais);
//        return new ResponseEntity<Pais>(obj, HttpStatus.CREATED);
//    }
//
//    @PutMapping
//    public ResponseEntity<Pais> actualizar(@RequestBody Pais pais) {
//        Pais obj = service.actualizar(pais);
//        return new ResponseEntity<Pais>(obj, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception {
//        Pais obj = service.listarPorId(id);
//
//        if(obj == null) {
//            throw  new Exception("No se encontro el ID");
//        }
//
//        service.eliminar(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Pais> listarPorId(@PathVariable("id") Integer id)throws Exception{
//        Pais obj = service.listarPorId(id);
//
//        if(obj == null) {
//            throw  new Exception("No se encontro el ID");
//        }
//
//        service.eliminar(id);
//        return new ResponseEntity<Pais>(obj, HttpStatus.OK);
//    }
//
//}
