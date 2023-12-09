package com.example.API.Taller.Mecanico.controller;


import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.service.IClienteService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    IClienteService serviceCliente;

    @GetMapping()
    public ResponseEntity<List<Cliente>> listarClientes(@RequestParam(name = "select", required = false, defaultValue = "false") boolean select,
                                                        @RequestParam(name = "nombre", required = false) String nombre,
                                                        @RequestParam(name = "apellido", required = false) String apellido,
                                                        @RequestParam(name = "telefono", required = false) String telefono,
                                                        @RequestParam(name = "localidad", required = false) String localidad,
                                                        @RequestParam(name = "direccion", required = false) String direccion,
                                                        @RequestParam(name = "mail", required = false) String mail) {

        List<Cliente> clientes = serviceCliente.listarClientes();

        if(nombre != null || apellido != null || telefono != null || localidad != null || direccion != null || mail != null) {
            List<Cliente> buscarClientes = serviceCliente.listarClientesPorConsultaAnidada(nombre, apellido, telefono, localidad,direccion,mail);
            List<Cliente> clientesConFiltro = new ArrayList<>();
            for(Cliente cliente : buscarClientes){
                Cliente clienteFiltrado = new Cliente();
                clienteFiltrado.setId(cliente.getId());
                clienteFiltrado.setNombre(cliente.getNombre());
                clienteFiltrado.setApellido(cliente.getApellido());
                clienteFiltrado.setDireccion(cliente.getDireccion());
                clienteFiltrado.setTelefono(cliente.getTelefono());
                clienteFiltrado.setMail(cliente.getMail());
                clienteFiltrado.setLocalidad(cliente.getLocalidad());
                clientesConFiltro.add(clienteFiltrado);
            }
            return new ResponseEntity<List<Cliente>>(clientesConFiltro, HttpStatus.OK);
        }

        if (select) {
            // Si select es true, formatear la respuesta con el formato deseado

            List<Cliente> clientesConCamposSelect = new ArrayList<>();
            for (Cliente cliente : clientes) {
                Cliente clienteConCamposSelect = new Cliente();
                clienteConCamposSelect.setId(cliente.getId());
                clienteConCamposSelect.setDescripcion(cliente.getNombre() + ' ' + cliente.getApellido());
                clientesConCamposSelect.add(clienteConCamposSelect);
            }

            return new ResponseEntity<List<Cliente>>(clientesConCamposSelect, HttpStatus.OK);
        } else {
            // Si select es false, devolver la lista de técnicos sin formato
            return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> descargarImagen(@PathVariable Integer id, HttpServletResponse response) {
        // Obtener el cliente desde la base de datos
        Cliente cliente = serviceCliente.listarClientePorId(id);

        // Verificar si el cliente existe
        if (cliente == null || cliente.getLicenciaFrente() == null) {
            return ResponseEntity.notFound().build();
        }

        // Obtener el contenido de la imagen
        byte[] licenciaFrente = cliente.getLicenciaFrente();

        // Configurar el encabezado de la respuesta
        response.setContentType("licenciaFrenteDescargada/png");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=imagen.png");

        // Escribir el contenido de la imagen en la respuesta
        try (OutputStream out = response.getOutputStream()) {
            out.write(licenciaFrente);
        } catch (IOException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente
        }

        return ResponseEntity.ok().build();
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
