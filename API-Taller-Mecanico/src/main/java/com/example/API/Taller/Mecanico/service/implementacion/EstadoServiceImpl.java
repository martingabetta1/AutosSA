package com.example.API.Taller.Mecanico.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.Taller.Mecanico.model.Estado;
import com.example.API.Taller.Mecanico.repository.IEstadoRepository;
import com.example.API.Taller.Mecanico.service.IEstadoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoServiceImpl implements IEstadoService {

    @Autowired
    IEstadoRepository estadoRepository;

     @Override
    public List<Estado> listarEstados() {
        return estadoRepository.findByEliminadoFalse();
    }

    @Override
    public Estado listarEstadoPorId(Integer estadoId) {
        return estadoRepository.findByIdAndEliminadoFalse(estadoId);
    }

    @Override
    public Estado registrar(Estado estado) {
        return estadoRepository.save(estado);
    }


    public void actualizar(Integer estadoId, String nombre) {
        estadoRepository.actualizar(estadoId, nombre);
    }

    public void eliminar(Integer estadoId) {
        estadoRepository.eliminar(estadoId);
    }
    
}
