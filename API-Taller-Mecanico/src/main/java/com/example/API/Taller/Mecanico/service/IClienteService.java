package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Marca;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IClienteService {

    List<Cliente> listarClientes();
    Cliente registrar(Cliente cliente, MultipartFile licenciaFrente, MultipartFile licenciaDorso) throws IOException;

    void actualizar(Integer clienteId, String nombre, String apellido, String direccion, String telefono, String email);

    void eliminar(Integer id);


}
