/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar;

import com.almacen.dao.articuloentradaDAO;
import com.almacen.dao.articuloentradaDaoImp;
import com.almacen.model.Articulo;
import com.almacen.model.ArticuloEntrada;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("articuloConverter")
public class ArticuloConverte implements Converter{
    
    articuloentradaDAO artEntDao = new articuloentradaDaoImp();
    
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         //System.out.println("***************  Entra a getAsObjeto ***********");
         //System.out.println("***************  Entra a getAsObjeto--lo que tiene value-- "+ value );  
        if(value != null && value.trim().length() > 0) {
            try {
                System.out.println("***************  Entra a getAsObjeto-- entra al if ***********");
                //ThemeService service = (ThemeService) fc.getExternalContext().getApplicationMap().get("themeService");
                
                //Theme theme = null;
                //Integer v = Integer.valueOf(value);
                Integer v = Integer.parseInt(value) ;
                ArticuloEntrada art = artEntDao.encuentraArtEnt(v);
                //theme.setId(v);
                //System.out.println("***************  lo que tiene v -->>"+v);
                //System.out.println("***************  Entra a getAsObjeto-- lo que retorna--->>"+ service.getThemes().get(v));
                //System.out.println("***************  Entra a getAsObjeto-- lo que retorna--->>"+art.getArticulo());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idArtEntrada",v);
                //return service.getThemes().get(v);
                return art;
                //return service.getThemes().get(v);
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
    
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            //return String.valueOf(((Theme) object).getId());
            return String.valueOf(((ArticuloEntrada) object).getIdArticuloEntrada());
        }
        else {
            return null;
        }
    }
    
}
