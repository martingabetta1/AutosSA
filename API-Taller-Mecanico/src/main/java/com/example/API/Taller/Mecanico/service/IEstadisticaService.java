package com.example.API.Taller.Mecanico.service;

import java.util.Date;
import java.util.List;

import com.example.API.Taller.Mecanico.dto.EstadosEstadisticaDTO;
import com.example.API.Taller.Mecanico.dto.GananciasMensualesDTO;
import com.example.API.Taller.Mecanico.dto.ModeloEstadisticaDTO;
import com.example.API.Taller.Mecanico.dto.TecnicosEstadisticaDTO;

public interface IEstadisticaService {
    List<ModeloEstadisticaDTO> getCantidadOrdenesDeModelos(Date fechaInicio, Date fechaFin);

    List<EstadosEstadisticaDTO> getCantidadOrdenesDeEstados(Date fechaInicio, Date fechaFin);

    List<TecnicosEstadisticaDTO> getPromediosTecnicos(Date fechaInicio, Date fechaFin);

    List<GananciasMensualesDTO> getGananciasMensuales(Date fechaInicio, Date fechaFin);
}
