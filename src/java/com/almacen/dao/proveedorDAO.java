/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Proveedor;
import java.util.List;


public interface proveedorDAO {
    
    public List<Proveedor> listaProveedores();
    
    public Proveedor encuentraUnProv(Integer idProv);
    
    public Proveedor guardaProveedor(Proveedor prov);
    
    public void eliminarProveedor(Proveedor prov);
    
}
