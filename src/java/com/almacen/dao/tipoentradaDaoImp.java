/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.TipoEntrada;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class tipoentradaDaoImp implements tipoentradaDAO{

    @Override
    public List<TipoEntrada> listaTipoEntrada() {
        List<TipoEntrada> listaTipoEntrada = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM TipoEntrada te";
            listaTipoEntrada = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return listaTipoEntrada;
    }
    
    @Override
    public TipoEntrada encuentraUnTe(Integer idTe){
        TipoEntrada te = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM TipoEntrada te where te.idTipoEntrada = "+idTe;
            te = (TipoEntrada) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return te;
        
    } 
    
    
}
