/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dao.AccesoDaoImp;
import com.almacen.model.Acceso;
import com.almacen.model.Usuario;
import com.almacen.utilerias.Utilerias;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;



@Named
@SessionScoped
public class MenuBean implements Serializable{
    
    AccesoDaoImp accesoDAO = new AccesoDaoImp();
    
    private Acceso acceso;
    
    private MenuModel model;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    @PostConstruct
    public void init(){
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
        this.acceso = acc;
        
        model = new DefaultMenuModel();
        
        //First submenu
        
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Almacen");
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Entradas");
        DefaultSubMenu thirdSubmenu = new DefaultSubMenu("Salidas");
        //DefaultSubMenu fourSubmenu = new DefaultSubMenu("Herramientas");
        DefaultSubMenu quintoSubmenu = new DefaultSubMenu("Catálogos");
        DefaultSubMenu sextoSubmenu = new DefaultSubMenu("Reportes");
        
        DefaultMenuItem item4 = new DefaultMenuItem("Inicio"); 
        DefaultMenuItem item1 = new DefaultMenuItem("Captura Factura");
        DefaultMenuItem item2 = new DefaultMenuItem("Buscar Factura");
        DefaultMenuItem item3 = new DefaultMenuItem("Salida Mercancia");
        DefaultMenuItem item7 = new DefaultMenuItem("Buscar Salida");
        DefaultMenuItem item5 = new DefaultMenuItem("Proveedores");
        DefaultMenuItem item6 = new DefaultMenuItem("Articulos");
        DefaultMenuItem item8 = new DefaultMenuItem("Reporte por Proveedor");
        DefaultMenuItem item9 = new DefaultMenuItem("Departamentos");
        DefaultMenuItem item10 = new DefaultMenuItem("Empleados");
        
        item4.setUrl("../protegido/principal.xhtml");
        item1.setUrl("../protegido/capturaFactura.xhtml");
        item2.setUrl("../protegido/buscarFactura.xhtml");
        item3.setUrl("../protegido/salidaArticulos.xhtml");
        item5.setUrl("../protegido/proveedores.xhtml");
        item6.setUrl("../protegido/buscarArticulo.xhtml");
        item7.setUrl("../protegido/buscarSalida.xhtml");
        item8.setUrl("../protegido/reportes.xhtml");
        item9.setUrl("../protegido/departamento.xhtml");
        item10.setUrl("../protegido/empleado.xhtml");
        
        secondSubmenu.addElement(item1);
        secondSubmenu.addElement(item2);
        thirdSubmenu.addElement(item3);
        thirdSubmenu.addElement(item7);
        firstSubmenu.addElement(secondSubmenu);
        firstSubmenu.addElement(thirdSubmenu);
        //fourSubmenu.addElement(item5);
        //fourSubmenu.addElement(item6);
        
        quintoSubmenu.addElement(item5);
        quintoSubmenu.addElement(item6);
        quintoSubmenu.addElement(item9);
        quintoSubmenu.addElement(item10);
        sextoSubmenu.addElement(item8);
        
        model.addElement(item4); 
        model.addElement(firstSubmenu);
        model.addElement(quintoSubmenu);
        model.addElement(sextoSubmenu);
          
        
    }
    
    public void cerrarSesion(){
        acceso.setFechaSale(Utilerias.fecha());
        //Edita Acceso
        Acceso a = accesoDAO.registraAcceso(acceso);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
}
