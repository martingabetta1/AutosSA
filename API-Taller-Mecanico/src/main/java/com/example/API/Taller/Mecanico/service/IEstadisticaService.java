package com.example.API.Taller.Mecanico.service;

import java.util.List;

import com.example.API.Taller.Mecanico.dto.EstadosEstadisticaDTO;
import com.example.API.Taller.Mecanico.dto.ModeloEstadisticaDTO;

public interface IEstadisticaService {
    List<ModeloEstadisticaDTO> getCantidadOrdenesDeModelos();

    List<EstadosEstadisticaDTO> getCantidadOrdenesDeEstados();
}
