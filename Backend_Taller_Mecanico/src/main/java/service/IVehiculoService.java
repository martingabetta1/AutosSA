package service;
import model.Vehiculo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface IVehiculoService {
    List<Vehiculo> listarVehiculos();
    Vehiculo registrar(Vehiculo vehiculo);
    Vehiculo actualizar(Vehiculo vehiculo);
    void eliminar(Integer idVehiculo);
    //Vehiculo listarPorId(Integer codigo);
}

//package com.example.crudangular.service;
//
//import com.example.crudangular.model.Pais;
//
//import java.util.List;
//
//public interface IPaisService {
//
//    List<Pais> listar();
//    Pais registrar(Pais pais);
//    Pais actualizar(Pais pais);
//    void eliminar(Integer codigo);
//    Pais listarPorId(Integer codigo);
//}