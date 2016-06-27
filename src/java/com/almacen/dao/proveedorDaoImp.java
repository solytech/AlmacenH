/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Proveedor;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class proveedorDaoImp implements proveedorDAO {

    @Override
    public List<Proveedor> listaProveedores() {
        List<Proveedor> listarProveedores = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Proveedor p";
            listarProveedores = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return listarProveedores;

    }
    
    
    @Override
    public Proveedor encuentraUnProv(Integer idProv){
        Proveedor p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Proveedor d where d.idProveedor = "+idProv;
            p = (Proveedor) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    } 
    
    
    @Override
    public Proveedor guardaProveedor(Proveedor prov) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
             
            if(prov.getIdProveedor() == null ||  prov.getIdProveedor() == 0 ){
                session.save(prov);
                transaction.commit();
                session.close();
                
            }else{
                session.update(prov);
                transaction.commit();
                session.close();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return prov; 
    }
    
    @Override
    public void eliminarProveedor(Proveedor prov) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{            
            session.delete(prov);
            transaction.commit();
            session.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
}
