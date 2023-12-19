package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByEliminadoFalse();

    Cliente findByIdAndEliminadoFalse(Integer clienteId);

    // Logica para filtrar los registros por parametros
    @Query("SELECT c FROM Cliente c " +
            "WHERE (:nombre IS NULL OR c.nombre LIKE %:nombre%) " +
            "AND (:apellido IS NULL OR c.apellido LIKE %:apellido%) " +
            "AND (:telefono IS NULL OR c.telefono LIKE %:telefono%) " +
            "AND (:localidad IS NULL OR c.localidad LIKE %:localidad%) " +
            "AND (:direccion IS NULL OR c.direccion LIKE %:direccion%) " +
            "AND (:mail IS NULL OR c.mail LIKE %:mail%) " +
            "AND c.eliminado = false")
    List<Cliente> findByParams(String nombre, String apellido, String telefono, String localidad,String direccion,String mail);


    @Query("SELECT c, MAX(ot.fechaInicio) AS visita FROM Cliente c LEFT JOIN OrdenTrabajo ot ON c.id = ot.cliente.id GROUP BY c.id ORDER BY visita DESC")
    List<Object[]> listarClientesConVisita();

    @Query("SELECT c, MAX(ot.fechaInicio) AS visita FROM Cliente c LEFT JOIN OrdenTrabajo ot ON c.id = ot.cliente.id WHERE ot.fechaInicio BETWEEN :fechaInicio AND :fechaFin GROUP BY c.id ORDER BY visita DESC")
    List<Object[]> listarClientesConVisita(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);


    @Modifying
    @Query("UPDATE Cliente c SET c.nombre = :nombre, c.apellido = :apellido, c.direccion = :direccion, c.telefono = :telefono, c.mail = :mail, c.localidad = :localidad WHERE c.id = :clienteId")
    void actualizar(@Param("clienteId") Integer clienteId, @Param("nombre") String nombre,
            @Param("apellido") String apellido, @Param("direccion") String direccion,
            @Param("telefono") String telefono, @Param("mail") String mail, @Param("localidad") String localidad);

    @Modifying
    @Query("UPDATE Cliente c SET c.eliminado = true WHERE c.id = :clienteId")
    void eliminar(@Param("clienteId") Integer clienteId);

}
