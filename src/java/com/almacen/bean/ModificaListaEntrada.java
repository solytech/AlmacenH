/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dto.listaArtEntDTO;
import com.almacen.model.ArticuloEntrada;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@RequestScoped
public class ModificaListaEntrada {
    
    public void eliminaArtEntrada(listaArtEntDTO artEnt){
        
        System.out.println("*** objeto que recibe -->>"+artEnt.getArtEnt().getCbInterno());
        
    }
    
    
}
