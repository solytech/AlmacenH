/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.bean;

import com.almacen.dao.articuloDAO;
import com.almacen.dao.articuloDaoImp;
import com.almacen.dao.articuloentradaDaoImp;
import com.almacen.dao.departamentoDAO;
import com.almacen.dao.departamentoDaoImp;
import com.almacen.dao.facturaDaoImp;
import com.almacen.dao.formadepagoDAO;
import com.almacen.dao.formadepagoDaoImp;
import com.almacen.dao.proveedorDAO;
import com.almacen.dao.proveedorDaoImp;
import com.almacen.dao.tipoentradaDAO;
import com.almacen.dao.tipoentradaDaoImp;
import com.almacen.dao.unidadmedidaDAO;
import com.almacen.dao.unidadmedidaDaoImp;
import com.almacen.dto.listaArtEntDTO;
import com.almacen.model.Acceso;
import com.almacen.model.Articulo;
import com.almacen.model.ArticuloEntrada;
import com.almacen.model.Departamento;
import com.almacen.model.Factura;
import com.almacen.model.FormaDePago;
import com.almacen.model.Proveedor;
import com.almacen.model.TipoEntrada;
import com.almacen.model.UnidadDeMedida;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class EditaFactura {
    articuloentradaDaoImp artEntDao = new articuloentradaDaoImp();
    articuloDAO articuloDao = new articuloDaoImp();
    unidadmedidaDAO udmDao = new unidadmedidaDaoImp();
    facturaDaoImp facturaDAO = new facturaDaoImp();
    departamentoDaoImp departamentoDAO = new departamentoDaoImp();
    
    FacturaBean facturaBean = new FacturaBean();
    
    List<SelectItem> listaProv;
    List<SelectItem> listaDepto;
    List<SelectItem> listaFdp;
    List<SelectItem> listaTipoEntrada;
    List<SelectItem> listaDeptoAsignacion;
    List<SelectItem> listaUdm;
    
    private List<ArticuloEntrada> listaArtEnt;
    private List<listaArtEntDTO> listaArtEntDTO;
    
    Factura factura;
    ArticuloEntrada artEnt;
    ArticuloEntrada eliminaArt;
    listaArtEntDTO eliminaDTO;
    
    Integer idProv;
    Integer idDepto;
    Integer IdFdp;
    Integer IdTe;
    Integer idUdm;
    Integer idAsignacion;
    Integer elimina;
    
    private BigDecimal cantidad;
    private BigDecimal uxcaja;
    private BigDecimal uxpaquete;
    private BigDecimal piezas;
    private BigDecimal costoUnitario;
    
    private Boolean esResguardo = false;
    private Boolean txtCantidad = false;
    private Boolean txtCaja    = false;
    private Boolean txtPaquete = false;
    private Boolean txtPiezas  = false;
    private Boolean txtLitros  = false;
    private Boolean txtMts     = false;
    private Boolean distribuir;
    private Boolean activaCmbDis = false;
    
    
    
    public EditaFactura(){
        
        factura = new Factura();
        artEnt = new ArticuloEntrada();
        eliminaArt = new ArticuloEntrada();
        
    }

    public listaArtEntDTO getEliminaDTO() {
        System.out.println("*** id que recibe --->>"+eliminaDTO.getIdArtEnt());
        return eliminaDTO;
    }

    public void setEliminaDTO(listaArtEntDTO eliminaDTO) {
        this.eliminaDTO = eliminaDTO;
    }

    public Integer getElimina() {
        System.out.println("*** id que recibe --->>"+elimina);
        return elimina;
    }

    public void setElimina(Integer elimina) {
        this.elimina = elimina;
    }
    
    public ArticuloEntrada getEliminaArt() {
        System.out.println("*** lo que recibe --->>"+eliminaArt.getIdArticuloEntrada());
        return eliminaArt;
    }

    public void setEliminaArt(ArticuloEntrada eliminaArt) {
        System.out.println("*** lo que envia --->>"+eliminaArt.getIdArticuloEntrada());
        this.eliminaArt = eliminaArt;
    }

    public Boolean getDistribuir() {
        return distribuir;
    }

    public void setDistribuir(Boolean distribuir) {
        this.distribuir = distribuir;
    }

    public Boolean getActivaCmbDis() {
        return activaCmbDis;
    }

    public void setActivaCmbDis(Boolean activaCmbDis) {
        this.activaCmbDis = activaCmbDis;
    }

    public BigDecimal getUxpaquete() {
        return uxpaquete;
    }

    public void setUxpaquete(BigDecimal uxpaquete) {
        this.uxpaquete = uxpaquete;
    }

    public Boolean getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(Boolean txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public Boolean getTxtCaja() {
        return txtCaja;
    }

    public void setTxtCaja(Boolean txtCaja) {
        this.txtCaja = txtCaja;
    }

    public Boolean getTxtPaquete() {
        return txtPaquete;
    }

    public void setTxtPaquete(Boolean txtPaquete) {
        this.txtPaquete = txtPaquete;
    }

    public Boolean getTxtPiezas() {
        return txtPiezas;
    }

    public void setTxtPiezas(Boolean txtPiezas) {
        this.txtPiezas = txtPiezas;
    }

    public Boolean getTxtLitros() {
        return txtLitros;
    }

    public void setTxtLitros(Boolean txtLitros) {
        this.txtLitros = txtLitros;
    }

    public Boolean getTxtMts() {
        return txtMts;
    }

    public void setTxtMts(Boolean txtMts) {
        this.txtMts = txtMts;
    }

    public Boolean getEsResguardo() {
        return esResguardo;
    }

    public void setEsResguardo(Boolean esResguardo) {
        this.esResguardo = esResguardo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getUxcaja() {
        return uxcaja;
    }

    public void setUxcaja(BigDecimal uxcaja) {
        this.uxcaja = uxcaja;
    }

    public BigDecimal getPiezas() {
        return piezas;
    }

    public void setPiezas(BigDecimal piezas) {
        this.piezas = piezas;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Integer getIdUdm() {
        return idUdm;
    }

    public void setIdUdm(Integer idUdm) {
        this.idUdm = idUdm;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public List<listaArtEntDTO> getListaArtEntDTO() {
        return listaArtEntDTO;
    }

    public void setListaArtEntDTO(List<listaArtEntDTO> listaArtEntDTO) {
        this.listaArtEntDTO = listaArtEntDTO;
    }

    public List<ArticuloEntrada> getListaArtEnt() {
        return listaArtEnt;
    }

    public Integer getIdProv() {
        return idProv;
    }

    public void setIdProv(Integer idProv) {
        this.idProv = idProv;
    }

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }

    public Integer getIdFdp() {
        return IdFdp;
    }

    public void setIdFdp(Integer IdFdp) {
        this.IdFdp = IdFdp;
    }

    public Integer getIdTe() {
        return IdTe;
    }

    public void setIdTe(Integer IdTe) {
        this.IdTe = IdTe;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    public List<SelectItem> getListaProv() {   
        this.listaProv = new ArrayList<>();
        proveedorDAO pDao = new proveedorDaoImp();
        List<Proveedor> prv = pDao.listaProveedores();
        listaProv.clear();
        for(Proveedor p: prv){
            SelectItem provItem = new SelectItem(p.getIdProveedor(), p.getRfc(), p.getProveedor());
            this.listaProv.add(provItem);
        }
        
        return listaProv;
    }
    
    public List<SelectItem> getListaDepto() {
        this.listaDepto  = new ArrayList<>();
        departamentoDAO pDao = new departamentoDaoImp();
        List<Departamento> prv = pDao.listaDepto();
        listaDepto.clear();
        for(Departamento p: prv){
            SelectItem provItem = new SelectItem(p.getIdDepartamento(), p.getDepartamento());
            this.listaDepto.add(provItem);
        }
        return listaDepto;
    }

    public List<SelectItem> getListaFdp() {
        this.listaFdp = new ArrayList<>();
        formadepagoDAO fDao = new formadepagoDaoImp();
        List<FormaDePago> fdp = fDao.listaFdp();
        listaFdp.clear();
        for(FormaDePago f: fdp){
            SelectItem provItem = new SelectItem(f.getIdFormaDePago(), f.getFormaDePago());
            this.listaFdp.add(provItem);
        }
        
        return listaFdp;
    }

    public List<SelectItem> getListaTipoEntrada() {
        this.listaTipoEntrada = new ArrayList<>();
        tipoentradaDAO fDao = new tipoentradaDaoImp();
        List<TipoEntrada> fdp = fDao.listaTipoEntrada();
        listaTipoEntrada.clear();
        for(TipoEntrada f: fdp){
            SelectItem provItem = new SelectItem(f.getIdTipoEntrada(), f.getTipoEntrada());
            this.listaTipoEntrada.add(provItem);
        }
        
        return listaTipoEntrada;
    }
    
    public List<SelectItem> getListaDeptoAsignacion() {
        this.listaDeptoAsignacion = new ArrayList<>();
        departamentoDAO paDao = new departamentoDaoImp();
        List<Departamento> prv = paDao.listaDepto();
        
        for(Departamento p: prv){
            SelectItem provItem = new SelectItem(p.getIdDepartamento(), p.getDepartamento());
            this.listaDeptoAsignacion.add(provItem);
        }
        
        return listaDeptoAsignacion;
    }
    
    public List<SelectItem> getListaUdm() {
        this.listaUdm = new ArrayList<>();
        unidadmedidaDAO udmD = new unidadmedidaDaoImp();
        List<UnidadDeMedida> udm = udmD.listaUnidadMedida();
        listaUdm.clear();
        for(UnidadDeMedida u: udm){
            SelectItem provItem = new SelectItem(u.getIdUnidadDeMedida(), u.getUnidadDeMedida());
            this.listaUdm.add(provItem);
        }
        
        return listaUdm;
    }
    
    
    public void editaFactura(Factura seleccionFact){
        this.factura = seleccionFact;
        System.out.println("*** Folio factura seleccionado --->>"+factura.getFolioFactura());
        idProv = factura.getProveedor().getIdProveedor();
        idDepto = factura.getDepartamento().getIdDepartamento();
        IdFdp = factura.getFormaDePago().getIdFormaDePago();
        IdTe = factura.getTipoEntrada().getIdTipoEntrada();
        //facturaBean.listaDeEntradas(factura);
        //listaArtEnt = artEntDao.listaArtEnt(factura.getIdFactura());
        listaArtEntDTO = artEntDao.listaArtEntDTO(factura.getIdFactura());
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("esEditar", true);
        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("idEdita", factura);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("factura", factura);
      
    } 
    
    
    public void editaArticulo(){
        try{
            BigDecimal valorE = new BigDecimal("0.0");
            BigDecimal cantiE = new BigDecimal("0.0");
            BigDecimal uxcE = new BigDecimal("0.0");
            BigDecimal uxpE = new BigDecimal("0.0");
            BigDecimal pzsE = new BigDecimal("0.0");
            BigDecimal totalPzsE = new BigDecimal("0.0");
            BigDecimal cuE  = new BigDecimal("0.0");
            BigDecimal ccE  = new BigDecimal("0.0");
            BigDecimal cpE  = new BigDecimal("0.0");
            BigDecimal cpzE = new BigDecimal("0.0");
            BigDecimal ctE  = new BigDecimal("0.0");
            Double cuniE=0.0, ctdadE=0.0 , ctotalE=0.0, totalpE=0.0, cpiezaE=0.0;
            DecimalFormat df = new DecimalFormat("#.##");
            
            ArticuloEntrada ae = new ArticuloEntrada();
            Departamento dep = new Departamento();
            
            Date fecha = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("ddMMyyyy");
            Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
            Integer idArt = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("idArticulo");
            Factura facAct = (Factura) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("factura");
            Factura fac = facturaDAO.encuentraUnaFac(facAct.getIdFactura());
            Articulo art =  articuloDao.encuentraArticulo(idArt);
            UnidadDeMedida um = udmDao.encuentraUdeMedida(idUdm);
            
            System.out.println("*********************************");
            System.out.println("Lo que tiene getFactura----------->>" + factura.getIdFactura());
            System.out.println("Lo que tiene faces Factura-------->>" + fac.getIdFactura());
            //System.out.println("Lo que tiene theme----------->>" + theme1.getDisplayName()+" / "+theme1.getId());
            System.out.println("Lo que tiene art----------->>" + art.getArticulo()+" / "+art.getIdArticulo()); 
            System.out.println("Lo que tiene idArt----------->>" + idArt);
            System.out.println("*********************************");
            //******************************************************************
            if(idUdm == 1){
                //System.out.println("****** entra a cajas *******");
                cantiE = cantidad;uxcE = uxcaja;uxpE = uxpaquete; cuE = costoUnitario; ccE = costoUnitario;
                
                if(uxcE.compareTo(new BigDecimal("0.0")) == 1 ){
                    //System.out.println("****** entra al if *******");
                    pzsE = cantiE.multiply(uxcE);
                    if(uxpE.compareTo(new BigDecimal("0.0")) == 1 ){
                        totalPzsE = uxpE.multiply(pzsE);
                    }
                }else{
                    if(pzsE.compareTo(new BigDecimal("0.0")) == 1 ){  
                        totalPzsE = cantiE.multiply(uxpE);   
                    }
                }
                //sacamos costo por pieza
                //ct = cu.multiply(canti);
                //cpz = ct.divide(totalPzs);
                
                System.out.println("*************operaciones**********************");
                System.out.println("**** lo que tiene canti----------->>"+cantiE);
                System.out.println("**** lo que tiene cajas----------->>"+uxcE);
                System.out.println("**** lo que tiene paquetes-------->>"+uxpE);
                System.out.println("**** lo que tiene piezas---------->>"+pzsE);
                System.out.println("**** total de piezas a ingresar--->>"+totalPzsE);
                
                
            }
            
            if(idUdm == 2){
                System.out.println("****** entra a paquetes ******");
                cantiE = cantidad; uxpE = uxpaquete; cuE = costoUnitario; cpE = costoUnitario;
                
                
                    if(uxpE.compareTo(new BigDecimal("0.0"))  == 1 ){
                        totalPzsE = cantiE.multiply(uxpE);
                    }else{
                        totalPzsE = cantiE;
                    }
                
                System.out.println("*************operaciones**********************");
                System.out.println("**** lo que tiene canti----------->>"+cantiE);
                System.out.println("**** lo que tiene paquetes-------->>"+uxpE);
                System.out.println("**** total de piezas a ingresar--->>"+totalPzsE);
                
                
                
            }
            
            if(idUdm == 3){
                cantiE = cantidad ;cuE = costoUnitario;
                
                totalPzsE = cantiE;
                    
                System.out.println("*************operaciones**********************");
                System.out.println("**** lo que tiene cantidad----------->>"+cantidad);  
                System.out.println("**** lo que tiene costo unitario----------->>"+costoUnitario);
                System.out.println("**** lo que tiene canti----------->>"+cantiE);
                System.out.println("**** lo que tiene piezas---------->>"+pzsE);
                System.out.println("**** total de piezas a ingresar--->>"+totalPzsE);
                
               
                
            }
             
                    
            System.out.println("************* entra a operaciones matematicas *****************");
            //System.out.println("*** lo que tiene cu -->>"+df.format(cuni));
            //System.out.println("*** lo que tiene canti -->>"+df.format(ctdad));
            cuniE= cuE.doubleValue();
            ctdadE = cantiE.doubleValue();
            ctotalE = cuniE * ctdadE;
            //ct = cu.multiply(canti);
            //System.out.println("*** lo que tiene ct--->>"+df.format(ctotal));
            //System.out.println("*** lo que tiene totalPzs -->>"+totalPzs);
            totalpE = totalPzsE.doubleValue();
            cpiezaE = ctotalE / totalpE;
            //cpz = ct.divide(totalPzs);
            //cpz = cpz.setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println("*** lo que tiene totalPzs -->>"+totalpE);
            System.out.println("*** lo que tiene cpz -->"+df.format(cpiezaE));
            System.out.println("************* pasa operaciones matematicas**********************");
            
            if( idAsignacion == null || idAsignacion == 0){
                //System.out.println("**** entra al if de departamento *****");
                dep = departamentoDAO.encuentraUnDepto(fac.getDepartamento().getIdDepartamento());
            }else{
                //System.out.println("**** entra al else de departamento *****");
                dep = departamentoDAO.encuentraUnDepto(idAsignacion);
            }
            
            
            //depto = departamentoDAO.encuentraUnDepto(fac.getDepartamento().getIdDepartamento());
            artEnt.setCantidad(new BigDecimal( ctdadE ));
            artEnt.setUnidadesPorCaja(uxcE);
            artEnt.setUnidadesPorPaquete(uxpE); 
            artEnt.setPiezas(totalPzsE);
            artEnt.setCostoUnitario(cuE);
            artEnt.setCostoCaja(ccE);
            artEnt.setCostoPaquete(cpE);
            artEnt.setCostoPieza(new BigDecimal( cpiezaE ));
            if(esResguardo){
                artEnt.setEsResguardo("Y");
            }else{
                artEnt.setEsResguardo("N");
            }
            
            artEnt.setNumeroDeSerie(art.getCb());
            //artEnt.setObservaciones("qaz");
            artEnt.setCbInterno("1-1-07062016");
            
            artEnt.setDepartamento(dep);
            artEnt.setFactura(fac);
            artEnt.setArticulo(art);
            artEnt.setUnidadDeMedida(um);
            artEnt.setFechaReg(fecha);
            artEnt.setAcceso(acc);  
            
            
            artEntDao.guardaArticuloEntrada(artEnt); 
            
            ae = artEntDao.ultimoAgregado(fac.getIdFactura());
            //System.out.println("*** id articuloEntrada que regresa --->>"+ae.getIdArticuloEntrada());
            String idArticuloEntrada = ae.getIdArticuloEntrada().toString();
            ae.setCbInterno("");
            ae.setCbInterno(idArticuloEntrada + "-" + fac.getProveedor().getIdProveedor()+ "-" + formateador.format(fecha));
            artEntDao.actualizarArticuloEntrada(ae);
            //System.out.println("*************lista de articulo **********************");
            //listaArtEnt = artEntDao.listaArtEnt(fac.getIdFactura());
            listaArtEntDTO = artEntDao.listaArtEntDTO(fac.getIdFactura());
            //System.out.println("*************total de articulos traidos--->>"+listaArtEnt.size());
            //for(ArticulosEntDTO a: lista){
            //    System.out.println("articulos de lalista --->>"+a.getArticulo().getArticulo());
            //}
            //System.out.println("*************total de articulos traidos--->>"+lista.size());
            //listaArtEnt = artentEJB.listaArtEntrada(fac.getIdFactura());
             limpiaTxt();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Articulo Agregado" ) );
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Articulo No Agregado" ) );
        }      
      
    }
    
    public void eliminaArticulo(){
        System.out.println("****** entra a funcion eliminar *********");
        //listaArtEntDTO = artEntDao.listaArtEntDTO(factura.getIdFactura());
        System.out.println("****** tamaño de la lista --->>"+listaArtEntDTO.size());
        try{
            for (listaArtEntDTO ae : listaArtEntDTO) {
                System.out.println("****** entra al for --->>"+ae.getSeleccionado());
                if (ae.getSeleccionado()) {
                    System.out.println("****** entra al if *********");
                    artEntDao.eliminaArticuloEntrada(ae.getArtEnt());
                }
            }
            listaArtEntDTO = artEntDao.listaArtEntDTO(factura.getIdFactura());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Articulos Eliminados" ) );
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Articulos No Eliminados" ) );
        }
    }
    
    public void eliminaArtEntrada(listaArtEntDTO artEnt){
        
        System.out.println("*** objeto que recibe -->>"+artEnt.getArtEnt().getCbInterno());
        
    }
        
    
    
    public void habilitarTxt(){
        if(idUdm == 1){
            uxcaja = null;
            uxpaquete = null;
            cantidad = null;
            txtCantidad = false;
            txtCaja = false;
            txtPaquete = false;
            txtLitros = false;
            txtMts = false;
        }
        if(idUdm == 2){
            txtCantidad = false;
            txtCaja = true;
            txtPaquete = false;
            txtLitros = false;
            txtMts = false;
            uxcaja = null;
            uxpaquete = null;
            cantidad = null;
            costoUnitario = null;
        }
        if(idUdm == 3){
            txtCaja = true;
            txtPaquete = true;
            txtCantidad = false;
            txtLitros = false;
            txtMts = false;
            uxcaja = null;
            uxpaquete = null;
            cantidad = null;
            costoUnitario = null;
        }
        if(idUdm == 4){
            txtCaja = false;
            txtPaquete = false;
            txtPiezas = false;
            txtLitros = true;
            txtMts = false;
        }
        if(idUdm == 5){
            txtCaja = false;
            txtPaquete = false;
            txtPiezas = false;
            txtLitros = false;   
            txtMts = true;
        }
        
    }
    
    public void habilitarCmbAsignacion(){
        
        if(distribuir){
            activaCmbDis = true;
        }else{
            activaCmbDis = false;
            listaDeptoAsignacion = null;
            idAsignacion = null;
        }
        
    }
    
    public void limpiaTxt(){
        uxcaja = null;
        uxpaquete = null;
        cantidad = null;
        costoUnitario = null;
        txtCantidad = false;
        txtCaja = false;
        txtPaquete = false;
        txtLitros = false;
        txtMts = false;
        artEnt = new ArticuloEntrada() ;
        listaUdm = null;
        idUdm =null;
        idAsignacion = null;
        
    }
    
}
