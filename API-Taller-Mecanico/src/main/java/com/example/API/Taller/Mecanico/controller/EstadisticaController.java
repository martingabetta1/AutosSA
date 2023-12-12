package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.dto.EstadosEstadisticaDTO;
import com.example.API.Taller.Mecanico.dto.ModeloEstadisticaDTO;
import com.example.API.Taller.Mecanico.dto.TecnicosEstadisticaDTO;
import com.example.API.Taller.Mecanico.service.IEstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/estadisticas")
public class EstadisticaController {

    @Autowired
    private IEstadisticaService estadisticaService;

    // Cantidad de órdenes de cada modelo de vehículo
    @GetMapping("/modelos-cantidad-ordenes")
    public ResponseEntity<List<ModeloEstadisticaDTO>> getModelosCantidadOrdenes() {
        List<ModeloEstadisticaDTO> estadisticas = estadisticaService.getCantidadOrdenesDeModelos();
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }

    // Cantidad de órdenes en cada estado
    @GetMapping("/estados-ordenes")
    public ResponseEntity<List<EstadosEstadisticaDTO>> getEstadosCantidadOrdenes() {
        List<EstadosEstadisticaDTO> estadisticas = estadisticaService.getCantidadOrdenesDeEstados();
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }
    

    // Tiempo promedio de reparación de órden por técnico
    @GetMapping("/promedios-tecnicos")
    public ResponseEntity<List<TecnicosEstadisticaDTO>> getPromediosTecnicos() {
        List<TecnicosEstadisticaDTO> estadisticas = estadisticaService.getPromediosTecnicos();
        return new ResponseEntity<>(estadisticas,HttpStatus.OK);
    }
    
}
