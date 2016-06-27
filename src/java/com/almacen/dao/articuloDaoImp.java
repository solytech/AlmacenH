/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;


import com.almacen.model.Articulo;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class articuloDaoImp implements articuloDAO{

    @Override
    public Articulo encuentraArticulo(Integer idArt) {
        
        Articulo p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Articulo d where d.idArticulo = "+idArt;
            p = (Articulo) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    }
    
    @Override
    public List<Articulo> listaArticulos() {
        List<Articulo> listarArticulos = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Articulo p";
            listarArticulos = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return listarArticulos;

    }
    
    @Override
    public Articulo guardaArticulo(Articulo articulo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
             
            if(articulo.getIdArticulo() == null ||  articulo.getIdArticulo() == 0 ){
                session.save(articulo);
                transaction.commit();
                
            }else{
                session.update(articulo);
                transaction.commit();
            }
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return articulo; 
    }
    
    @Override
    public List<Articulo> buscarArticulo(String articulo) {
        List<Articulo> lista = null;
        List<Articulo> encontrados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        
        String hql = "FROM Articulo a WHERE a.articulo LIKE '%"+articulo+"%'";
        lista = session.createQuery(hql).list();
        //transaction.commit();
        if(lista.isEmpty()){
            String hql2 = "FROM Articulo a WHERE a.cb LIKE '%"+articulo+"%'";
            lista = session.createQuery(hql2).list();
            
        }
        transaction.commit();
        session.close();
        
        return lista;
    }
    
    
}
