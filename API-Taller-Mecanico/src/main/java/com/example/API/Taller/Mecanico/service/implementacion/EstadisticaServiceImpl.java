package com.example.API.Taller.Mecanico.service.implementacion;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.Taller.Mecanico.dto.EstadosEstadisticaDTO;
import com.example.API.Taller.Mecanico.dto.GananciasMensualesDTO;
import com.example.API.Taller.Mecanico.dto.ModeloEstadisticaDTO;
import com.example.API.Taller.Mecanico.dto.TecnicosEstadisticaDTO;
import com.example.API.Taller.Mecanico.model.OrdenTrabajo;
import com.example.API.Taller.Mecanico.service.IEstadisticaService;
import com.example.API.Taller.Mecanico.service.IOrdenTrabajoService;

@Service
public class EstadisticaServiceImpl implements IEstadisticaService {

    @Autowired
    private IOrdenTrabajoService ordenTrabajoService;


    @Override
    public List<ModeloEstadisticaDTO> getCantidadOrdenesDeModelos(Date fechaInicio, Date fechaFin) {
        List<OrdenTrabajo> ordenes; 
        if(fechaInicio == null || fechaFin == null){
            ordenes = ordenTrabajoService.listarOrdenes();
        } else{
            ordenes = ordenTrabajoService.listarOrdenesPorRangoFechas(fechaInicio, fechaFin);
        }

        // Utilizamos un mapa para contar la cantidad de órdenes por modelo
        Map<String, Integer> cantidadOrdenesPorModelo = new HashMap<>();

        for (OrdenTrabajo orden : ordenes) {
            String nombreModelo = orden.getVehiculo().getModelo().getNombre();

            // Incrementamos el contador para el modelo actual
            cantidadOrdenesPorModelo.put(nombreModelo, cantidadOrdenesPorModelo.getOrDefault(nombreModelo, 0) + 1);
        }

        // Creamos la lista de DTOs a partir del mapa
        List<ModeloEstadisticaDTO> estadisticas = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cantidadOrdenesPorModelo.entrySet()) {
            ModeloEstadisticaDTO modeloEstadistica = new ModeloEstadisticaDTO();
            modeloEstadistica.setNombreModelo(entry.getKey());
            modeloEstadistica.setCantidadOrdenes(entry.getValue());
            estadisticas.add(modeloEstadistica);
        }
        Collections.sort(estadisticas, Comparator.comparingInt(ModeloEstadisticaDTO::getCantidadOrdenes));
        return estadisticas;
    }

    @Override
    public List<EstadosEstadisticaDTO> getCantidadOrdenesDeEstados() {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.listarOrdenes();

        // Utilizamos un mapa para contar la cantidad de órdenes por modelo
        Map<String, Integer> cantidadOrdenesPorEstado = new HashMap<>();

        for (OrdenTrabajo orden : ordenes) {
            String nombreEstado = orden.getEstado().getNombre();

            // Incrementamos el contador para el modelo actual
            cantidadOrdenesPorEstado.put(nombreEstado, cantidadOrdenesPorEstado.getOrDefault(nombreEstado, 0) + 1);
        }

        // Creamos la lista de DTOs a partir del mapa
        List<EstadosEstadisticaDTO> estadisticas = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cantidadOrdenesPorEstado.entrySet()) {
            EstadosEstadisticaDTO estadoEstadistica = new EstadosEstadisticaDTO();
            estadoEstadistica.setNombreEstado(entry.getKey());
            estadoEstadistica.setCantidadOrdenes(entry.getValue());
            estadisticas.add(estadoEstadistica);
        }
        Collections.sort(estadisticas, Comparator.comparingInt(EstadosEstadisticaDTO::getCantidadOrdenes));
        return estadisticas;
    }

    @Override
    public List<TecnicosEstadisticaDTO> getPromediosTecnicos() {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.listarOrdenes();
    
        // Utilizamos un mapa para realizar el seguimiento del tiempo total de reparación por técnico
        Map<String, Integer> tiempoTotalPorTecnico = new HashMap<>();
        Map<String, Integer> cantidadOrdenesPorTecnico = new HashMap<>();
    
        for (OrdenTrabajo orden : ordenes) {
            String nombreTecnico = orden.getTecnico().getNombre() + " " + orden.getTecnico().getApellido();
    
            // Actualizamos el tiempo total de reparación y la cantidad de órdenes para el técnico actual
            int tiempoTotalActual = tiempoTotalPorTecnico.getOrDefault(nombreTecnico, 0) + calcularDiasDeReparacion(orden);
            int cantidadOrdenesActual = cantidadOrdenesPorTecnico.getOrDefault(nombreTecnico, 0) + 1;
    
            tiempoTotalPorTecnico.put(nombreTecnico, tiempoTotalActual);
            cantidadOrdenesPorTecnico.put(nombreTecnico, cantidadOrdenesActual);
        }
    
        // Creamos la lista de DTOs a partir del mapa y calculamos el promedio
        List<TecnicosEstadisticaDTO> estadisticas = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : tiempoTotalPorTecnico.entrySet()) {
            TecnicosEstadisticaDTO tecnicoEstadistica = new TecnicosEstadisticaDTO();
            tecnicoEstadistica.setNombreTecnico(entry.getKey());
    
            // Calculamos el promedio dividiendo el tiempo total entre la cantidad de órdenes
            int promedio = entry.getValue() / cantidadOrdenesPorTecnico.get(entry.getKey());
            tecnicoEstadistica.setDiasPromedio(promedio);
    
            estadisticas.add(tecnicoEstadistica);
        }

        // Ordenamos la lista de estadísticas por el promedio de días en orden ascendente
        Collections.sort(estadisticas, Comparator.comparingInt(TecnicosEstadisticaDTO::getDiasPromedio));
        return estadisticas;
    }
    
    // Método auxiliar para calcular los días de reparación
    private int calcularDiasDeReparacion(OrdenTrabajo orden) {
        long diferenciaEnMilis = orden.getFechaFin().getTime() - orden.getFechaInicio().getTime();
        return (int) TimeUnit.MILLISECONDS.toDays(diferenciaEnMilis);
    }
    
    @Override
    public List<GananciasMensualesDTO> getGananciasMensuales() {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.listarOrdenes();

        // Utilizamos un mapa para realizar el seguimiento de las ganancias por mes
        Map<YearMonth, Double> gananciasPorMes = new HashMap<>();

        for (OrdenTrabajo orden : ordenes) {
            // Verificamos si la orden está en estado finalizado
            if (orden.getEstado().getNombre().equals("Finalizado")) {
                // Obtenemos el mes y el año de la fecha de finalización
                YearMonth yearMonth = YearMonth.from(orden.getFechaFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

                // Actualizamos las ganancias para el mes actual
                Double gananciaActual = gananciasPorMes.getOrDefault(yearMonth, 0.0) + orden.getTotalCosto();
                gananciasPorMes.put(yearMonth, gananciaActual);
            }
        }

        // Creamos la lista de DTOs a partir del mapa
        List<GananciasMensualesDTO> estadisticas = new ArrayList<>();
        for (Map.Entry<YearMonth, Double> entry : gananciasPorMes.entrySet()) {
            GananciasMensualesDTO gananciasDTO = new GananciasMensualesDTO();
            gananciasDTO.setMes(entry.getKey());
            gananciasDTO.setGanancia(entry.getValue());
            estadisticas.add(gananciasDTO);
        }
        // Ordenar fechas
        Collections.sort(estadisticas, Comparator.comparing(GananciasMensualesDTO::getMes));

        return estadisticas;
    }

}
