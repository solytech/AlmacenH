/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.model.Factura;
import com.almacen.utilerias.Utilerias;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean
@RequestScoped
public class ArticulosExportBean {
    utileriasBean utiles = new utileriasBean();
    
    public void generarEtiquetaPorFactura(ActionEvent actionEvent) throws JRException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        System.out.println("******* entra a la funcion del reporte ******");
        
        Factura facAct = (Factura) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("factura");
        String nombre = "Etiquetas_Factura_"+facAct.getFolioFactura();
        
        Connection conexion;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        
        utiles.obtenerDatosDeAcceso();
        //System.out.println(" **** host: "+ utiles.getUrl() +"     usuario: "+ utiles.getUser() +"   pass: "+ utiles.getPass());
        
        conexion = DriverManager.getConnection(utiles.getUrl(), utiles.getUser(), utiles.getPass());
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("idFactura", facAct.getIdFactura());  
        
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/REPORTES/BarrasCodigo.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, conexion);
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename="+nombre+".pdf");
        ServletOutputStream stream = response.getOutputStream();
        
        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
        
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
        
        System.out.println("******* sale de la funcion del reporte ******");  
    }
    
    
    public void generarValeEntrada(ActionEvent actionEvent) throws JRException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
        System.out.println("******* entra a la funcion del reporte ******");
        
        Factura facAct = (Factura) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("factura");
        String nombre = "Vale_Entrada_"+facAct.getFolioFactura();
        
        Connection conexion;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conexion = DriverManager.getConnection(Utilerias.conexionReporte());
        
        Map<String, Object> parametros = new HashMap<String, Object>(); 
        parametros.put("id_Entrada22", facAct.getIdFactura()); 
        
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/REPORTES/reporteEntrada.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, conexion);
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename="+nombre+".pdf");
        ServletOutputStream stream = response.getOutputStream();
        
        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
        
        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
        
        System.out.println("******* sale de la funcion del reporte ******");  
    }
    
}
