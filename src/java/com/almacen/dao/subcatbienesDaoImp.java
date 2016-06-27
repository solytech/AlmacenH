/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.SubCatalogoBienes;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class subcatbienesDaoImp implements subcatbienesDAO{

    @Override
    public List<SubCatalogoBienes> listaSubCatBienes() {
        List<SubCatalogoBienes> listarSubCatBie = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM SubCatalogoBienes su ORDER BY su.subCatalogo";
            listarSubCatBie = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return listarSubCatBie;
    }
    
    @Override
    public SubCatalogoBienes encuentraSubCat(Integer idSct){
        SubCatalogoBienes p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM SubCatalogoBienes d where d.idSubCatalogoBienes = "+idSct;
            p = (SubCatalogoBienes) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    }
    
}
