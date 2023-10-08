package com.example.API.Taller.Mecanico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

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
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Size(max = 100)
    @Column(name = "eliminado", nullable = false)
    private boolean eliminado;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] licenciaFrente;

    @Lob
    private byte[] licenciaDorso;

    public byte[] getLicenciaFrente() {
        return licenciaFrente;
    }

    public void setLicenciaFrente(byte[] licenciaFrente) {
        this.licenciaFrente = licenciaFrente;
    }

    public byte[] getLicenciaDorso() {
        return licenciaDorso;
    }

    public void setLicenciaDorso(byte[] licenciaDorso) {
        this.licenciaDorso = licenciaDorso;
    }

    public Integer getIdCliente() {
        return idCliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
