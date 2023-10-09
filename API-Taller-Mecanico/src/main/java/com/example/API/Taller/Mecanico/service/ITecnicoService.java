package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Tecnico;

import java.util.List;

public interface ITecnicoService {

    List<Tecnico> listarTecnicos();

    Tecnico listarTecnicoPorId(Integer idTecnico);

    Tecnico registrar(Tecnico tecnico);

    void actualizar(Integer tecnicoId, String nombre, String apellido, String documento, String telefono, String direccion);

    void eliminar(Integer id);


}
