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
import java.util.ArrayList;
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
    
    
    @Override
    public boolean eliminaSalAllArticulo(List<ArticuloSalida> lista) {
        boolean correcto = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try{
            for(ArticuloSalida as: lista){
                Transaction  transaction = session.beginTransaction();
                
                session.delete(as);
                transaction.commit();
                
            }
            session.close();
           
        } catch (Exception e){
            System.out.println(e.getMessage());
            
            correcto = false;
        }
        return correcto; 
        
    }
    
    @Override
    public List<ArticuloSalida> listaArtSalida (Integer idArtSal){
        
        List<ArticuloSalida> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        
        try {
            
            String hql = "FROM ArticuloSalida asal WHERE asal.articuloEntrada.idArticuloEntrada = "+idArtSal;
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
    public ArticuloSalida encuentraArtSal(Integer idArt) {
        
        ArticuloSalida p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM ArticuloSalida ars join fetch ArticuloEntrada ae where ae.idArticuloEntrada = "+idArt;
            p = (ArticuloSalida) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    }
    
    @Override
    public boolean encuentraArticulosSal(Integer idArt) {
        boolean encuentra = false;
        List<ArticuloSalida> p = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM ArticuloSalida ars where ars.articuloEntrada.idArticuloEntrada = "+idArt;
            p = session.createQuery(hql).list() ;
            transaction.commit();
            session.close();
            
            if(p.isEmpty()){
                encuentra  = false;
            }else{
                encuentra = true;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return encuentra;
        
    }
    
}
