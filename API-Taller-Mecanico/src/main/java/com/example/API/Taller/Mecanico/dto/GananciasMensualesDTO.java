package com.example.API.Taller.Mecanico.dto;

import java.time.YearMonth;

import lombok.Data;

@Data
public class GananciasMensualesDTO {
    private YearMonth mes;
    private Double ganancia;
}
