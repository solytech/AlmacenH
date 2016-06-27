/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class utileriasBean {
    
   String user;
    String pass;
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public utileriasBean (){
    }
    
    public void obtenerDatosDeAcceso() throws UnknownHostException{
        InetAddress ip;
        String hostname;
        

        ip = InetAddress.getLocalHost();
        hostname = ip.getHostName();
        System.out.println("la ip e: " + ip);
        System.out.println("el Hostname : " + hostname);
        
        if (hostname.equals("ALMACEN-PC")){
            url = "jdbc:mysql://localhost:3306/siswebho_almacen?zeroDateTimeBehavior=convertToNull";            
            user = "root";
            pass = "";
        }
        else{
            url = "jdbc:mysql://siswebhosting.com:3306/siswebho_almacen?zeroDateTimeBehavior=convertToNull";
            user = "externo";
            pass = "fuer@5";
        }
    } 
    
    
}
