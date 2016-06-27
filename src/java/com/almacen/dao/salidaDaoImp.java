/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Salida;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class salidaDaoImp implements salidaDAO{

    @Override
    public boolean guardaSalida(Salida salida) {
        boolean correcto = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        try{
            session.save(salida);
            transaction.commit();
            session.close();
                
           
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
            correcto = false;
        }
        return correcto; 
        
    }
    
    @Override
    public Salida ultimaSalidaAgregada(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        List<Salida> lista = null;
        Salida salida = new Salida();
        try {
            
            String hql = "FROM Salida ae order by ae.idSalida desc";
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            salida = lista.get(0);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return salida;
    }
    
}
