package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.repository.IModeloRepository;
import com.example.API.Taller.Mecanico.service.IModeloService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ModeloServiceImpl implements IModeloService {

    @Autowired
    IModeloRepository repoModelo;

    @Override
    public List<Modelo> listarModelos() {
        return repoModelo.findByEliminadoFalse();
    }

    @Override
    public Modelo registrar(Modelo modelo) {
        return repoModelo.save(modelo);
    }


    public void actualizar(Integer modeloId, String nombre, Marca marca) {
        repoModelo.actualizarModelo(modeloId, nombre);
        repoModelo.actualizarMarca(marca.getId(), marca.getDescripcion());
    }

    @Override
    public void eliminar(Integer id) {
        repoModelo.eliminar(id);
    }

}
