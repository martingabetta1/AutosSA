package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Cliente;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IClienteService {

    List<Cliente> listarClientes();

    Cliente listarClientePorId(Integer idCliente);

    List<Cliente> listarClientesPorConsultaAnidada(String nombre, String apellido, String telefono, String localidad,String direccion,String mail);

    Cliente registrar(Cliente cliente);

    Cliente registrarLicencias(Integer idCliente, MultipartFile licenciaFrente, MultipartFile licenciaDorso) throws IOException;

    void actualizar(Integer clienteId, String nombre, String apellido, String direccion, String telefono, String mail, String localidad);

    void eliminar(Integer id);


}
