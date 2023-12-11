package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.OrdenTrabajo;
import com.example.API.Taller.Mecanico.model.Servicio;

import java.util.List;

public interface IServicioService {

    List<Servicio> listarServiciosPorOrden(Integer idOrden);
    List<Servicio> listarServiciosPorConsultaAnidada(String tipoServicio, Double precio, Integer ordenId, String ordenComentario);

    List<Servicio> listarServicios();

    Servicio registrar(Servicio servicio);

    void actualizar(Integer servicioId, String tipoServicio, Double precio, OrdenTrabajo ordenTrabajo);

    void eliminar(Integer id);
}
