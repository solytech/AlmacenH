/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Departamento;
import com.almacen.model.Marca;
import com.almacen.model.Proveedor;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class departamentoDaoImp implements departamentoDAO{

    @Override
    public List<Departamento> listaDepto() {
        
        List<Departamento> listaDepto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Departamento dp";
            listaDepto = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return listaDepto;
    }
    
    @Override
    public Departamento encuentraUnDepto(Integer idDepto){
        Departamento depto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Departamento d where d.idDepartamento = "+idDepto;
            depto = (Departamento) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return depto;
        
    } 
    
    @Override
    public Departamento guardaDepto(Departamento depto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
             
            
            session.save(depto);
            transaction.commit();
            session.close();
                
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return depto; 
    }
    
    @Override
    public Departamento actualizaDepto(Departamento depto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
             
            
            session.update(depto);
            transaction.commit();
            session.close();
                
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return depto; 
    }
}
