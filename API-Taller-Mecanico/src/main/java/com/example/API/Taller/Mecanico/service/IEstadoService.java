package com.example.API.Taller.Mecanico.service;

import java.util.List;

import com.example.API.Taller.Mecanico.model.Estado;

public interface IEstadoService {
    List<Estado> listarEstados();

    Estado listarEstadoPorId(Integer estadoId);

    Estado registrar(Estado estado);

    void actualizar(Integer estadoId, String nombre);

    void eliminar(Integer id);

}