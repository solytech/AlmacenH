package com.almacen.model;
// Generated 27/06/2016 04:27:58 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ArticuloEntrada generated by hbm2java
 */
public class ArticuloEntrada  implements java.io.Serializable {


     private Integer idArticuloEntrada;
     private Acceso acceso;
     private Articulo articulo;
     private Departamento departamento;
     private Factura factura;
     private UnidadDeMedida unidadDeMedida;
     private BigDecimal cantidad;
     private BigDecimal unidadesPorCaja;
     private BigDecimal unidadesPorPaquete;
     private BigDecimal piezas;
     private BigDecimal costoUnitario;
     private BigDecimal costoCaja;
     private BigDecimal costoPaquete;
     private BigDecimal costoPieza;
     private String esResguardo;
     private String numeroDeSerie;
     private String observaciones;
     private String cbInterno;
     private Date fechaReg;
     private Set<ArticuloSalida> articuloSalidas = new HashSet<ArticuloSalida>(0);

    public ArticuloEntrada() {
    }

	
    public ArticuloEntrada(Acceso acceso, Articulo articulo, Departamento departamento, Factura factura, UnidadDeMedida unidadDeMedida, BigDecimal piezas, BigDecimal costoUnitario, String cbInterno) {
        this.acceso = acceso;
        this.articulo = articulo;
        this.departamento = departamento;
        this.factura = factura;
        this.unidadDeMedida = unidadDeMedida;
        this.piezas = piezas;
        this.costoUnitario = costoUnitario;
        this.cbInterno = cbInterno;
    }
    public ArticuloEntrada(Acceso acceso, Articulo articulo, Departamento departamento, Factura factura, UnidadDeMedida unidadDeMedida, BigDecimal cantidad, BigDecimal unidadesPorCaja, BigDecimal unidadesPorPaquete, BigDecimal piezas, BigDecimal costoUnitario, BigDecimal costoCaja, BigDecimal costoPaquete, BigDecimal costoPieza, String esResguardo, String numeroDeSerie, String observaciones, String cbInterno, Date fechaReg, Set<ArticuloSalida> articuloSalidas) {
       this.acceso = acceso;
       this.articulo = articulo;
       this.departamento = departamento;
       this.factura = factura;
       this.unidadDeMedida = unidadDeMedida;
       this.cantidad = cantidad;
       this.unidadesPorCaja = unidadesPorCaja;
       this.unidadesPorPaquete = unidadesPorPaquete;
       this.piezas = piezas;
       this.costoUnitario = costoUnitario;
       this.costoCaja = costoCaja;
       this.costoPaquete = costoPaquete;
       this.costoPieza = costoPieza;
       this.esResguardo = esResguardo;
       this.numeroDeSerie = numeroDeSerie;
       this.observaciones = observaciones;
       this.cbInterno = cbInterno;
       this.fechaReg = fechaReg;
       this.articuloSalidas = articuloSalidas;
    }
   
    public Integer getIdArticuloEntrada() {
        return this.idArticuloEntrada;
    }
    
    public void setIdArticuloEntrada(Integer idArticuloEntrada) {
        this.idArticuloEntrada = idArticuloEntrada;
    }
    public Acceso getAcceso() {
        return this.acceso;
    }
    
    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }
    public Articulo getArticulo() {
        return this.articulo;
    }
    
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public UnidadDeMedida getUnidadDeMedida() {
        return this.unidadDeMedida;
    }
    
    public void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }
    public BigDecimal getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getUnidadesPorCaja() {
        return this.unidadesPorCaja;
    }
    
    public void setUnidadesPorCaja(BigDecimal unidadesPorCaja) {
        this.unidadesPorCaja = unidadesPorCaja;
    }
    public BigDecimal getUnidadesPorPaquete() {
        return this.unidadesPorPaquete;
    }
    
    public void setUnidadesPorPaquete(BigDecimal unidadesPorPaquete) {
        this.unidadesPorPaquete = unidadesPorPaquete;
    }
    public BigDecimal getPiezas() {
        return this.piezas;
    }
    
    public void setPiezas(BigDecimal piezas) {
        this.piezas = piezas;
    }
    public BigDecimal getCostoUnitario() {
        return this.costoUnitario;
    }
    
    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
    public BigDecimal getCostoCaja() {
        return this.costoCaja;
    }
    
    public void setCostoCaja(BigDecimal costoCaja) {
        this.costoCaja = costoCaja;
    }
    public BigDecimal getCostoPaquete() {
        return this.costoPaquete;
    }
    
    public void setCostoPaquete(BigDecimal costoPaquete) {
        this.costoPaquete = costoPaquete;
    }
    public BigDecimal getCostoPieza() {
        return this.costoPieza;
    }
    
    public void setCostoPieza(BigDecimal costoPieza) {
        this.costoPieza = costoPieza;
    }
    public String getEsResguardo() {
        return this.esResguardo;
    }
    
    public void setEsResguardo(String esResguardo) {
        this.esResguardo = esResguardo;
    }
    public String getNumeroDeSerie() {
        return this.numeroDeSerie;
    }
    
    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getCbInterno() {
        return this.cbInterno;
    }
    
    public void setCbInterno(String cbInterno) {
        this.cbInterno = cbInterno;
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


