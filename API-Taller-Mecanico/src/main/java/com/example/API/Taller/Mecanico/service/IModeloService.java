package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.model.Modelo;

import java.util.List;

public interface IModeloService {

    List<Modelo> listarModelos();

    List<Modelo> listarModelosPorConsultaAnidada(String nombre, String marca);

    Modelo listarModeloPorId(Integer modeloId);

    Modelo registrar(Modelo modelo);

    void actualizar(Integer modeloId, String nombre, Marca marca);

    void eliminar(Integer id);
}
