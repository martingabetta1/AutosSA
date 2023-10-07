package com.example.API.Taller.Mecanico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API.Taller.Mecanico.model.Marca;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Integer> {

    List<Marca> findByEliminadoFalse();

    @Modifying
    @Query("UPDATE Marca m SET m.eliminado = true WHERE m.id = :marcaId")
    void eliminar(@Param("marcaId") Integer marcaId);

}