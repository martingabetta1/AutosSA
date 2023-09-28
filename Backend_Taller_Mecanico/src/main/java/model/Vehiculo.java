package model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Vehiculo")
public class Vehiculo {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idVehiculo;

  @Column(name = "patente", length = 50, nullable = false)
   private String patente;

  //@Column(name = "modelo", length = 50, nullable = false)
  //private Modelo modelo;

  @Column(name = "anio", length = 50, nullable = false)
  private int anio;

  @Column(name = "kilometros", length = 50, nullable = false)
  private float kilometros;

  @Column(name = "eliminado", nullable = false)
  private boolean eliminado;

  @Column(name = "observaciones", length = 50, nullable = false)
  private String observaciones;

  //@Column(name = "cliente", length = 50, nullable = false)
  //private Cliente cliente;

//GETTERS Y SETTERS
    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    //public Modelo getModelo() {
    //    return modelo;
    //}

    //public void setModelo(Modelo modelo) {
    //    this.modelo = modelo;
    //}

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public float getKilometros() {
        return kilometros;
    }

    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    //public Cliente getCliente() {
    //    return cliente;
    //}

    //public void setCliente(Cliente cliente) {
    //    this.cliente = cliente;
    //}
}



//package com.example.crudangular.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "Pais", schema = "empleados")
//public class Pais {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idPais;
//
//    @Column(name = "nombre", length = 50, nullable = false)
//    private String nombre;
//
//    public Integer getIdPais() {
//        return idPais;
//    }
//
//    public void setIdPais(Integer idPais) {
//        this.idPais = idPais;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//}
