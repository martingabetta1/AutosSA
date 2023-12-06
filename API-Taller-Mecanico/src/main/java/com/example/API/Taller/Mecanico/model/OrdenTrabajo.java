package com.example.API.Taller.Mecanico.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "OrdenTrabajo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @Column(name = "fechaInicio", length = 100, nullable = false)
    private Date fechaInicio;

    @Size(max = 100)
    @Column(name = "fechaFin", length = 100, nullable = false)
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "idVehiculo", referencedColumnName = "id", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "idTecnico", referencedColumnName = "id", nullable = false)
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "id", nullable = false)
    private Estado estado;
    
    @ManyToOne
    @JoinColumn(name = "impuesto", referencedColumnName = "id", nullable = false)
    private Impuesto impuesto;

    @Size(max = 100)
    @Column(name = "comentario", length = 100, nullable = false)
    private String comentario;
    
    @Column(name = "totalcosto")
    private Double totalCosto;
    
    
    public Double getTotalCosto() {
        return totalCosto;
    }

    public void calcularCosto(Double costo) {
    if (this.totalCosto == null) {
        this.totalCosto = costo;
    } else {
        this.totalCosto += costo;
    }
    }

    public void setTotalCosto(Double totalCosto) {
        this.totalCosto = totalCosto;
    }

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @Size(max = 100)
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Transient
    private String descripcion;


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    
}
