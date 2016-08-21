/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dao.articuloDAO;
import com.almacen.dao.articuloDaoImp;
import com.almacen.dao.marcaDAO;
import com.almacen.dao.marcaDaoImp;
import com.almacen.dao.subcatbienesDAO;
import com.almacen.dao.subcatbienesDaoImp;
import com.almacen.model.Acceso;
import com.almacen.model.Articulo;
import com.almacen.model.Marca;
import com.almacen.model.SubCatalogoBienes;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class ArticuloBean {
    
    articuloDAO articuloDao = new articuloDaoImp();
    subcatbienesDAO subcatbienesDao = new subcatbienesDaoImp();
    marcaDAO marcaDao = new marcaDaoImp();
    
    List<SelectItem> listaSubCatB;
    List<SelectItem> listaMarca;
    
    private Integer idSubCat;
    private Integer idMarca;
    private boolean esConsumible;
    
    private Articulo articulo;
    
    public ArticuloBean(){
        
        articulo = new Articulo();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rutaImagen",null);
    }

    public Integer getIdSubCat() {
        return idSubCat;
    }

    public void setIdSubCat(Integer idSubCat) {
        this.idSubCat = idSubCat;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public boolean isEsConsumible() {
        return esConsumible;
    }

    public void setEsConsumible(boolean esConsumible) {
        this.esConsumible = esConsumible;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public List<SelectItem> getListaSubCatB() {
        this.listaSubCatB = new ArrayList<>();
        List<SubCatalogoBienes> udm = subcatbienesDao.listaSubCatBienes();
        listaSubCatB.clear();
        for(SubCatalogoBienes u: udm){
            SelectItem provItem = new SelectItem(u.getIdSubCatalogoBienes(), u.getSubCatalogo());
            this.listaSubCatB.add(provItem);
        }
        return listaSubCatB;
    }

    public List<SelectItem> getListaMarca() {
        this.listaMarca = new ArrayList<>();
        List<Marca> udm = marcaDao.listaMarca();
        listaMarca.clear();
        for(Marca u: udm){
            SelectItem provItem = new SelectItem(u.getIdMarca(), u.getMarca());
            this.listaMarca.add(provItem);
        }
        return listaMarca;
    }
    
    public void guardarArticulo(){
        subcatbienesDAO sucatDao = new subcatbienesDaoImp();
        marcaDAO marcaDao = new marcaDaoImp();
        articuloDAO articuloDao = new articuloDaoImp();
        
        BigDecimal valor = new BigDecimal("0.0");
        Date fechaRelleno = new Date(1970-01-01); 
        try{
            FileUploadManagedBean idArt = null;
            Date fecha = new Date();
            Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
            SubCatalogoBienes ctb = sucatDao.encuentraSubCat(idSubCat);
            Marca m = marcaDao.encuentraUnProv(idMarca);
            articulo.setSubCatalogoBienes(ctb);
            articulo.setMarca(m);
            articulo.setAcceso(acc);
            articulo.setFechaReg(fecha);
            if(articulo.getFoto() == null){
                articulo.setFoto("/imagenes");
            }
            if(esConsumible == true){
                articulo.setEsConsumible("Y");
            }else{
                articulo.setEsConsumible("N");
            }
            if(articulo.getMinimo() == null ){
                articulo.setMinimo(valor);
            }
            if(articulo.getMaximo() == null ){
                articulo.setMaximo(valor);
            }
            if(articulo.getFechaCaducidad() == null){
                articulo.setFechaCaducidad(fechaRelleno);
            }
            articuloDao.guardaArticulo(articulo);
            //listaArticulos = articuloEJB.listaArticulos();
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idArticuloFoto", articulo.getIdArticulo());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Articulo Guardado Correctamente" ) );
            
            limpiaTextos();
            //System.out.println("******** lo que tiene idArt--->"+idArt.getIdArticulo());
        }catch(Exception e){
           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error al Guardar Articulo" ) );
        }
        
    }
    
    public void buscarArticulo(){
        String so = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("so"); 
        String win = "windows";
        Integer idArticulo = (Integer)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idArticulo");
        Articulo art = articuloDao.encuentraArticulo(idArticulo);
        
        articulo = art;
        idSubCat = art.getSubCatalogoBienes().getIdSubCatalogoBienes();
        idMarca  = art.getMarca().getIdMarca();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idArticuloFoto", art.getIdArticulo());
        if (so.contains(win)) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rutaImagen","C:/"+art.getFoto());
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rutaImagen","/"+art.getFoto());
        }
        
    }
    
    public void eliminaFoto(){
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rutaImagen", null);
        
    } 
    
    public void limpiaTextos(){
        
        listaSubCatB = null;
        listaMarca = null;

        idSubCat = null;
        idMarca = null;
        esConsumible = false;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rutaImagen",null);
        articulo = new Articulo() ;
    }
    
}
