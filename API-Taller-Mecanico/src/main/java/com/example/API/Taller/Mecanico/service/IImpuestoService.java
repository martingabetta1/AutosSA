package com.example.API.Taller.Mecanico.service;

import java.util.List;

import com.example.API.Taller.Mecanico.model.Impuesto;

public interface IImpuestoService {
    List<Impuesto> listarImpuestos();

    Impuesto listarImpuestoPorId(Integer impuestoId);

    Impuesto registrar(Impuesto impuesto);

   void actualizar(Integer impuestoId, String nombre, Integer porcentaje);

    void eliminar(Integer id);
}
