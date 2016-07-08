/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dto;

import com.almacen.model.ArticuloEntrada;


public class listaArtEntDTO {
    
    private ArticuloEntrada artEnt;
    private Integer idArtEnt;
    private Boolean seleccionado;

    public ArticuloEntrada getArtEnt() {
        return artEnt;
    }

    public void setArtEnt(ArticuloEntrada artEnt) {
        this.artEnt = artEnt;
    }

    public Integer getIdArtEnt() {
        return idArtEnt;
    }

    public void setIdArtEnt(Integer idArtEnt) {
        this.idArtEnt = idArtEnt;
    }

    public Boolean getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
    
    
}
