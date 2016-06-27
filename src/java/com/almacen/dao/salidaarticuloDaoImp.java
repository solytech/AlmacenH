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
import com.almacen.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class salidaarticuloDaoImp implements salidaarticuloDAO{

    @Override
    public boolean guardaSalidaAllArticulo(List<ArticuloEntrada> lista, Salida idSalida, Date fecha, Acceso acc) {
        boolean correcto = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try{
            for(ArticuloEntrada ae: lista){
                Transaction  transaction = session.beginTransaction();
                ArticuloSalida as =  new ArticuloSalida();
                as.setSalida(idSalida);
                as.setArticuloEntrada(ae);
                as.setUnidadDeMedida(ae.getUnidadDeMedida());
                as.setCantidadPieza(ae.getPiezas());
                as.setCantidadPaquete(ae.getUnidadesPorPaquete());
                as.setCantidadCaja(ae.getUnidadesPorCaja());
                as.setEsResguardo(ae.getEsResguardo());
                as.setNumSerie(ae.getNumeroDeSerie());
                as.setFechaReg(fecha);
                as.setAcceso(acc);
                
                session.save(as);
                transaction.commit();
                
            }
            session.close();
           
        } catch (Exception e){
            System.out.println(e.getMessage());
            
            correcto = false;
        }
        return correcto; 
        
    }
    
    
}
