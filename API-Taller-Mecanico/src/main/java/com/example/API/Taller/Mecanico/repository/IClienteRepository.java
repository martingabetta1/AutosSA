<<<<<<< HEAD
package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByEliminadoFalse();

    Cliente findByIdAndEliminadoFalse(Integer clienteId);

    @Modifying
    @Query("UPDATE Cliente c SET c.nombre = :nombre, c.apellido = :apellido, c.direccion = :direccion, c.telefono = :telefono, c.mail = :mail, c.localidad = :localidad WHERE c.id = :clienteId")
    void actualizar(@Param("clienteId") Integer clienteId, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("mail") String mail, @Param("localidad") String localidad);

    @Modifying
    @Query("UPDATE Cliente c SET c.eliminado = true WHERE c.id = :clienteId")
    void eliminar(@Param("clienteId") Integer clienteId);

}
=======
package com.example.API.Taller.Mecanico.repository;

import com.example.API.Taller.Mecanico.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByEliminadoFalse();

    Cliente findByIdAndEliminadoFalse(Integer clienteId);

    @Modifying
    @Query("UPDATE Cliente c SET c.nombre = :nombre, c.apellido = :apellido, c.direccion = :direccion, c.telefono = :telefono, c.mail = :mail, c.localidad = :localidad WHERE c.id = :clienteId")
    void actualizar(@Param("clienteId") Integer clienteId, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("direccion") String direccion, @Param("telefono") String telefono, @Param("mail") String mail, @Param("localidad") String localidad);

    @Modifying
    @Query("UPDATE Cliente c SET c.eliminado = true WHERE c.id = :clienteId")
    void eliminar(@Param("clienteId") Integer clienteId);

}
>>>>>>> origin/backend
