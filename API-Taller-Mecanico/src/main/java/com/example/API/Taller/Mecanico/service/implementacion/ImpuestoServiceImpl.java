package com.example.API.Taller.Mecanico.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.Taller.Mecanico.model.Impuesto;
import com.example.API.Taller.Mecanico.repository.IImpuestoRepository;
import com.example.API.Taller.Mecanico.service.IImpuestoService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImpuestoServiceImpl  implements IImpuestoService{
    @Autowired
    private IImpuestoRepository impuestoRepository;

    
    @Override
    public List<Impuesto> listarImpuestos() {
        return impuestoRepository.findByEliminadoFalse();
    }

    @Override
    public Impuesto listarImpuestoPorId(Integer impuestoId) {
        return impuestoRepository.findByIdAndEliminadoFalse(impuestoId);
    }

    @Override
    public Impuesto registrar(Impuesto impuesto) {
        return impuestoRepository.save(impuesto);
    }


    public void actualizar(Integer impuestoId, String nombre, Integer porcentaje) {
        impuestoRepository.actualizar(impuestoId, nombre, porcentaje);
    }

    public void eliminar(Integer impuestoId) {
        impuestoRepository.eliminar(impuestoId);
    }
}
