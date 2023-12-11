package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.*;

import java.util.Date;
import java.util.List;

public interface IOrdenTrabajoService {

    List<OrdenTrabajo> listarOrdenes();
    List<OrdenTrabajo> listarOrdenesPorConsultaAnidada(Integer ordenId, String fechaInicio, String fechaFin, String vehiculo, String tecnico, String estado, String comentario, String cliente);

    OrdenTrabajo registrar(OrdenTrabajo ordenTrabajo);

    void actualizar(Integer ordenId, Date fechaInicio, Date fechaFin, Vehiculo vehiculo, Tecnico tecnico, Estado estado, String comentario, Cliente cliente);

    void eliminar(Integer ordenId);
}
