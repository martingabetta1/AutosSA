package com.example.API.Taller.Mecanico.model;

import com.example.API.Taller.Mecanico.util.enums.EstadoNombre;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Estado")
public class Estado {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING) // Especificamos que el campo se mapea a una enumeración
    @Column(name = "nombre", length = 20, nullable = false) // Establecemos la longitud máxima del campo
    private EstadoNombre nombre;

    @Transient
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoNombre getNombre() {
        return nombre;
    }

    public void setNombre(EstadoNombre nombre) {
        this.nombre = nombre;
    }

}

