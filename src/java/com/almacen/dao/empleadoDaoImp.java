/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dao;

import com.almacen.model.Empleado;
import com.almacen.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class empleadoDaoImp implements empleadoDAO{

    @Override
    public Empleado guardaEmpleado(Empleado empleado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction = session.beginTransaction();
        
        try{
            session.save(empleado);
            transaction.commit();
            session.close();
            
        } catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return empleado; 
    }
    
    @Override
    public List<Empleado> listaEmpleados() {
        List<Empleado> listarEmpleado = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Empleado e";
            listarEmpleado = session.createQuery(hql).list();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return listarEmpleado;

    }
    
    @Override
    public Empleado encuentraEmpleado(Integer idEmpleado) {
        
        Empleado p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
            String hql = "FROM Empleado d where d.idEmpleado = "+idEmpleado;
            p = (Empleado) session.createQuery(hql).uniqueResult();
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } 
        
        return p;
        
    }
    
}
