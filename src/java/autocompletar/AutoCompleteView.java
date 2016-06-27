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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class AutoCompleteView {
    
    articuloDAO articulos = new articuloDaoImp();
    
    private Theme theme1;
    private List<Theme> selectedThemes;
    private List<Theme> allThemes;
    
    //@ManagedProperty("#{themeService}")
    private ThemeService service;
    
    

    public List<Theme> getAllThemes() {
        return allThemes;
    }
    
    public Theme getTheme1() {
        System.out.println("*************************entra al getTheme1");
        return theme1;
        
    }

    public void setTheme1(Theme theme1) {
        System.out.println("*************************entra al setTheme1");
        this.theme1 = theme1;
    }
    
     public List<Theme> getSelectedThemes() {
        return selectedThemes;
    }
 
    public void setSelectedThemes(List<Theme> selectedThemes) {
        this.selectedThemes = selectedThemes;
    }
     
    public void setService(ThemeService service) {
        this.service = service;
    }
 
    public char getThemeGroup(Theme theme) {
        return theme.getDisplayName().charAt(0);
    }
    
    public AutoCompleteView(){
        theme1 = null;
    }
    
    public List<Theme> completeTheme(String query) {
        //List<Theme> allThemes = service.getThemes();
        //allThemes = service.getThemes();
        listarArticulos();
        List<Theme> filteredThemes = new ArrayList<Theme>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Theme skin = allThemes.get(i);
            if(skin.getDisplayName().toLowerCase().startsWith(query) || skin.getName().toLowerCase().startsWith(query) ) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
     
    public void onItemSelect(SelectEvent event) {
        System.out.println("*************************entra al onItemSelect");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }
    
    public void listarArticulos(){
        //themes = new ArrayList<Theme>();
        List<Articulo> art = articulos.listaArticulos();
        
        for(Articulo a : art ){
            Theme t = new Theme();
            t.setId(a.getIdArticulo());
            t.setDisplayName(a.getArticulo()); 
            t.setName(a.getCb());
            
            allThemes.add(t);
        }
        System.out.println("******* tamaño de la lista de articulos--->>"+art.size()); 
        //allThemes = service.getThemes();  
    }
}
