package com.almacen.model;
// Generated 29/06/2016 01:34:56 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * UsuarioPermiso generated by hbm2java
 */
public class UsuarioPermiso  implements java.io.Serializable {


     private Integer idUsuarioPermiso;
     private Acceso acceso;
     private Permiso permiso;
     private Usuario usuario;
     private Date fechaReg;

    public UsuarioPermiso() {
    }

    public UsuarioPermiso(Acceso acceso, Permiso permiso, Usuario usuario, Date fechaReg) {
       this.acceso = acceso;
       this.permiso = permiso;
       this.usuario = usuario;
       this.fechaReg = fechaReg;
    }
   
    public Integer getIdUsuarioPermiso() {
        return this.idUsuarioPermiso;
    }
    
    public void setIdUsuarioPermiso(Integer idUsuarioPermiso) {
        this.idUsuarioPermiso = idUsuarioPermiso;
    }
    public Acceso getAcceso() {
        return this.acceso;
    }
    
    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }
    public Permiso getPermiso() {
        return this.permiso;
    }
    
    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getFechaReg() {
        return this.fechaReg;
    }
    
    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }




}


