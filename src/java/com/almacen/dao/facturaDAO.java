/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Factura;
import java.util.List;

public interface facturaDAO {
    
    public Factura guardaFactura(Factura factura);
    
    public Factura encuentraUnaFac(Integer idFac);
    
    public List<Factura> listaFacturas();
    
    public Factura actualizaFactura(Factura factura);
    
    public List<Factura> facturasPorProv(Integer idProv);
    
    public boolean facturaSalio(Integer idFactura);
    
}
