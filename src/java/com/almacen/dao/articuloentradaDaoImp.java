/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.dto.listaArtEntDTO;
import com.almacen.model.ArticuloEntrada;
import com.almacen.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class articuloentradaDaoImp implements articuloentradaDAO{

    @Override
    public ArticuloEntrada guardaArticuloEntrada(ArticuloEntrada artEnt) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
             
            if(artEnt.getIdArticuloEntrada() == null ||  artEnt.getIdArticuloEntrada() == 0 ){
                System.out.println("***** entra al if guardar articulo entrada ******");
                session.save(artEnt);
                transaction.commit();
                
            }else{
                System.out.println("***** entra al else modifica articulo entrada ******" +artEnt.getIdArticuloEntrada());
                session.update(artEnt);
                transaction.commit();
                
            }
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return artEnt; 
    }
    
    @Override
    public ArticuloEntrada actualizarArticuloEntrada(ArticuloEntrada artEnt) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
             
            System.out.println("***** entra al else modifica articulo entrada ******" + artEnt.getIdArticuloEntrada());
            session.update(artEnt);
            transaction.commit();
            session.close();
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return artEnt; 
    }
    
    @Override
    public List<ArticuloEntrada> listaArtEnt (Integer idFactura){
        
        List<ArticuloEntrada> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        
        try {
            
            String hql = "FROM ArticuloEntrada ae join fetch ae.unidadDeMedida um join fetch ae.articulo a join fetch ae.departamento WHERE ae.factura.idFactura = "+idFactura ;
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
    public List<listaArtEntDTO> listaArtEntDTO (Integer idFactura){
        
        List<ArticuloEntrada> lista = null;
        List<listaArtEntDTO> listaDTO = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        
        try {
            
            String hql = "FROM ArticuloEntrada ae join fetch ae.unidadDeMedida um join fetch ae.articulo a join fetch ae.departamento WHERE ae.factura.idFactura = "+idFactura ;
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            for(ArticuloEntrada ae: lista){
                listaArtEntDTO aeDTO = new listaArtEntDTO();
                aeDTO.setArtEnt(ae);
                aeDTO.setIdArtEnt(ae.getIdArticuloEntrada());
                aeDTO.setSeleccionado(Boolean.FALSE);
                
                listaDTO.add(aeDTO);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
       
        return listaDTO;
    }
    
    @Override
    public List<ArticuloEntrada> allArtEnt(){
        
        List<ArticuloEntrada> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        
        try {
            
            String hql = "FROM ArticuloEntrada ae join fetch ae.unidadDeMedida um join fetch ae.articulo a join fetch ae.departamento";
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
    public ArticuloEntrada ultimoAgregado(Integer idFactura){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        List<ArticuloEntrada> lista = null;
        ArticuloEntrada ae = new ArticuloEntrada();
        try {
            
            String hql = "FROM ArticuloEntrada ae WHERE ae.factura.idFactura = "+ idFactura +" order by ae.idArticuloEntrada desc";
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            ae = lista.get(0);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return ae;
    }
    
    @Override
    public List<ArticuloEntrada> buscarArtEnt(String articulo) {
        List<ArticuloEntrada> lista = null;
        List<ArticuloEntrada> encontrados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        
        String hql = "FROM ArticuloEntrada e join fetch e.articulo a WHERE a.articulo LIKE '%"+articulo+"%'";
        lista = session.createQuery(hql).list();
        //transaction.commit();
        if(lista.isEmpty()){
            String hql2 = "FROM ArticuloEntrada e join fetch e.articulo a WHERE e.cbInterno LIKE '%"+articulo+"%'";
            lista = session.createQuery(hql2).list();
            
        }
        transaction.commit();
        session.close();
        
        return lista;
    }
    
    @Override
    public ArticuloEntrada encuentraArtEnt(Integer idArt) {
        
        ArticuloEntrada p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM ArticuloEntrada ae join fetch ae.unidadDeMedida um join fetch ae.articulo a join fetch ae.departamento d where ae.idArticuloEntrada = "+idArt;
            p = (ArticuloEntrada) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    }
    
    @Override
    public Boolean eliminaArticuloEntrada(ArticuloEntrada artEnt) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        Boolean exito = false;
        try{
            session.delete(artEnt);
            transaction.commit();
            session.close();
            exito = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return exito; 
    }
    
}
