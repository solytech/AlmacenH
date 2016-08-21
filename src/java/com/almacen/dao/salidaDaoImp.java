/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.ArticuloSalida;
import com.almacen.model.Salida;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class salidaDaoImp implements salidaDAO{

    @Override
    public boolean guardaSalida(Salida salida) {
        boolean correcto = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
            session.save(salida);
            transaction.commit();
            session.close();
                
           
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
            correcto = false;
        }
        return correcto; 
        
    }
    
    @Override
    public boolean actualizaSalida(Salida salida) {
        boolean esCorrecto =  true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
               
            session.update(salida);
            transaction.commit();
            session.close();
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
            esCorrecto = false;
        }
        return esCorrecto; 
    }
    
    @Override
    public boolean eliminaSalida(Salida salida) {
        boolean esCorrecto =  true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
               
            session.delete(salida);
            transaction.commit();
            session.close();
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
            esCorrecto = false;
        }
        return esCorrecto; 
    }
    
    @Override
    public Salida ultimaSalidaAgregada(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        List<Salida> lista = null;
        Salida salida = new Salida();
        try {
            
            String hql = "FROM Salida ae order by ae.idSalida desc";
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            salida = lista.get(0);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return salida;
    }
    
    @Override
    public List<Salida> listadoSalidas(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        List<Salida> lista = null;
        
        try {
            
            String hql = "FROM Salida s join fetch s.departamento d join fetch s.empleado order by s.fechaSalida";
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return lista;
    }
    
    @Override
    public List<ArticuloSalida> articulosPorSalida(Integer idSalida){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        List<ArticuloSalida> lista = null;
        
        try {
            
            String hql = "FROM ArticuloSalida asal join fetch asal.salida s join fetch asal.articuloEntrada ae join fetch ae.articulo a join fetch ae.factura f join fetch f.proveedor p where s.idSalida = "+idSalida;
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return lista;
    }
    
}
