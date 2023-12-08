package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.*;

import java.util.Date;
import java.util.List;

public interface IOrdenTrabajoService {

    List<OrdenTrabajo> listarOrdenes();

    OrdenTrabajo registrar(OrdenTrabajo ordenTrabajo);

    void actualizar(Integer ordenId, Date fechaInicio, Date fechaFin, Vehiculo vehiculo, Tecnico tecnico, Estado estado, String comentario, Cliente cliente, Impuesto impuesto);

    void eliminar(Integer ordenId);
}
