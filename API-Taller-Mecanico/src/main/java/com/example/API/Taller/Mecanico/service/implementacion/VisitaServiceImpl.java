package com.example.API.Taller.Mecanico.service.implementacion;


import com.example.API.Taller.Mecanico.model.Vehiculo;
import com.example.API.Taller.Mecanico.model.Visita;
import com.example.API.Taller.Mecanico.repository.IVehiculoRepository;
import com.example.API.Taller.Mecanico.repository.IVisitaRepository;
import com.example.API.Taller.Mecanico.service.IVisitaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class VisitaServiceImpl implements IVisitaService {

    @Autowired
    IVisitaRepository repoVisita;

    @Override
    public List<Visita> listarVisitas() {
        return repoVisita.findByEliminadoFalse();
    }

    @Override
    public Visita registrar(Visita visita) {
        return repoVisita.save(visita);
    }


    public void actualizar(Integer visitaId, Date fechaVisita) {
        repoVisita.actualizar(visitaId, fechaVisita);
    }

    @Override
    public void eliminar(Integer id) {
        repoVisita.eliminar(id);
    }

}
