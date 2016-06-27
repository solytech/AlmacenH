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
    
    
    Empleado empleado;
    
    Integer idDepto;
    
    
    public EmpleadoBean(){
        empleado = new Empleado();
    }
    
    //***********************get y set *********************************

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
    
    
    
    //*******************************************************************
    
    public void guardaEmpleado(){
        try{

           Date fecha = new Date();
           Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
           
           empleado.setFoto("/image");
           empleado.setVigente("S");
           empleado.setFechaReg(fecha);
           Departamento depto = dptoDao.encuentraUnDepto(idDepto);
           empleado.setDepartamento(depto);
           empleado.setAcceso(acc);
           
           empleadoDao.guardaEmpleado(empleado);
         
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Empleado Guardado Correctamente" ) );

        }catch(Exception e){
           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al Guardar Empleado" ) );
        }
        
    }
    
}
