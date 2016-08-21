/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dao.departamentoDAO;
import com.almacen.dao.departamentoDaoImp;
import com.almacen.model.Acceso;
import com.almacen.model.Departamento;
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
public class DepartamentoBean {
    
    departamentoDAO deptoDAO = new departamentoDaoImp();
    
    List<SelectItem> listaDpto;
    
    private Integer idDepto;
    
    private Departamento depto;
    
    public DepartamentoBean(){
        
        depto = new Departamento();
    }
    
    
    //****************** get y  set ************************

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }
    
    public Departamento getDepto() {
        //if(idDepto != 0){
        //    this.depto = deptoDAO.encuentraUnDepto(idDepto);
        //}
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
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
    
    
    //******************************************************

    public void guardarDepto(){
        Byte x = 1;
        Date fecha = new Date();
        Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
        try{
            
            if(depto == null ){
                depto.setAcceso(acc);
                depto.setFechaReg(fecha);
                depto.setIdDeptoPadre(x);
                depto.setIdNivelDepartamento(x);
                depto.setVigente("S");

                Departamento d = deptoDAO.guardaDepto(depto);
            }else{
                
                Departamento de = deptoDAO.actualizaDepto(depto);
                
            }
            
            
            limpiarTxt();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Departamento Guardado Correctamente" ) );
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al Guardar Departamento" ) );
        }
    }
    
    public void editaDepartamento(){
        
        if(idDepto != 0){
            depto = deptoDAO.encuentraUnDepto(idDepto);
        }
        
    }
    
    public void limpiarTxt(){
        
        depto = new Departamento();
        idDepto = null;
        
    }
    
}
