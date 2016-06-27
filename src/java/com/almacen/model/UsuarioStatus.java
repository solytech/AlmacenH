package com.almacen.model;
// Generated 27/06/2016 04:27:58 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UsuarioStatus generated by hbm2java
 */
public class UsuarioStatus  implements java.io.Serializable {


     private Integer idUsuarioStatus;
     private String usuarioStatusl;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public UsuarioStatus() {
    }

	
    public UsuarioStatus(String usuarioStatusl) {
        this.usuarioStatusl = usuarioStatusl;
    }
    public UsuarioStatus(String usuarioStatusl, Set<Usuario> usuarios) {
       this.usuarioStatusl = usuarioStatusl;
       this.usuarios = usuarios;
    }
   
    public Integer getIdUsuarioStatus() {
        return this.idUsuarioStatus;
    }
    
    public void setIdUsuarioStatus(Integer idUsuarioStatus) {
        this.idUsuarioStatus = idUsuarioStatus;
    }
    public String getUsuarioStatusl() {
        return this.usuarioStatusl;
    }
    
    public void setUsuarioStatusl(String usuarioStatusl) {
        this.usuarioStatusl = usuarioStatusl;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}


