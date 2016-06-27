/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.utilerias;

import com.almacen.model.Acceso;
import com.almacen.model.Usuario;
import java.io.Serializable;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


public class Utilerias implements Serializable{
    
    public static Acceso datosAcceso(Usuario us) throws ParseException{ 
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("1970-01-01 00:00:00");
        
        Acceso acceso = new Acceso();
        acceso.setUsuario(us);
        acceso.setFechaEntra(fecha());
        acceso.setFechaSale(date);
        acceso.setIp(obtenerIP());
        
        return acceso;
    }
    
    
    public static Date fecha() {
        java.util.Date fecha = new Date();
        long lnMilisegundos = fecha.getTime();
        java.sql.Timestamp fechaCorrecta = new java.sql.Timestamp(lnMilisegundos);
        System.out.println(fechaCorrecta);
        return fechaCorrecta;
    }
    
    public static Date fechaEstatica() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse("1970-01-01 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public static String obtenerIP() {
        System.out.println("*********************************");
        System.out.println("Entra a ObtenerIP");
        System.out.println("*********************************");

        InetAddress thisIp = null;
        String remoteAddr = "";

        try {
            thisIp = InetAddress.getLocalHost();
            remoteAddr = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
            System.out.println("Otra IP:" + remoteAddr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("IP:" + thisIp.getHostAddress());
        //return remoteAddr;
        return thisIp.getHostAddress();
    }
    
    public static String conexionReporte(){
        return "jdbc:mysql://siswebhosting.com:3306/siswebho_almacen?zeroDateTimeBehavior=convertToNull";
    }
    
    public static String nombreArchivo(String nombreActual){
        
        String nuevoNombre = "";
        
        if (nombreActual.contains("imagen-1.jpg")){
            nuevoNombre = "imagen-2.jpg";
        }
        if (nombreActual.contains("imagen-2.jpg")){
            nuevoNombre = "imagen-3.jpg";
        }
        if (nombreActual.contains("imagen-3.jpg")){
            nuevoNombre = "imagen-4.jpg";
        }
        if (nombreActual.contains("imagen-4.jpg")){
           nuevoNombre = "imagen-5.jpg"; 
        }
        if (nombreActual.contains("imagen-5.jpg")){
           nuevoNombre = "imagen-6.jpg"; 
        }
        
        return nuevoNombre;
    }
    
}
