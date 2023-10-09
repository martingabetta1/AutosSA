package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Vehiculo;
import com.example.API.Taller.Mecanico.model.Visita;

import java.util.Date;
import java.util.List;

public interface IVisitaService {

    List<Visita> listarVisitas();

    Visita registrar(Visita visita);

    void actualizar(Integer visitaId, Integer idCliente, Date fechaVisita);

    void eliminar(Integer id);
}
