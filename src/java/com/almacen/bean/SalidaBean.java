/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dao.articuloentradaDAO;
import com.almacen.dao.articuloentradaDaoImp;
import com.almacen.dao.departamentoDAO;
import com.almacen.dao.departamentoDaoImp;
import com.almacen.dao.empleadoDAO;
import com.almacen.dao.empleadoDaoImp;
import com.almacen.dao.facturaDAO;
import com.almacen.dao.facturaDaoImp;
import com.almacen.dao.proveedorDAO;
import com.almacen.dao.proveedorDaoImp;
import com.almacen.dao.salidaDAO;
import com.almacen.dao.salidaDaoImp;
import com.almacen.dao.salidaarticuloDAO;
import com.almacen.dao.salidaarticuloDaoImp;
import com.almacen.model.Acceso;
import com.almacen.model.ArticuloEntrada;
import com.almacen.model.Departamento;
import com.almacen.model.Empleado;
import com.almacen.model.Factura;
import com.almacen.model.Proveedor;
import com.almacen.model.Salida;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class SalidaBean {
    articuloentradaDAO artEntDao = new articuloentradaDaoImp();
    facturaDAO facturaDao = new facturaDaoImp();
    salidaDAO salidaDao = new salidaDaoImp();
    departamentoDAO dptoDao =  new departamentoDaoImp();
    empleadoDAO empleadoDao =  new empleadoDaoImp();
    salidaarticuloDAO salArtDao = new salidaarticuloDaoImp();
    
    private List<SelectItem> listaProv;
    private List<SelectItem> listaFacturas;
    private List<SelectItem> listaEmpleado;
    
    private List<ArticuloEntrada> listaArticulos;
    
    private Integer opcion;
    private Integer idProv;
    private Integer idFac;
    private Integer idEmpleado;
    
    private Boolean mostrarPorArticulos = false;
    private Boolean mostrarPorFactura = false;
    private Boolean mostrarListado = false;
    
    private Factura factura;
    private Salida salida;
    
    
    public SalidaBean(){
        salida = new Salida();
    }
    

    //************************** get y set *************************************

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }
    
    public Integer getIdEmpleado() {
        return idEmpleado;
    }
    
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Factura getFactura() {
        this.factura = facturaDao.encuentraUnaFac(idFac);
        return factura;
    }

    public List<ArticuloEntrada> getListaArticulos() {
        this.listaArticulos = artEntDao.listaArtEnt(idFac);
        return listaArticulos;
    }

    public Integer getIdFac() {
        return idFac;
    }
    
    public void setIdFac(Integer idFac) {
        this.idFac = idFac;
    }

    public Integer getIdProv() {
        return idProv;
    }
     
    public void setIdProv(Integer idProv) {    
        this.idProv = idProv;
    }

    public Boolean getMostrarPorArticulos() {
        return mostrarPorArticulos;
    }

    public void setMostrarPorArticulos(Boolean mostrarPorArticulos) {
        this.mostrarPorArticulos = mostrarPorArticulos;
    }

    public Boolean getMostrarPorFactura() {
        return mostrarPorFactura;
    }

    public void setMostrarPorFactura(Boolean mostrarPorFactura) {
        this.mostrarPorFactura = mostrarPorFactura;
    }

    public Boolean getMostrarListado() {
        return mostrarListado;
    }

    public void setMostrarListado(Boolean mostrarListado) {
        this.mostrarListado = mostrarListado;
    }
   
    public Integer getOpcion() {
        return opcion;
    }

    public void setOpcion(Integer opcion) {
        this.opcion = opcion;
    }
    
    public List<SelectItem> getListaProv() {   
        this.listaProv = new ArrayList<>();
        proveedorDAO pDao = new proveedorDaoImp();
        List<Proveedor> prv = pDao.listaProveedores();
        listaProv.clear();
        for(Proveedor p: prv){
            SelectItem provItem = new SelectItem(p.getIdProveedor(), p.getRfc());
            this.listaProv.add(provItem);
        }
        
        return listaProv;
    }

    public List<SelectItem> getListaFacturas() {
        this.listaFacturas = new ArrayList<>();
        facturaDAO fDao = new facturaDaoImp();
        List<Factura> fac = fDao.facturasPorProv(idProv);
        listaFacturas.clear();
        for(Factura f: fac){
            SelectItem provItem = new SelectItem(f.getIdFactura(), f.getFolioFactura());
            this.listaFacturas.add(provItem);
        }
        
        return listaFacturas;
    }

    public List<SelectItem> getListaEmpleado() {
        this.listaEmpleado = new ArrayList<>();
        List<Empleado> emp = empleadoDao.listaEmpleados();
        listaEmpleado.clear();
        for(Empleado p: emp){
            SelectItem provItem = new SelectItem(p.getIdEmpleado(), p.getNombre()+" "+p.getApp()+" "+p.getApm());
            this.listaEmpleado.add(provItem);
        }
        
        return listaEmpleado;
    }
    
    
    
    
    //**************************************************************************
    
    public void guardaSalidaFactura(){
        Date fecha = new Date();
        Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
           
        try{
            //********** Guardamos Primeo datos de la salida *************
            Departamento dpto = dptoDao.encuentraUnDepto(factura.getDepartamento().getIdDepartamento());
            Empleado emp = empleadoDao.encuentraEmpleado(idEmpleado);

            salida.setDepartamento(dpto);
            salida.setEmpleado(emp);
            salida.setVigente("S");
            salida.setFechaReg(fecha);
            salida.setAcceso(acc);

            boolean seGuardaSalida = salidaDao.guardaSalida(salida);

            Salida sal = salidaDao.ultimaSalidaAgregada();

            //*********** Guardamos los articulos que van a salir ***********
            boolean seGuardanArticulos = salArtDao.guardaSalidaAllArticulo(listaArticulos, sal, fecha, acc);
            
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Salida de Articulos Guardada Correctamente" ) );
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al Guardar Salida de Articulos" ) );
        }
        
    }
    
    
    
    
    public void mostrarOpcion(){
        System.out.println("******* valor de opcion ---->>"+opcion);
        if(opcion == 1){
            mostrarPorFactura = true;
            mostrarListado = true;
            mostrarPorArticulos = false;
            listaArticulos = null;
        }
        if(opcion == 2){
            mostrarPorArticulos = true;
            mostrarListado = true;
            mostrarPorFactura = false;
            listaArticulos = null;
        }
        System.out.println("**** valores de variables -->>"+mostrarPorArticulos+" / "+mostrarListado);
    }
    
}
