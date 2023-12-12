package com.example.API.Taller.Mecanico.controller;

import com.example.API.Taller.Mecanico.dto.ModeloEstadisticaDTO;
import com.example.API.Taller.Mecanico.service.IEstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticaController {

    @Autowired
    private IEstadisticaService estadisticaService;

    @GetMapping("/modelos-cantidad-ordenes")
    public ResponseEntity<List<ModeloEstadisticaDTO>> getModelosCantidadOrdenes() {
        List<ModeloEstadisticaDTO> estadisticas = estadisticaService.getCantidadOrdenesDeModelos();
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }
}
