package com.example.API.Taller.Mecanico.service;

import com.example.API.Taller.Mecanico.model.Tecnico;

import java.util.List;

public interface ITecnicoService {

    List<Tecnico> listarTecnicos();

    Tecnico listarTecnicoPorId(Integer idTecnico);

    Tecnico registrar(Tecnico tecnico);

    void actualizar(Integer tecnicoId, String nombre, String apellido, String direccion, String telefono, String mail, String localidad);

    void eliminar(Integer id);


}
