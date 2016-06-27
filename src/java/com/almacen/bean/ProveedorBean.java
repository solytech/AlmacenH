/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dao.proveedorDAO;
import com.almacen.dao.proveedorDaoImp;
import com.almacen.model.Acceso;
import com.almacen.model.Proveedor;
import com.almacen.model.Usuario;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class ProveedorBean {
    
    proveedorDAO provDao = new proveedorDaoImp();
    
    private List<Proveedor> listar;

    public List<Proveedor> getListar() {
        listar = provDao.listaProveedores();
        return listar;
    }
    
    private Proveedor proveedor;
    
    public ProveedorBean(){
        proveedor = new Proveedor();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public void prepararNuevoProveedor(ActionEvent actionEvent){
        proveedor   = new Proveedor();
    }
    
    public void registrar(){
        try{
            Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            Date fecha = new Date();
            acc.setUsuario(us);
            System.out.println("*********************************");
            System.out.println("idacceso que guarda-->>" + acc.getIdAcceso());
            System.out.println("idusuario que guarda-->>" + acc.getUsuario().getIdUsuario());
            System.out.println("idusuario objeto-->>" + us.getIdUsuario());
            System.out.println("fecha objeto-->>" + fecha);
            System.out.println("*********************************");
            proveedor.setVigente("S");
            proveedor.setFechareg(fecha);
            proveedor.setAcceso(acc);

            provDao.guardaProveedor(proveedor);
            
            limpiaFormulario();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Proveedor Guardado Correctamente" ) );
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al Guardar Proveedor" ) );
        }
        
        
    }
    
    public void eliminarProveedor(){
        provDao.eliminarProveedor(proveedor);
        limpiaFormulario();
    }
    
    public void cancelar(){
        proveedor = new Proveedor();
    }
    
    public void limpiaFormulario(){
        
        proveedor = null;
        
    }
    
    
}
