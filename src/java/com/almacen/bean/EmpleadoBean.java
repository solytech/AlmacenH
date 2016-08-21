/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dao.departamentoDAO;
import com.almacen.dao.departamentoDaoImp;
import com.almacen.dao.empleadoDAO;
import com.almacen.dao.empleadoDaoImp;
import com.almacen.model.Acceso;
import com.almacen.model.Departamento;
import com.almacen.model.Empleado;
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
public class EmpleadoBean {
    empleadoDAO empleadoDao = new empleadoDaoImp();
    departamentoDAO dptoDao = new departamentoDaoImp();
    
    List<SelectItem> listaDpto;
    private List<SelectItem> listaEmpleado;
    
    Empleado empleado;
    
    Integer idDepto;
    private Integer idEmpleado;
    
    
    public EmpleadoBean(){
        empleado = new Empleado();
    }
    
    //***********************get y set *********************************

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }
    
    public List<SelectItem> getListaDpto() {
        this.listaDpto  = new ArrayList<>();
        departamentoDAO pDao = new departamentoDaoImp();
        List<Departamento> prv = pDao.listaDepto();
        listaDpto.clear();
        for(Departamento p: prv){
            SelectItem provItem = new SelectItem(p.getIdDepartamento(), p.getDepartamento());
            this.listaDpto.add(provItem);
        }
        
        return listaDpto;
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
    
    
    
    //*******************************************************************
    
    public void guardaEmpleado(){
        try{

           Date fecha = new Date();
           Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
           
           try{
               if (empleado == null || idEmpleado == 0) {
                   empleado.setFoto("/image");
                   empleado.setVigente("S");
                   empleado.setFechaReg(fecha);
                   Departamento depto = dptoDao.encuentraUnDepto(idDepto);
                   empleado.setDepartamento(depto);
                   empleado.setAcceso(acc);

                   empleadoDao.guardaEmpleado(empleado);
               }else{
                   empleadoDao.actualizaEmpleado(empleado);
               }
               
           }catch(Exception e){
               
           }
           
           
           
           limpiarTxt();
           
         
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Empleado Guardado Correctamente" ) );

        }catch(Exception e){
           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al Guardar Empleado" ) );
        }
        
    }
    
    public void editaEmpleado(){
        if( idEmpleado != 0 ){
            Empleado em = empleadoDao.encuentraEmpleado(idEmpleado);
            empleado = em;
            idDepto = em.getDepartamento().getIdDepartamento();
        }
        
    }
    
    public void limpiarTxt(){
        empleado = new Empleado();
        idEmpleado = null;
        idDepto = null;
    }
    
}
