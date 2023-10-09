package com.example.API.Taller.Mecanico.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Modelo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idMarca", referencedColumnName = "id", nullable = false)
    private Marca marca;

    @Size(max = 100)
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    @Transient
    private String descripcion;

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
