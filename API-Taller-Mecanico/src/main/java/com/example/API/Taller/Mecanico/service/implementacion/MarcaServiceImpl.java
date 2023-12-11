package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.*;
import com.example.API.Taller.Mecanico.repository.IMarcaRepository;
import com.example.API.Taller.Mecanico.service.IMarcaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MarcaServiceImpl implements IMarcaService {

    @Autowired
    IMarcaRepository repoMarca;

    @Override
    public List<Marca> listarMarcas() {
        return repoMarca.findByEliminadoFalse();
    }

    @Override
    public Marca listarMarcaPorId(Integer marcaId) {
        return repoMarca.findByIdAndEliminadoFalse(marcaId);
    }

    public List<Marca> listarMarcasPorConsultaAnidada(String nombre, String impuesto){
        return repoMarca.findByParams(nombre, impuesto);
    }

    @Override
    public Marca registrar(Marca marca) {
        return repoMarca.save(marca);
    }

    public void actualizar(Integer marcaId, String nombre,Impuesto impuesto) {
        repoMarca.actualizar(marcaId, nombre, impuesto);
    }

    public void eliminar(Integer marcaId) {
        repoMarca.eliminar(marcaId);
    }

}