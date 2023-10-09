<<<<<<< HEAD
package com.example.API.Taller.Mecanico;

import com.example.API.Taller.Mecanico.model.Marca;
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

=======
package com.example.API.Taller.Mecanico;

import com.example.API.Taller.Mecanico.model.Marca;
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

>>>>>>> origin/backend
}