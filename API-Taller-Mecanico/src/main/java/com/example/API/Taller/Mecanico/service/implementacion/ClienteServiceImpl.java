package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.repository.IClienteRepository;
import com.example.API.Taller.Mecanico.service.IClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository repoCliente;

    @Override
    public List<Cliente> listarClientes() {
        return repoCliente.findByEliminadoFalse();
    }


    @Override
    public Cliente registrar(Cliente cliente, MultipartFile licenciaFrente, MultipartFile licenciaDorso) throws IOException {


        cliente.setLicenciaFrente(licenciaFrente.getBytes());
        cliente.setLicenciaDorso(licenciaDorso.getBytes());

        return repoCliente.save(cliente);
    }

    public void actualizar(Integer clienteId, String nombre, String apellido, String direccion, String telefono, String email) {
        repoCliente.actualizar(clienteId, nombre, apellido, direccion, telefono, email);
    }

    public void eliminar(Integer clienteId) {
        repoCliente.eliminar(clienteId);
    }
}
