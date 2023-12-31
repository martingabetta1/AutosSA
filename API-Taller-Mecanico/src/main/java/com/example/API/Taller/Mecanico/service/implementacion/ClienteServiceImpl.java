package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.repository.IClienteRepository;
import com.example.API.Taller.Mecanico.repository.IOrdenTrabajoRepository;
import com.example.API.Taller.Mecanico.service.IClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    IClienteRepository repoCliente;
    
    @Autowired
    IOrdenTrabajoRepository ordenTrabajoRepository;
    
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientesTotal = repoCliente.findByEliminadoFalse();
        List<Cliente> clientesVisitas = new ArrayList<>();
        for (Cliente cliente : clientesTotal) {
            
            Date ultimaFechaInicio = ordenTrabajoRepository.findUltimaFechaInicioPorCliente(cliente.getId());
            cliente.setVisita(ultimaFechaInicio);
            clientesVisitas.add(cliente);
        }
        return clientesVisitas;
    }

    @Override
    public Cliente listarClientePorId(Integer idCliente) {
        return repoCliente.findByIdAndEliminadoFalse(idCliente);
    }

    @Override
    public List<Cliente> listarClientesPorConsultaAnidada(String nombre, String apellido, String telefono, String localidad,String direccion,String mail, String fechaVisita) {
        return repoCliente.findByParams(nombre, apellido, telefono, localidad,direccion,mail, fechaVisita);
    }

    @Override
    public List<Object[]> listarClientesPorFechaVisita(Date visita){
        if(visita != null){
            return repoCliente.listarClientesConVisita(visita);
        } else{
            return repoCliente.listarClientesConVisita();
        }

    }

    @Override
    public Cliente registrar(Cliente cliente)  {
        Date ultimaFechaInicio = ordenTrabajoRepository.findUltimaFechaInicioPorCliente(cliente.getId());
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
