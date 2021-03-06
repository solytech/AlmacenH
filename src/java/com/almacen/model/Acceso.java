package com.almacen.model;
// Generated 29/06/2016 01:34:56 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Acceso generated by hbm2java
 */
public class Acceso  implements java.io.Serializable {


     private Integer idAcceso;
     private Usuario usuario;
     private Date fechaEntra;
     private Date fechaSale;
     private String ip;
     private Set<SubCatalogoBienes> subCatalogoBieneses = new HashSet<SubCatalogoBienes>(0);
     private Set<UsuarioPermiso> usuarioPermisos = new HashSet<UsuarioPermiso>(0);
     private Set<Proveedor> proveedors = new HashSet<Proveedor>(0);
     private Set<FormaDePago> formaDePagos = new HashSet<FormaDePago>(0);
     private Set<Factura> facturas = new HashSet<Factura>(0);
     private Set<TipoEntrada> tipoEntradas = new HashSet<TipoEntrada>(0);
     private Set<CatalogoBienes> catalogoBieneses = new HashSet<CatalogoBienes>(0);
     private Set<Empleado> empleados = new HashSet<Empleado>(0);
     private Set<Articulo> articulos = new HashSet<Articulo>(0);
     private Set<Departamento> departamentos = new HashSet<Departamento>(0);
     private Set<TipoPartida> tipoPartidas = new HashSet<TipoPartida>(0);
     private Set<Marca> marcas = new HashSet<Marca>(0);
     private Set<ArticuloSalida> articuloSalidas = new HashSet<ArticuloSalida>(0);
     private Set<Salida> salidas = new HashSet<Salida>(0);
     private Set<ArticuloEntrada> articuloEntradas = new HashSet<ArticuloEntrada>(0);

    public Acceso() {
    }

	
    public Acceso(Usuario usuario, Date fechaEntra, Date fechaSale, String ip) {
        this.usuario = usuario;
        this.fechaEntra = fechaEntra;
        this.fechaSale = fechaSale;
        this.ip = ip;
    }
    public Acceso(Usuario usuario, Date fechaEntra, Date fechaSale, String ip, Set<SubCatalogoBienes> subCatalogoBieneses, Set<UsuarioPermiso> usuarioPermisos, Set<Proveedor> proveedors, Set<FormaDePago> formaDePagos, Set<Factura> facturas, Set<TipoEntrada> tipoEntradas, Set<CatalogoBienes> catalogoBieneses, Set<Empleado> empleados, Set<Articulo> articulos, Set<Departamento> departamentos, Set<TipoPartida> tipoPartidas, Set<Marca> marcas, Set<ArticuloSalida> articuloSalidas, Set<Salida> salidas, Set<ArticuloEntrada> articuloEntradas) {
       this.usuario = usuario;
       this.fechaEntra = fechaEntra;
       this.fechaSale = fechaSale;
       this.ip = ip;
       this.subCatalogoBieneses = subCatalogoBieneses;
       this.usuarioPermisos = usuarioPermisos;
       this.proveedors = proveedors;
       this.formaDePagos = formaDePagos;
       this.facturas = facturas;
       this.tipoEntradas = tipoEntradas;
       this.catalogoBieneses = catalogoBieneses;
       this.empleados = empleados;
       this.articulos = articulos;
       this.departamentos = departamentos;
       this.tipoPartidas = tipoPartidas;
       this.marcas = marcas;
       this.articuloSalidas = articuloSalidas;
       this.salidas = salidas;
       this.articuloEntradas = articuloEntradas;
    }
   
    public Integer getIdAcceso() {
        return this.idAcceso;
    }
    
    public void setIdAcceso(Integer idAcceso) {
        this.idAcceso = idAcceso;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getFechaEntra() {
        return this.fechaEntra;
    }
    
    public void setFechaEntra(Date fechaEntra) {
        this.fechaEntra = fechaEntra;
    }
    public Date getFechaSale() {
        return this.fechaSale;
    }
    
    public void setFechaSale(Date fechaSale) {
        this.fechaSale = fechaSale;
    }
    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
    public Set<SubCatalogoBienes> getSubCatalogoBieneses() {
        return this.subCatalogoBieneses;
    }
    
    public void setSubCatalogoBieneses(Set<SubCatalogoBienes> subCatalogoBieneses) {
        this.subCatalogoBieneses = subCatalogoBieneses;
    }
    public Set<UsuarioPermiso> getUsuarioPermisos() {
        return this.usuarioPermisos;
    }
    
    public void setUsuarioPermisos(Set<UsuarioPermiso> usuarioPermisos) {
        this.usuarioPermisos = usuarioPermisos;
    }
    public Set<Proveedor> getProveedors() {
        return this.proveedors;
    }
    
    public void setProveedors(Set<Proveedor> proveedors) {
        this.proveedors = proveedors;
    }
    public Set<FormaDePago> getFormaDePagos() {
        return this.formaDePagos;
    }
    
    public void setFormaDePagos(Set<FormaDePago> formaDePagos) {
        this.formaDePagos = formaDePagos;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }
    public Set<TipoEntrada> getTipoEntradas() {
        return this.tipoEntradas;
    }
    
    public void setTipoEntradas(Set<TipoEntrada> tipoEntradas) {
        this.tipoEntradas = tipoEntradas;
    }
    public Set<CatalogoBienes> getCatalogoBieneses() {
        return this.catalogoBieneses;
    }
    
    public void setCatalogoBieneses(Set<CatalogoBienes> catalogoBieneses) {
        this.catalogoBieneses = catalogoBieneses;
    }
    public Set<Empleado> getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }
    public Set<Articulo> getArticulos() {
        return this.articulos;
    }
    
    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }
    public Set<Departamento> getDepartamentos() {
        return this.departamentos;
    }
    
    public void setDepartamentos(Set<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    public Set<TipoPartida> getTipoPartidas() {
        return this.tipoPartidas;
    }
    
    public void setTipoPartidas(Set<TipoPartida> tipoPartidas) {
        this.tipoPartidas = tipoPartidas;
    }
    public Set<Marca> getMarcas() {
        return this.marcas;
    }
    
    public void setMarcas(Set<Marca> marcas) {
        this.marcas = marcas;
    }
    public Set<ArticuloSalida> getArticuloSalidas() {
        return this.articuloSalidas;
    }
    
    public void setArticuloSalidas(Set<ArticuloSalida> articuloSalidas) {
        this.articuloSalidas = articuloSalidas;
    }
    public Set<Salida> getSalidas() {
        return this.salidas;
    }
    
    public void setSalidas(Set<Salida> salidas) {
        this.salidas = salidas;
    }
    public Set<ArticuloEntrada> getArticuloEntradas() {
        return this.articuloEntradas;
    }
    
    public void setArticuloEntradas(Set<ArticuloEntrada> articuloEntradas) {
        this.articuloEntradas = articuloEntradas;
    }




}


