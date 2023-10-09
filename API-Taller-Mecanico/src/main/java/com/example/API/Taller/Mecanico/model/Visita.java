package com.example.API.Taller.Mecanico.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "Visita")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @Size(max = 100)
    @Column(name = "fechaVisita", length = 100, nullable = false)
    private Date fechaVisita;

    @Size(max = 100)
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    public Integer getId() {
        return id;
    }


    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
