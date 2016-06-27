/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.UnidadDeMedida;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class unidadmedidaDaoImp implements unidadmedidaDAO{

    @Override
    public UnidadDeMedida encuentraUdeMedida(Integer idUdm) {
        UnidadDeMedida p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM UnidadDeMedida d where d.idUnidadDeMedida = "+idUdm;
            p = (UnidadDeMedida) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
    }
    
    @Override
    public List<UnidadDeMedida> listaUnidadMedida() {
        List<UnidadDeMedida> listarUdm = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM UnidadDeMedida p";
            listarUdm = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return listarUdm;

    }
    
}
