package com.example.API.Taller.Mecanico;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.repository.IMarcaRepository;
import com.example.API.Taller.Mecanico.service.IMarcaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public Marca registrar(Marca marca) {
        return repoMarca.save(marca);
    }


    public void actualizar(Integer marcaId, String nombre) {
        repoMarca.actualizar(marcaId, nombre);
    }

    public void eliminar(Integer marcaId) {
        repoMarca.eliminar(marcaId);
    }

}