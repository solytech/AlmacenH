/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class BuscarArticulos {
    
    private StreamedContent graphicImage;
    //private String ruta = "C:\\images\\articulos\\0\\sinfoto.jpg"; 
    String path = null;
    public void prepararImagen(){
        //String path = "C:\\images\\articulos\\0\\imagen-1.jpg";
        path = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("rutaImagen");
        if(path == null){
            path = "C:\\images\\articulos\\0\\sinfoto.jpg";
        }
        //System.out.println("** lo que tiene path -->>"+path);
        try { 
            graphicImage = new DefaultStreamedContent(new FileInputStream(path), "image/png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BuscarArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StreamedContent getGraphicImage() {
        prepararImagen();
        return graphicImage;
    }

    public void setGraphicImage(StreamedContent graphicImage) {
        this.graphicImage = graphicImage;
    }

    
    
    

    
}
