/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Articulo;
import java.util.List;

public interface articuloDAO {
    
    public Articulo encuentraArticulo(Integer idArt);
    
    public List<Articulo> listaArticulos();
    
    public Articulo guardaArticulo(Articulo articulo);
    
    public List<Articulo> buscarArticulo(String articulo);
    
}
