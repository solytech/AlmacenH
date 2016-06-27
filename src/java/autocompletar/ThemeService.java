/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar;

import com.almacen.dao.articuloDAO;
import com.almacen.dao.articuloDaoImp;
import com.almacen.model.Articulo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="themeService", eager = true)
//@ApplicationScoped
@SessionScoped
public class ThemeService {
    articuloDAO articulos = new articuloDaoImp();
    private List<Theme> themes;
     
    @PostConstruct
    public void init() {
        themes = new ArrayList<Theme>();
        List<Articulo> art = articulos.listaArticulos();
        
        for(Articulo a : art ){
            Theme t = new Theme();
            t.setId(a.getIdArticulo());
            t.setDisplayName(a.getArticulo()); 
            t.setName(a.getCb());
            
            themes.add(t);
        }
        
        System.out.println("******* tamaño de la lista de articulos--->>"+art.size());     
    }
     
    public List<Theme> getThemes() {
        return themes;
    } 
}
