package repository;
import model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer>{

    List<Vehiculo> findByEliminadoFalse();

    @Modifying
    @Query("UPDATE Vehiculo v SET v.eliminado = true WHERE m.id = :idVehiculo")
    void eliminar(@Param("idVehiculo") Integer idVehiculo);

}
//package com.example.crudangular.repository;
//
//import com.example.crudangular.model.Pais;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface IPaisRepository extends JpaRepository<Pais, Integer> {
//
//}