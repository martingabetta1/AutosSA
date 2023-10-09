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
    public Cliente listarClientePorId(Integer idCliente) {
        return repoCliente.findByIdAndEliminadoFalse(idCliente);
    }


    @Override
    public Cliente registrar(Cliente cliente)  {

        return repoCliente.save(cliente);
    }

    @Override
    public Cliente registrarLicencias(Integer idCliente, MultipartFile licenciaFrente, MultipartFile licenciaDorso) throws IOException {

        Cliente cliente = repoCliente.findById(idCliente).orElse(null);

        if (licenciaFrente != null && !licenciaFrente.isEmpty() && cliente != null) {
            cliente.setLicenciaFrente(licenciaFrente.getBytes());
        }

        if (licenciaDorso != null && !licenciaDorso.isEmpty() && cliente != null) {
            cliente.setLicenciaDorso(licenciaDorso.getBytes());
        }

        assert cliente != null;
        return repoCliente.save(cliente);
    }

    public void actualizar(Integer clienteId, String nombre, String apellido, String direccion, String telefono, String mail, String localidad) {
        repoCliente.actualizar(clienteId, nombre, apellido, direccion, telefono, mail, localidad);
    }

    public void eliminar(Integer clienteId) {
        repoCliente.eliminar(clienteId);
    }
}
