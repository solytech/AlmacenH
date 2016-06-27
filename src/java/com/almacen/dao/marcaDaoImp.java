/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Marca;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class marcaDaoImp implements marcaDAO{

    @Override
    public List<Marca> listaMarca() {
        List<Marca> listaMarcas = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Marca m";
            listaMarcas = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return listaMarcas;
    }
    
    @Override
    public Marca encuentraUnProv(Integer idMarca){
        Marca p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Marca d where d.idMarca = "+idMarca;
            p = (Marca) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    }
    
    @Override
    public Marca guardaMarca(Marca marca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
             
            
            session.save(marca);
            transaction.commit();
            session.close();
                
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return marca; 
    }
    
}
