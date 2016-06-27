/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Marca;
import java.util.List;

public interface marcaDAO {
    
    public List<Marca> listaMarca();
    
    public Marca encuentraUnProv(Integer idMarca);
    
    public Marca guardaMarca(Marca marca);
    
}