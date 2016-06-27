/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.model.Usuario;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ViewScoped
public class plantillaBean implements Serializable{
    
    
    
    public void verificaSesion(){  
        
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            System.out.println("*** o que tiene usuario--->>"+us.getUsuario());
            if(us == null){
                context.getExternalContext().redirect("../../permisos.xhtml");
            }
            
        }catch (Exception e){
            //log..
        }
        
    }
    
}
