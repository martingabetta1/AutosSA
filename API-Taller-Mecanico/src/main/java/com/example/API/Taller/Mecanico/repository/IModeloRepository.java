<<<<<<< HEAD
package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IModeloRepository extends JpaRepository<Modelo, Integer> {

    List<Modelo> findByEliminadoFalse();

    @Modifying
    @Query("UPDATE Modelo m SET m.nombre = :nombre, m.idMarca = :idMarca WHERE m.id = :modeloId")
    void actualizar(@Param("modeloId") Integer modeloId, @Param("nombre") String nombre, @Param("idMarca") Integer idMarca);

    @Modifying
    @Query("UPDATE Modelo m SET m.eliminado = true WHERE m.id = :modeloId")
    void eliminar(@Param("modeloId") Integer modeloId);

}
=======
package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Cliente;
import com.example.API.Taller.Mecanico.model.Modelo;
import com.example.API.Taller.Mecanico.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IModeloRepository extends JpaRepository<Modelo, Integer> {

    List<Modelo> findByEliminadoFalse();

    @Modifying
    @Query("UPDATE Modelo m SET m.nombre = :nombre WHERE m.id = :modeloId")
    void actualizar(@Param("modeloId") Integer modeloId, @Param("nombre") String nombre);

    @Modifying
    @Query("UPDATE Modelo m SET m.eliminado = true WHERE m.id = :modeloId")
    void eliminar(@Param("modeloId") Integer modeloId);

}
>>>>>>> origin/backend
