package com.example.API.Taller.Mecanico.service.implementacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.Taller.Mecanico.dto.EstadosEstadisticaDTO;
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
    public List<ModeloEstadisticaDTO> getCantidadOrdenesDeModelos() {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.listarOrdenes();

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
    
        return estadisticas;
    }
    
    // Método auxiliar para calcular los días de reparación
    private int calcularDiasDeReparacion(OrdenTrabajo orden) {
        long diferenciaEnMilis = orden.getFechaFin().getTime() - orden.getFechaInicio().getTime();
        return (int) TimeUnit.MILLISECONDS.toDays(diferenciaEnMilis);
    }
    

}
