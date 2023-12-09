//esta 
package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.Tecnico;
import com.example.API.Taller.Mecanico.repository.ITecnicoRepository;
import com.example.API.Taller.Mecanico.service.ITecnicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TecnicoServiceImpl implements ITecnicoService {

    @Autowired
    ITecnicoRepository repoTecnico;

    @Override
    public List<Tecnico> listarTecnicos() {
        return repoTecnico.findByEliminadoFalse();
    }

    @Override
    public List<Tecnico> listarTecnicosPorConsultaAnidada(String nombre, String apellido, String documento, String telefono, String direccion) {
        return repoTecnico.findByParams(nombre,apellido,documento,telefono,direccion);
    }

    @Override
    public Tecnico listarTecnicoPorId(Integer idTecnico) {
        return repoTecnico.findByIdAndEliminadoFalse(idTecnico);
    }


    @Override
    public Tecnico registrar(Tecnico tecnico)  {

        return repoTecnico.save(tecnico);
    }

    public void actualizar(Integer tecnicoId, String nombre, String apellido, String documento, String telefono, String direccion) {
        repoTecnico.actualizar(tecnicoId, nombre, apellido, documento, telefono, direccion);
    }

    public void eliminar(Integer tecnicoId) {
        repoTecnico.eliminar(tecnicoId);
    }
}
