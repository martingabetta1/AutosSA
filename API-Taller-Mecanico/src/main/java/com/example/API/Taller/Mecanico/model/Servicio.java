package com.example.API.Taller.Mecanico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Size(max = 100)
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    @ManyToOne
    @JoinColumn(name = "idOrden", referencedColumnName = "id", nullable = false)
    private OrdenTrabajo ordenTrabajo;

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
