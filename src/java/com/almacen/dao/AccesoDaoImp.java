/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Acceso;
import com.almacen.model.Usuario;
import com.almacen.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author yo_cuecuecha
 */
public class AccesoDaoImp implements AccesoDAO{
    
    private Session session;

    @Override
    public Acceso registraAcceso(Acceso acc) {
       
       try{
           session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           
            if(acc.getIdAcceso() == null){
                
                session.save(acc);
                session.getTransaction().commit();

           }else{
                
                session.update(acc);
                session.getTransaction().commit();
                
            }   
       }catch(Exception e){
           System.out.println(e.getMessage());
           session.getTransaction().rollback(); 
       }finally{
           if (session != null){
                session.close();
            }
       }
        
        return acc;
    }
    
    
}
