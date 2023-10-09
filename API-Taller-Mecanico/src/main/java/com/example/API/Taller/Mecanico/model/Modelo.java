package com.example.API.Taller.Mecanico.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;


    @Size(max = 100)
    @Column(name = "idMarca", length = 100, nullable = false)
    private Integer idMarca;

    @Size(max = 100)
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    public Integer getIdMarca() {
        return idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getId() {
        return id;
    }


}
