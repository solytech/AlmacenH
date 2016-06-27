/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.TipoEntrada;
import java.util.List;

public interface tipoentradaDAO {
    
    public List<TipoEntrada> listaTipoEntrada();
    
    public TipoEntrada encuentraUnTe(Integer idTe);
    
}
