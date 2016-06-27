
package com.almacen.bean;

import com.almacen.dao.AccesoDaoImp;
import com.almacen.dao.sesionDAO;
import com.almacen.dao.sesionDaoImp;
import com.almacen.model.Acceso;
import com.almacen.model.Usuario;

import com.almacen.utilerias.Utilerias;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class UsuarioBean {
    
    private Usuario usuario;
    
    public UsuarioBean(){
        usuario = new Usuario();
    } 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    public String iniciarSesion(){
        sesionDaoImp sesionDAO = new sesionDaoImp();
        AccesoDaoImp accesoDAO = new AccesoDaoImp();
        Usuario us = null;
        Acceso acc;
        String redireccion = null;
        
        try{
            us = sesionDAO.iniciarSesion(this.usuario);
            
            if(us != null){
                  
                //Almacenar en la sesión de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                acc = Utilerias.datosAcceso(us);
                
                String OS = System.getProperty("os.name").toLowerCase();
                //System.out.println("**** que sistema operativo es:---->>>"+OS);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("so", OS);
                
                //insertar acceso
                acc = accesoDAO.registraAcceso(acc);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("acceso", acc);
                redireccion = "/protegido/principal?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Datos incorrectos" ) );
            }
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error" ) );
        }
        return redireccion;
    }
    
    
}
