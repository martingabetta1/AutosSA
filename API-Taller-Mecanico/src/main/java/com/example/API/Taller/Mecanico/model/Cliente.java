package com.example.API.Taller.Mecanico.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Size(max = 100)
    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;

    @Size(max = 100)
    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @Size(max = 100)
    @Column(name = "telefono", length = 100, nullable = false)
    private String telefono;

    @Size(max = 100)
    @Column(name = "mail", length = 100, nullable = false)
    private String mail;

    @Size(max = 100)
    @Column(name = "localidad", length = 100, nullable = false)
    private String localidad;

    @Size(max = 100)
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    @Lob
    private byte[] licenciaFrente;

    @Lob
    private byte[] licenciaDorso;

    public byte[] getLicenciaDorso() {
        return licenciaDorso;
    }

    public void setLicenciaDorso(byte[] licenciaDorso) {
        this.licenciaDorso = licenciaDorso;
    }

    public byte[] getLicenciaFrente() {
        return licenciaFrente;
    }

    public void setLicenciaFrente(byte[] licenciaFrente) {
        this.licenciaFrente = licenciaFrente;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
