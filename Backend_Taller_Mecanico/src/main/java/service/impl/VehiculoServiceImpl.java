package service.impl;
import model.Vehiculo;
import repository.IVehiculoRepository;
import service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class VehiculoServiceImpl implements IVehiculoService{
    @Autowired
    IVehiculoRepository repo;

   @Override
    public List<Vehiculo> listarVehiculos() {
       return repo.findByEliminadoFalse();
    }

    @Override
    public Vehiculo registrar(Vehiculo vehiculo) {
        return repo.save(vehiculo);
    }

    @Override
    public Vehiculo actualizar(Vehiculo vehiculo) {
        return repo.save(vehiculo);
    }

    @Override
    public void eliminar(Integer idVehiculo) {
        repo.eliminar(idVehiculo);
    }

    //@Override
    //public Vehiculo listarPorId(Integer idVehiculo) {
    //    return repo.findById(idVehiculo).orElse(null);
    //}
}

//package com.example.crudangular.service.impl;
//
//import com.example.crudangular.model.Pais;
//import com.example.crudangular.repository.IPaisRepository;
//import com.example.crudangular.service.IPaisService;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaisServiceImpl implements IPaisService {
//
//    @Autowired
//    IPaisRepository repo;
//
//    @Override
//    public List<Pais> listar() {
//        return repo.findAll();
//    }
//
//    @Override
//    public Pais registrar(Pais pais) {
//        return repo.save(pais);
//    }
//
//    @Override
//    public Pais actualizar(Pais pais) {
//        return repo.save(pais);
//    }
//
//    @Override
//    public void eliminar(Integer codigo) {
//        repo.deleteById(codigo);
//    }
//
//    @Override
//    public Pais listarPorId(Integer codigo) {
//        return repo.findById(codigo).orElse(null);
//    }
//}