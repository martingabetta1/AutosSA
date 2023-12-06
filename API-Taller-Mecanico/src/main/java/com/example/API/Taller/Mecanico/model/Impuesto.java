package com.example.API.Taller.Mecanico.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@Table(name = "Impuesto")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(name = "porcentaje", nullable = false)
    private Integer porcentaje;

    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public Integer getId() {
        return id;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}