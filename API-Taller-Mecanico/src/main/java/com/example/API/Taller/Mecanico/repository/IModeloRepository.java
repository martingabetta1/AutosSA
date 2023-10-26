package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Marca;
import com.example.API.Taller.Mecanico.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IModeloRepository extends JpaRepository<Modelo, Integer> {

    List<Modelo> findByEliminadoFalse();

    @Modifying
    @Query("UPDATE Modelo mod SET mod.nombre = :nombre, mod.marca = :marca WHERE mod.id = :modeloId")
    void actualizarModelo(@Param("modeloId") Integer modeloId, @Param("nombre") String nombre, @Param("marca") Marca marca);

    @Modifying
    @Query("UPDATE Modelo m SET m.eliminado = true WHERE m.id = :modeloId")
    void eliminar(@Param("modeloId") Integer modeloId);

}
