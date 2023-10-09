package com.example.API.Taller.Mecanico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @Column(name = "patente", length = 100, nullable = false)
    private String patente;

    @Size(max = 100)
    @Column(name = "observaciones", length = 100, nullable = false)
    private String observaciones;

    @Size(max = 100)
    @Column(name = "anio", length = 100, nullable = false)
    private Integer anio;

    @Size(max = 100)
    @Column(name = "kilometros", length = 100, nullable = false)
    private float kilometros;


    @Size(max = 100)
    @Column(name = "idCliente", length = 100, nullable = false)
    private Integer idCliente;

    @Size(max = 100)
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public float getKilometros() {
        return kilometros;
    }

    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
    }

}
