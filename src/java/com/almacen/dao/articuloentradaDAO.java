/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.ArticuloEntrada;
import java.util.List;

public interface articuloentradaDAO {
    
    public ArticuloEntrada guardaArticuloEntrada(ArticuloEntrada artEnt);
    
    public ArticuloEntrada actualizarArticuloEntrada(ArticuloEntrada artEnt);
    
    public List<ArticuloEntrada> listaArtEnt (Integer idFactura);
    
    public ArticuloEntrada ultimoAgregado(Integer idFactura);
    
    public List<ArticuloEntrada> buscarArtEnt(String articulo);
    
    public ArticuloEntrada encuentraArtEnt(Integer idArt);
    
    public List<ArticuloEntrada> allArtEnt();
    
}
