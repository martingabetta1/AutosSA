package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.dto.EstadosEstadisticaDTO;
import com.example.API.Taller.Mecanico.dto.GananciasMensualesDTO;
import com.example.API.Taller.Mecanico.dto.ModeloEstadisticaDTO;
import com.example.API.Taller.Mecanico.dto.TecnicosEstadisticaDTO;
import com.example.API.Taller.Mecanico.service.IEstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/estadisticas")
public class EstadisticaController {

    @Autowired
    private IEstadisticaService estadisticaService;

    // Cantidad de órdenes de cada modelo de vehículo
    @GetMapping("/modelos-ordenes")
    public ResponseEntity<List<ModeloEstadisticaDTO>> getModelosCantidadOrdenes(
        @RequestParam( name = "fechaInicio", required = false )
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date fechaInicio,
        @RequestParam( name = "fechaFin", required = false )
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date fechaFin
    ) {
        List<ModeloEstadisticaDTO> estadisticas = estadisticaService.getCantidadOrdenesDeModelos( fechaInicio, fechaFin);
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }

    // Cantidad de órdenes en cada estado
    @GetMapping("/estados-ordenes")
    public ResponseEntity<List<EstadosEstadisticaDTO>> getEstadosCantidadOrdenes(
        @RequestParam( name = "fechaInicio", required = false )
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date fechaInicio,
        @RequestParam( name = "fechaFin", required = false )
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date fechaFin
    ) {
        List<EstadosEstadisticaDTO> estadisticas = estadisticaService.getCantidadOrdenesDeEstados(fechaInicio, fechaFin);
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }
    

    // Tiempo promedio de reparación de órden por técnico
    @GetMapping("/promedios-tecnicos")
    public ResponseEntity<List<TecnicosEstadisticaDTO>> getPromediosTecnicos(
        @RequestParam( name = "fechaInicio", required = false )
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date fechaInicio,
        @RequestParam( name = "fechaFin", required = false )
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date fechaFin) {
        List<TecnicosEstadisticaDTO> estadisticas = estadisticaService.getPromediosTecnicos(fechaInicio, fechaFin);
        return new ResponseEntity<>(estadisticas,HttpStatus.OK);
    }

    // Tiempo promedio de reparación de órden por técnico
    @GetMapping("/ganancias-mensuales")
    public ResponseEntity<List<GananciasMensualesDTO>> getGananciasMensuales(
        @RequestParam( name = "fechaInicio", required = false )
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date fechaInicio,
        @RequestParam( name = "fechaFin", required = false )
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date fechaFin
    ) {
        List<GananciasMensualesDTO> estadisticas = estadisticaService.getGananciasMensuales(fechaInicio, fechaFin);
        return new ResponseEntity<>(estadisticas,HttpStatus.OK);
    }


    
}
