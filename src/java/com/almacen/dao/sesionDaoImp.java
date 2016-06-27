/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Usuario;
import com.almacen.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


public class sesionDaoImp implements sesionDAO{

    private Session session;
    
    @Override
    public Usuario iniciarSesion(Usuario us) {
        
        Usuario usuario = null;
  
        try{
            
            session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "FROM Usuario u WHERE u.usuario = '"+us.getUsuario()+"' and u.passwd = '"+us.getPasswd()+"'";
            Query query = session.createQuery(hql);
            
            if(!query.list().isEmpty()){
                usuario = (Usuario) query.list().get(0);
            }
            
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null){
                session.close();
            }
        }
        return usuario;
    }
    
}
