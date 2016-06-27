/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.FormaDePago;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class formadepagoDaoImp implements formadepagoDAO{

    @Override
    public List<FormaDePago> listaFdp() {
       
        List<FormaDePago> listaFdp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM FormaDePago f";
            listaFdp = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return listaFdp;
    }
    
    @Override
    public FormaDePago encuentraUnFdp(Integer idFdp){
        FormaDePago fp = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM FormaDePago fp where fp.idFormaDePago = "+idFdp;
            fp = (FormaDePago) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return fp;
        
    } 
    
}
