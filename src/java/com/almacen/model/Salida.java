package com.almacen.model;
// Generated 27/06/2016 04:27:58 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Salida generated by hbm2java
 */
public class Salida  implements java.io.Serializable {


     private Integer idSalida;
     private Acceso acceso;
     private Departamento departamento;
     private Empleado empleado;
     private String folio;
     private Date fechaSalida;
     private String observaciones;
     private String vigente;
     private Date fechaReg;
     private Set<ArticuloSalida> articuloSalidas = new HashSet<ArticuloSalida>(0);

    public Salida() {
    }

	
    public Salida(Acceso acceso, Departamento departamento, Empleado empleado, String folio, Date fechaSalida, Date fechaReg) {
        this.acceso = acceso;
        this.departamento = departamento;
        this.empleado = empleado;
        this.folio = folio;
        this.fechaSalida = fechaSalida;
        this.fechaReg = fechaReg;
    }
    public Salida(Acceso acceso, Departamento departamento, Empleado empleado, String folio, Date fechaSalida, String observaciones, String vigente, Date fechaReg, Set<ArticuloSalida> articuloSalidas) {
       this.acceso = acceso;
       this.departamento = departamento;
       this.empleado = empleado;
       this.folio = folio;
       this.fechaSalida = fechaSalida;
       this.observaciones = observaciones;
       this.vigente = vigente;
       this.fechaReg = fechaReg;
       this.articuloSalidas = articuloSalidas;
    }
   
    public Integer getIdSalida() {
        return this.idSalida;
    }
    
    public void setIdSalida(Integer idSalida) {
        this.idSalida = idSalida;
    }
    public Acceso getAcceso() {
        return this.acceso;
    }
    
    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public String getFolio() {
        return this.folio;
    }
    
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public Date getFechaSalida() {
        return this.fechaSalida;
    }
    
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getVigente() {
        return this.vigente;
    }
    
    public void setVigente(String vigente) {
        this.vigente = vigente;
    }
    public Date getFechaReg() {
        return this.fechaReg;
    }
    
    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }
    public Set<ArticuloSalida> getArticuloSalidas() {
        return this.articuloSalidas;
    }
    
    public void setArticuloSalidas(Set<ArticuloSalida> articuloSalidas) {
        this.articuloSalidas = articuloSalidas;
    }




}


