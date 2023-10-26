package com.example.API.Taller.Mecanico.service;

import java.util.Date;
import java.util.List;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Visita;

public interface IVisitaService {

    List<Visita> listarVisitas();

    Visita registrar(Visita visita);

    void actualizar(Integer visitaId, Date fechaVisita, Cliente cliente);

    void eliminar(Integer id);
}
