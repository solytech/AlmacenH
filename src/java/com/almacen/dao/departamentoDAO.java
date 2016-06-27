/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Departamento;
import java.util.List;

public interface departamentoDAO {
    
    public List<Departamento> listaDepto();
    
    public Departamento encuentraUnDepto(Integer idDepto);
    
}
