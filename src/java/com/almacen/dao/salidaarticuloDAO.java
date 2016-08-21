/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Acceso;
import com.almacen.model.ArticuloEntrada;
import com.almacen.model.ArticuloSalida;
import com.almacen.model.Salida;
import java.util.Date;
import java.util.List;


public interface salidaarticuloDAO {
    public boolean guardaSalidaAllArticulo(List<ArticuloEntrada> lista, Salida idSalida, Date fecha, Acceso acc);
    
    public List<ArticuloSalida> listaArtSalida (Integer idArtSal);
    
    public boolean eliminaSalAllArticulo(List<ArticuloSalida> lista);
    
    public ArticuloSalida encuentraArtSal(Integer idArt);
    
    public boolean encuentraArticulosSal(Integer idArt);
   
}
