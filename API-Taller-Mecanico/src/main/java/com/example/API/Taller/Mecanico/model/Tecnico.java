package com.example.API.Taller.Mecanico.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Tecnico")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Size(max = 100)
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Size(max = 100)
    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;

    @Size(max = 100)
    @Column(name = "documento", length = 100, nullable = false)
    private String documento;

    @Size(max = 100)
    @Column(name = "telefono", length = 100, nullable = false)
    private String telefono;

    @Size(max = 100)
    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;


    @Size(max = 100)
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    @Transient
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}

