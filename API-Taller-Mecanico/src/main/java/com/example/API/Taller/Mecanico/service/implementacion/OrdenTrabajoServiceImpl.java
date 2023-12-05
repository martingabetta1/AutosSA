package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.*;
import com.example.API.Taller.Mecanico.repository.IOrdenTrabajoRepository;
import com.example.API.Taller.Mecanico.service.IOrdenTrabajoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrdenTrabajoServiceImpl implements IOrdenTrabajoService {

    @Autowired
    IOrdenTrabajoRepository repoOrden;

    @Override
    public List<OrdenTrabajo> listarOrdenes() {
        return repoOrden.findByEliminadoFalse();
    }

    @Override
    public OrdenTrabajo registrar(OrdenTrabajo ordenTrabajo) {
        return repoOrden.save(ordenTrabajo);
    }

    public void actualizar(Integer ordenId, Date fechaInicio, Date fechaFin, Vehiculo vehiculo, Tecnico tecnico, String estado, String comentario, Cliente cliente) {
         repoOrden.actualizarOrden(ordenId, fechaInicio, fechaFin, estado, comentario, cliente, vehiculo, tecnico);
    }

    @Override
    public void eliminar(Integer ordenId) {
        repoOrden.eliminar(ordenId);
    }
}
