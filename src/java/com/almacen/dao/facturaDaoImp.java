/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Factura;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class facturaDaoImp implements facturaDAO{

    @Override
    public Factura guardaFactura(Factura factura) {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        
        try{
            
                session.save(factura);
                transaction.commit();
                session.close();
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return factura;  
    }
    
    @Override
    public Factura actualizaFactura(Factura factura) {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        
        try{
            
                session.update(factura);
                transaction.commit();
                session.close();
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return factura;  
    }
    
    
    @Override
    public Factura encuentraUnaFac(Integer idFac){
        Factura p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Factura d join fetch d.proveedor p where d.idFactura = "+idFac;
            p = (Factura) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    }
    
    @Override
    public List<Factura> listaFacturas(){
        List<Factura> p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Factura d join fetch d.proveedor p";
            p = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    } 
    
    @Override
    public List<Factura> facturasPorProv(Integer idProv){
        List<Factura> p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Factura d join fetch d.proveedor p where p.idProveedor = "+idProv;
            p = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    } 
    
}
