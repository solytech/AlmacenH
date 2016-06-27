/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.UnidadDeMedida;
import java.util.List;

public interface unidadmedidaDAO {
    
    public UnidadDeMedida encuentraUdeMedida(Integer idUdm);
    
    public List<UnidadDeMedida> listaUnidadMedida();
    
}
