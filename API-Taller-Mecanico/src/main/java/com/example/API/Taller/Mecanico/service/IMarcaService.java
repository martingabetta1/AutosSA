package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.*;

import java.util.List;

public interface IMarcaService {

    List<Marca> listarMarcas(boolean eliminado);

    Marca listarMarcaPorId(Integer marcaId);
    List<Marca> listarMarcasPorConsultaAnidada(String nombre, String impuesto);
    Marca registrar(Marca marca);

   void actualizar(Integer marcaId, String nombre,Impuesto impuesto, boolean eliminado);

    void eliminar(Integer id);
}