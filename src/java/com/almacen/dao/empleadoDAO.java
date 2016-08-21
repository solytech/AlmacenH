/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Empleado;
import java.util.List;

public interface empleadoDAO {
    
    public Empleado guardaEmpleado(Empleado empleado);
    
    public List<Empleado> listaEmpleados();
    
    public Empleado encuentraEmpleado(Integer idEmpleado);
    
    public Empleado actualizaEmpleado(Empleado empleado);
    
}
