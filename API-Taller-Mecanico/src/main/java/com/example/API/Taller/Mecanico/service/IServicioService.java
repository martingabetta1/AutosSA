package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Servicio;

import java.util.List;

public interface IServicioService {

    List<Servicio> listarServiciosPorOrden(Integer idOrden);

    List<Servicio> listarServicios();

    Servicio registrar(Servicio servicio);

    void actualizar(Integer servicioId, String tipoServicio, Float precio);

    void eliminar(Integer id);
}
