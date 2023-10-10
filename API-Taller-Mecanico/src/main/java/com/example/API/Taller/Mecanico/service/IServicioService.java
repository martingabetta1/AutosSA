package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.model.Servicio;

import java.util.List;

public interface IServicioService {

    List<Servicio> listarServicios();

    Servicio registrar(Servicio servicio);

    void actualizar(Integer servicioId, String nombre);

    void eliminar(Integer id);
}
