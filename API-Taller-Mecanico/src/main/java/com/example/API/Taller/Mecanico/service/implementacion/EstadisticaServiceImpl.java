package com.example.API.Taller.Mecanico.service.implementacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.Taller.Mecanico.dto.ModeloEstadisticaDTO;
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
}
