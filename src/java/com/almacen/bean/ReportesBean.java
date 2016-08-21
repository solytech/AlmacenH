/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dao.proveedorDAO;
import com.almacen.dao.proveedorDaoImp;
import com.almacen.model.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class ReportesBean {
    
    private List<SelectItem> listaProv;
    
    private Integer idProv = 0;

    
    //************* get y set *********************
    public Integer getIdProv() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idProvRep", idProv);
        return idProv;
    }

    public void setIdProv(Integer idProv) {
        this.idProv = idProv;
    }
    
    //*********************************************
    
    
    
    public List<SelectItem> getListaProv() {   
        this.listaProv = new ArrayList<>();
        proveedorDAO pDao = new proveedorDaoImp();
        List<Proveedor> prv = pDao.listaProveedores();
        listaProv.clear();
        for(Proveedor p: prv){
            SelectItem provItem = new SelectItem(p.getIdProveedor(), p.getRfc()+" - "+p.getProveedor());
            this.listaProv.add(provItem);
        }
        
        return listaProv;
    }
    
    
    
}
