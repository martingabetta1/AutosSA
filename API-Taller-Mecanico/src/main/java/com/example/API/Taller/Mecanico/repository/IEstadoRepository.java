package com.example.API.Taller.Mecanico.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API.Taller.Mecanico.model.Estado;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Integer> {
    List<Estado> findByEliminadoFalse();
    Estado findByIdAndEliminadoFalse(Integer estadoId);
    
    @Modifying
    @Query("UPDATE Estado e SET e.nombre = :nombre WHERE e.id = :estadoId")
    void actualizar(@Param("estadoId") Integer estadoId, @Param("nombre") String nombre);
     
    @Modifying
    @Query("UPDATE Estado e SET e.eliminado = true WHERE e.id = :estadoId")
    void eliminar(@Param("estadoId") Integer estadoId);
}
