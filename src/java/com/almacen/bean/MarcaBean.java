/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dao.marcaDAO;
import com.almacen.dao.marcaDaoImp;
import com.almacen.model.Acceso;
import com.almacen.model.Marca;
import com.almacen.model.Usuario;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MarcaBean {
    
    marcaDAO marcaDao = new marcaDaoImp();
    
    public Marca marca;
    
    
    public MarcaBean(){
        marca = new Marca();
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    
    public void guardaMarca(){
        try{
            Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            Date fecha = new Date();
            acc.setUsuario(us);
            
            marca.setAcceso(acc);
            marca.setFechareg(fecha);
            marca.setVigente("S");

            marcaDao.guardaMarca(marca);
            
            limpiaFormulario();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Marca Guardada Correctamente" ) );
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al Guardar Marca" ) );
        }
        
    }
    
    public void limpiaFormulario(){
        marca = null;
    }
    
}
