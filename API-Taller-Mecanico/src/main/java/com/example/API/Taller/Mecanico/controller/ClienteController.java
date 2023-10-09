package com.example.API.Taller.Mecanico.controller;


import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.service.IClienteService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    IClienteService serviceCliente;

    @GetMapping

    public ResponseEntity<List<Cliente>> listarClientes(@RequestParam(name = "select", defaultValue = "true") boolean select) {
        List<Cliente> clientes = serviceCliente.listarClientes();

        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<Cliente> clientesConCamposSelect = new ArrayList<>();
            for (Cliente cliente : clientes) {
                Cliente clienteConCamposSelect = new Cliente();
                clienteConCamposSelect.setId(cliente.getId());
                clienteConCamposSelect.setDescripcion(cliente.getNombre());
                clientesConCamposSelect.add(clienteConCamposSelect);
            }

            return new ResponseEntity<List<Cliente>>(clientesConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de técnicos sin formato
            return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente) {

        Cliente resCliente = serviceCliente.registrar(cliente);

        return new ResponseEntity<Cliente>(resCliente, HttpStatus.CREATED);
    }

    //Endpoint para registrar las licencias del cliente
    @PostMapping("/licencias/{id}")
        public ResponseEntity<Cliente> registrarLicencia(@PathVariable Integer id, @RequestParam("frente") MultipartFile licenciaFrente, @RequestParam("dorso") MultipartFile licenciaDorso) throws IOException {

        System.out.println("La licencia frente es: " + licenciaFrente);
        System.out.println("La licencia dorso es: " + licenciaDorso);

        Cliente resCliente = serviceCliente.registrarLicencias(id, licenciaFrente, licenciaDorso);

        return new ResponseEntity<Cliente>(resCliente, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {

        serviceCliente.actualizar(id, cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(), cliente.getTelefono(), cliente.getMail(), cliente.getLocalidad());

        return ResponseEntity.ok("El cliente se actualizo correctamente");
    }


    //Aca se debe actualizar el campo eliminado a true.
    @PostMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceCliente.eliminar(id);
    }
}
