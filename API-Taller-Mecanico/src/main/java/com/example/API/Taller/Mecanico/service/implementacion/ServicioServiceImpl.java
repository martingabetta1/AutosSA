package com.example.API.Taller.Mecanico.service.implementacion;

import com.example.API.Taller.Mecanico.model.OrdenTrabajo;
import com.example.API.Taller.Mecanico.model.Servicio;
import com.example.API.Taller.Mecanico.repository.IServicioRepository;
import com.example.API.Taller.Mecanico.service.IServicioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ServicioServiceImpl implements IServicioService {

    @Autowired
    IServicioRepository repoServicio;
    

    public List<Servicio> listarServiciosPorConsultaAnidada(String tipoServicio, Double precio, Integer ordenId, String ordenComentario){
        return repoServicio.findByParams(tipoServicio, precio, ordenId,ordenComentario);
    }

    @Override
    public List<Servicio> listarServiciosPorOrden(Integer idOrden) {
        return repoServicio.findByOrdenTrabajoIdAndEliminadoFalse(idOrden);
    }

    @Override
    public List<Servicio> listarServicios() {
        return repoServicio.findByEliminadoFalse();
    }

    @Override
    public Servicio registrar(Servicio servicio) {
        return repoServicio.save(servicio);
    }

    public void actualizar(Integer servicioId, String tipoServicio, Double precio, OrdenTrabajo ordenTrabajo) {
        repoServicio.actualizarServicio(servicioId, tipoServicio, precio, ordenTrabajo);
    }

    @Override
    public void eliminar(Integer id) {
        repoServicio.eliminar(id);
    }

}
