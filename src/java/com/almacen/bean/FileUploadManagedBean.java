/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;
import com.almacen.dao.articuloDAO;
import com.almacen.dao.articuloDaoImp;
import com.almacen.dao.facturaDAO;
import com.almacen.dao.facturaDaoImp;
import com.almacen.model.Articulo;
import com.almacen.model.Factura;
import com.almacen.utilerias.Utilerias;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

@ManagedBean(name = "FileUploadManagedBean")
public class FileUploadManagedBean {
    Integer idArticulo = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idArticuloFoto");
    Factura fac = (Factura) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("factura");
    String so = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("so"); 
    String win = "windows";
    File directorio;
    articuloDAO art = new articuloDaoImp();
    facturaDAO factura = new facturaDaoImp();
    private String destination;  

    public void upload(FileUploadEvent event) {     
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream(), 2);
            FacesMessage message = new FacesMessage("El archivo se ha subido con Exito!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void uploadFactura(FileUploadEvent event) {     
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream(), 1);
            FacesMessage message = new FacesMessage("El archivo se ha subido con Exito!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void copyFile(String fileName, InputStream in, Integer idIdentifica) {
        try {
            if(idIdentifica == 1){
                String ruta = fac.getFoto();
                //System.out.println("******  ifFactura --->>"+fac.getIdFactura());
                //System.out.println("******  ruta que tiene --->>"+fac.getFoto());
                if(ruta.contains(fac.getIdFactura().toString())){
                    //System.out.println("******  entra al if de no crear directorio *****");
                    //no se crea directorio
                    if (so.contains(win)) {
                        destination = "C:\\images\\facturas\\" + fac.getIdFactura().toString() + "\\";
                    } else {
                        destination = "\\images\\facturas\\" + fac.getIdFactura().toString() + "\\";
                    }
                    //System.out.println("******  lo que tiene destination-->>"+destination);
                    OutputStream out = new FileOutputStream(new File(destination + fileName));
                    int read = 0;
                    byte[] bytes = new byte[1024];
                    while ((read = in.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                    in.close();
                    out.flush();
                    out.close();
                    System.out.println("El archivo se ha creado con Exito!");
                    
                    String ruta1 = destination + fileName;
                    String ruta2 = destination + Utilerias.nombreArchivo(fac.getFoto());
                    System.out.println("Archivo: " + ruta1 + " Renombrado a: " + ruta2);
                    File archivo = new File(ruta1);
                    archivo.renameTo(new File(ruta2));
                    //agregamos la ruta en el objeto factura
                    
                    String nuevaCadena = fac.getFoto()+" ,"+ Utilerias.nombreArchivo(fac.getFoto());
                    fac.setFoto(nuevaCadena);
                    factura.actualizaFactura(fac);
                }else{
                    //se crea directorio
                     System.out.println("******  entra al else se crea directorio *****");
                    if (so.contains(win)) {
                        destination = "C:\\images\\facturas\\" + fac.getIdFactura().toString() + "\\";
                        directorio = new File("C:\\images\\facturas\\" + fac.getIdFactura().toString());
                    } else {
                        destination = "\\images\\facturas\\" + fac.getIdFactura().toString() + "\\";
                        directorio = new File("\\images\\facturas\\" + fac.getIdFactura().toString());
                    }
                    
                    directorio.mkdir();
                    OutputStream out = new FileOutputStream(new File(destination + fileName));
                    int read = 0;
                    byte[] bytes = new byte[1024];
                    while ((read = in.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                    in.close();
                    out.flush();
                    out.close();
                    //System.out.println("El archivo se ha creado con Exito!");
                    String ruta1 = destination + fileName;
                    String ruta2 = destination + "imagen-1.jpg";
                    //System.out.println("Archivo: " + ruta1 + " Renombrado a: " + ruta2);
                    File archivo = new File(ruta1);
                    archivo.renameTo(new File(ruta2));  
                    //agregamos la ruta en el objeto factura
                    
                    fac.setFoto("images/facturas/"+ fac.getIdFactura() + "/imagen-1.jpg");
                    factura.actualizaFactura(fac);
                    
                }
                
            }
            if(idIdentifica == 2){
                Articulo articulo = art.encuentraArticulo(idArticulo);
                System.out.println("******* lo que tiene foto -->>"+articulo.getFoto());
                String rutaArt = articulo.getFoto();
                System.out.println("******* lo que tiene rutaArt -->>"+rutaArt);
                if(rutaArt.contains(articulo.getIdArticulo().toString())){
                    //no se crea directorio
                    if (so.contains(win)) {
                        destination = "C:\\images\\articulos\\" + idArticulo.toString() + "\\";
                        directorio = new File("C:\\images\\articulos\\" + idArticulo.toString());
                    } else {
                        destination = "\\images\\articulos\\" + idArticulo.toString() + "\\";
                        directorio = new File("\\images\\articulos\\" + idArticulo.toString());
                    }
                    //eliminamos archivo anterior
                    File elimina = new File("C:/images/articulos/"+idArticulo.toString()+"/imagen-1.jpg");
                    if(elimina.delete()){
                        System.out.println("***** archivo se elimino ****");
                    }else{
                        System.out.println("***** archivo NO se elimino ****");
                    }
                        
                    //
                    directorio.mkdir();
                    OutputStream out = new FileOutputStream(new File(destination + fileName));
                    int read = 0;
                    byte[] bytes = new byte[1024];
                    while ((read = in.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                    in.close();
                    out.flush();
                    out.close();
                    //System.out.println("El archivo se ha creado con Exito!");
                    
                    String ruta1 = destination + fileName;
                    String ruta2 = destination + "imagen-1.jpg";
                    //System.out.println("Archivo: " + ruta1 + " Renombrado a: " + ruta2);
                    File archivo = new File(ruta1);
                    archivo.renameTo(new File(ruta2));
                    
                    if (so.contains(win)) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rutaImagen", "C:/" + articulo.getFoto());
                    } else {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rutaImagen", "/" + articulo.getFoto());
                    }
                }else{
                    // se crea directorio
                    if (so.contains(win)) {
                        destination = "C:\\images\\articulos\\" + idArticulo.toString() + "\\";
                        directorio = new File("C:\\images\\articulos\\" + idArticulo.toString());
                    } else {
                        destination = "\\images\\articulos\\" + idArticulo.toString() + "\\";
                        directorio = new File("\\images\\articulos\\" + idArticulo.toString());
                    }

                    directorio.mkdir();
                    OutputStream out = new FileOutputStream(new File(destination + fileName));
                    int read = 0;
                    byte[] bytes = new byte[1024];
                    while ((read = in.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                    in.close();
                    out.flush();
                    out.close();
                    //System.out.println("El archivo se ha creado con Exito!");

                    String ruta1 = destination + fileName;
                    String ruta2 = destination + "imagen-1.jpg";
                    //System.out.println("Archivo: " + ruta1 + " Renombrado a: " + ruta2);
                    File archivo = new File(ruta1);
                    archivo.renameTo(new File(ruta2));
                    //agregamos la ruta en el objeto articulo
                    Articulo a = art.encuentraArticulo(idArticulo);
                    a.setFoto("images/articulos/" + idArticulo.toString() + "/imagen-1.jpg");
                    art.guardaArticulo(a);
                    
                    if (so.contains(win)) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rutaImagen", "C:/" + a.getFoto());
                    } else {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rutaImagen", "/" + a.getFoto());
                    }
                }
               
            }
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}

