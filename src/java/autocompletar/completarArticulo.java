/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar;

import com.almacen.dao.articuloDAO;
import com.almacen.dao.articuloDaoImp;
import com.almacen.dao.articuloentradaDAO;
import com.almacen.dao.articuloentradaDaoImp;
import com.almacen.model.Articulo;
import com.almacen.model.ArticuloEntrada;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class completarArticulo {
    
    articuloDAO artDao = new articuloDaoImp();
    articuloentradaDAO artEntDao =  new articuloentradaDaoImp(); 
    
    private Articulo idArticulo;
    private ArticuloEntrada idArtEnt;

    public ArticuloEntrada getIdArtEnt() {
        return idArtEnt;
    }

    public void setIdArtEnt(ArticuloEntrada idArtEnt) {
        this.idArtEnt = idArtEnt;
    }

    public Articulo getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.idArticulo = idArticulo;
    }
    
    
    
    
    public List<Articulo> completarTipo(String articulo){
       
        List<Articulo> art = artDao.buscarArticulo(articulo);
        
        return art;
        
    }
    
    public List<ArticuloEntrada> completarArtEnt(String artEntr){
        
        List<ArticuloEntrada> lisArt = artEntDao.buscarArtEnt(artEntr);
        
        return lisArt;
    }
    
    
}
