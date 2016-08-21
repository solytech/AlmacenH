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
import com.almacen.dao.salidaarticuloDAO;
import com.almacen.dao.salidaarticuloDaoImp;
import com.almacen.dao.tipoentradaDAO;
import com.almacen.dao.tipoentradaDaoImp;
import com.almacen.dao.unidadmedidaDAO;
import com.almacen.dao.unidadmedidaDaoImp;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


@ManagedBean
@ViewScoped
public class FacturaBean {
    
    facturaDaoImp facturaDAO = new facturaDaoImp();
    proveedorDaoImp proveedorDAO = new proveedorDaoImp();
    departamentoDaoImp departamentoDAO = new departamentoDaoImp();
    formadepagoDaoImp formadepagoDAO = new formadepagoDaoImp();
    tipoentradaDaoImp tipoentradaDAO = new tipoentradaDaoImp();
    articuloDAO articuloDao = new articuloDaoImp();
    unidadmedidaDAO udmDao = new unidadmedidaDaoImp();
    articuloentradaDaoImp artEntDao = new articuloentradaDaoImp();
    salidaarticuloDAO salArtDao = new salidaarticuloDaoImp();
    
    List<SelectItem> listaProv;
    List<SelectItem> listaDepto;
    List<SelectItem> listaFdp;
    List<SelectItem> listaTipoEntrada;
    List<SelectItem> listaUdm;
    List<SelectItem> listaDeptoAsignacion;
    
    Factura factura;
    ArticuloEntrada artEnt;
    private ArticuloEntrada eliminaArt;
    private Factura eliminaFac;
    
    private List<ArticuloEntrada> listaArtEnt;
    private List<Factura> listaFacturas;
    
    Integer idProv;
    Integer idDepto;
    Integer IdFdp;
    Integer IdTe;
    
    Integer idFactura;
    Integer idUdm;
    Integer idAsignacion;
    private BigDecimal cantidad;
    private BigDecimal uxcaja;
    private BigDecimal uxpaquete;
    private BigDecimal piezas;
    private BigDecimal costoUnitario;
    
    
    private Boolean txtCantidad = false;
    private Boolean txtCaja    = false;
    private Boolean txtPaquete = false;
    private Boolean txtPiezas  = false;
    private Boolean txtLitros  = false;
    private Boolean txtMts     = false;
    private Boolean activaFrmArt = false;
    private Boolean distribuir;
    private Boolean activaCmbDis = false;
    private Boolean esResguardo = false;

    
    //constructor
    public FacturaBean(){
        
        factura = new Factura();
        artEnt = new ArticuloEntrada();
        
        
    }
    
    // geters y seters*************************+

    public Factura getEliminaFac() {
        return eliminaFac;
    }

    public void setEliminaFac(Factura eliminaFac) {
        this.eliminaFac = eliminaFac;
    }

    public ArticuloEntrada getEliminaArt() {
        return eliminaArt;
    }

    public void setEliminaArt(ArticuloEntrada eliminaArt) {
        this.eliminaArt = eliminaArt;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Boolean getEsResguardo() {
        return esResguardo;
    }

    public void setEsResguardo(Boolean esResguardo) {
        this.esResguardo = esResguardo;
    } 

    public Boolean getActivaCmbDis() {
        return activaCmbDis;
    }

    public void setActivaCmbDis(Boolean activaCmbDis) {
        this.activaCmbDis = activaCmbDis;
    }

    public Boolean getDistribuir() {
        return distribuir;
    }

    public void setDistribuir(Boolean distribuir) {
        this.distribuir = distribuir;
    }

    public List<ArticuloEntrada> getListaArtEnt() {
        return listaArtEnt;
    }

    public Boolean getActivaFrmArt() {
        return activaFrmArt;
    }

    public void setActivaFrmArt(Boolean activaFrmArt) {
        this.activaFrmArt = activaFrmArt;
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

    public BigDecimal getUxpaquete() {
        return uxpaquete;
    }

    public void setUxpaquete(BigDecimal uxpaquete) {
        this.uxpaquete = uxpaquete;
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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public ArticuloEntrada getArtEnt() {
        return artEnt;
    }

    public void setArtEnt(ArticuloEntrada artEnt) {
        this.artEnt = artEnt;
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
    
    public Boolean getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(Boolean txtCantidad) {
        this.txtCantidad = txtCantidad;
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

    public List<SelectItem> getListaDeptoAsignacion() {
        this.listaDeptoAsignacion = new ArrayList<>();
        departamentoDAO paDao = new departamentoDaoImp();
        List<Departamento> prv = paDao.listaDepto();
        listaDepto.clear();
        for(Departamento p: prv){
            SelectItem provItem = new SelectItem(p.getIdDepartamento(), p.getDepartamento());
            this.listaDeptoAsignacion.add(provItem);
        }
        
        return listaDeptoAsignacion;
    }
    
    public List<Factura> getListaFacturas() {
        
        this.listaFacturas = new ArrayList<>();
        
        listaFacturas = facturaDAO.listaFacturas();
        
        return listaFacturas;
    }
    
   
    
    //************************************************
    
    
    public void guardarFactura(){
        try{
            
            Date fecha = new Date();
            Acceso acc = (Acceso) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("acceso");
            
            Proveedor p = proveedorDAO.encuentraUnProv(idProv);
            Departamento d = departamentoDAO.encuentraUnDepto(idDepto);
            FormaDePago fp = formadepagoDAO.encuentraUnFdp(IdFdp);
            TipoEntrada te = tipoentradaDAO.encuentraUnTe(IdTe);
            
            factura.setProveedor(p);
            factura.setDepartamento(d);
            factura.setFormaDePago(fp);
            factura.setTipoEntrada(te);
            factura.setAcceso(acc);
            factura.setFechaReg(fecha);
            factura.setVigente("S");  
            factura.setFoto("/image");
            
            System.out.println("*********************************");
            System.out.println("idacceso que guarda----------->>" + acc.getIdAcceso());
            System.out.println("idProveedor que busca---------->>" + idProv);
            System.out.println("idProveedor que trae ------->>" + p.getIdProveedor());
            System.out.println("fecha objeto-->>" + fecha);
            System.out.println("***");  
            System.out.println("*********************************");
            
            facturaDAO.guardaFactura(factura);
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("factura", factura);
            
            //activaFrmArt = true;
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Factura Guardada Correctamente" ) );
            
            
        }catch(Exception e){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Error al Guardar Factura" ) );
        }
        
    }    
    
    
     public void guardarArticulo(){
         
        try{
            BigDecimal valor = new BigDecimal("0.0");
            BigDecimal canti = new BigDecimal("0.0");
            BigDecimal uxc = new BigDecimal("0.0");
            BigDecimal uxp = new BigDecimal("0.0");
            BigDecimal pzs = new BigDecimal("0.0");
            BigDecimal totalPzs = new BigDecimal("0.0");
            BigDecimal cu  = new BigDecimal("0.0");
            BigDecimal cc  = new BigDecimal("0.0");
            BigDecimal cp  = new BigDecimal("0.0");
            BigDecimal cpz = new BigDecimal("0.0");
            BigDecimal ct  = new BigDecimal("0.0");
            Double cuni=0.0, ctdad=0.0 , ctotal=0.0, totalp=0.0, cpieza=0.0;
            DecimalFormat df = new DecimalFormat("#.##");  
            
            ArticuloEntrada ae = new ArticuloEntrada();
            Departamento depto = new Departamento();
            
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
                canti = cantidad;uxc = uxcaja;uxp = uxpaquete; cu = costoUnitario; cc = costoUnitario;
                
                if(uxc.compareTo(new BigDecimal("0.0")) == 1 ){
                    //System.out.println("****** entra al if *******");
                    pzs = canti.multiply(uxc);
                    if(uxp.compareTo(new BigDecimal("0.0")) == 1 ){
                        totalPzs = uxp.multiply(pzs);
                    }
                }else{
                    if(pzs.compareTo(new BigDecimal("0.0")) == 1 ){  
                        totalPzs = canti.multiply(uxp);   
                    }
                }
                //sacamos costo por pieza
                //ct = cu.multiply(canti);
                //cpz = ct.divide(totalPzs);
                
                System.out.println("*************operaciones**********************");
                System.out.println("**** lo que tiene canti----------->>"+canti);
                System.out.println("**** lo que tiene cajas----------->>"+uxc);
                System.out.println("**** lo que tiene paquetes-------->>"+uxp);
                System.out.println("**** lo que tiene piezas---------->>"+pzs);
                System.out.println("**** total de piezas a ingresar--->>"+totalPzs);  
                
                
            }
            
            if(idUdm == 2){
                System.out.println("****** entra a paquetes ******");
                canti = cantidad; uxp = uxpaquete; cu = costoUnitario; cp = costoUnitario;
                
                
                    if(uxp.compareTo(new BigDecimal("0.0"))  == 1 ){
                        totalPzs = canti.multiply(uxp);
                    }else{
                        totalPzs = canti;
                    }
                
                System.out.println("*************operaciones**********************");
                System.out.println("**** lo que tiene canti----------->>"+canti);
                System.out.println("**** lo que tiene paquetes-------->>"+uxp);
                System.out.println("**** total de piezas a ingresar--->>"+totalPzs);
                
                
                
            }
            
            if(idUdm == 3){
                canti = cantidad;cu = costoUnitario;
                
                totalPzs = canti;
                    
                System.out.println("*************operaciones**********************");
                System.out.println("**** lo que tiene canti----------->>"+canti);
                System.out.println("**** lo que tiene piezas---------->>"+pzs);
                System.out.println("**** total de piezas a ingresar--->>"+totalPzs);
                
               
                
            }
             
                    
            System.out.println("************* entra a operaciones matematicas *****************");
            //System.out.println("*** lo que tiene cu -->>"+df.format(cuni));
            //System.out.println("*** lo que tiene canti -->>"+df.format(ctdad));
            cuni= cu.doubleValue();
            ctdad = canti.doubleValue();
            ctotal = cuni * ctdad;
            //ct = cu.multiply(canti);
            //System.out.println("*** lo que tiene ct--->>"+df.format(ctotal));
            //System.out.println("*** lo que tiene totalPzs -->>"+totalPzs);
            totalp = totalPzs.doubleValue();
            cpieza = ctotal / totalp;
            //cpz = ct.divide(totalPzs);
            //cpz = cpz.setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println("*** lo que tiene cpz -->"+df.format(cpieza));
            System.out.println("*** lo que tiene totalp -->>"+totalp);
            System.out.println("************* pasa operaciones matematicas**********************");
            
            if( idAsignacion == null ){
                //System.out.println("**** entra al if de departamento *****");
                depto = departamentoDAO.encuentraUnDepto(fac.getDepartamento().getIdDepartamento());
            }else{
                //System.out.println("**** entra al else de departamento *****");
                depto = departamentoDAO.encuentraUnDepto(idAsignacion);
            }
            
            
            //depto = departamentoDAO.encuentraUnDepto(fac.getDepartamento().getIdDepartamento());
            artEnt.setCantidad(new BigDecimal( ctdad ));
            artEnt.setUnidadesPorCaja(uxc);
            artEnt.setUnidadesPorPaquete(uxp); 
            artEnt.setPiezas(totalPzs);
            artEnt.setCostoUnitario(cu);
            artEnt.setCostoCaja(cc);
            artEnt.setCostoPaquete(cp);
            artEnt.setCostoPieza(new BigDecimal( cpieza ));
            if(esResguardo){
                artEnt.setEsResguardo("Y");
            }else{
                artEnt.setEsResguardo("N");
            }
            
            //artEnt.setNumeroDeSerie(art.getCb());
            //artEnt.setObservaciones("qaz");
            artEnt.setCbInterno("1-1-07062016");
            
            artEnt.setDepartamento(depto);
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
            ae.setCbInterno(idArticuloEntrada + "X" + fac.getProveedor().getIdProveedor()+ "X" + formateador.format(fac.getFechaRecepcion()));
            artEntDao.actualizarArticuloEntrada(ae);
            //System.out.println("*************lista de articulo **********************");
            listaArtEnt = artEntDao.listaArtEnt(fac.getIdFactura());
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
        Boolean exito;
        try{
            
            exito = artEntDao.eliminaArticuloEntrada(eliminaArt);
            listaArtEnt = artEntDao.listaArtEnt(factura.getIdFactura());
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Articulo Eliminado" ) );
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Articulo No Elimindo" ) );
        }
        
    }
    
    public void eliminaFactura(){
        
        if(eliminaAllArticulos() == false){
            try{
                facturaDAO.eliminaFactura(eliminaFac);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Factura Eliminada" ) );
            }catch(Exception e){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error NO se elimino la Factura" ) );
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Hay Salidas Asignadas " ) );
        }
        
    }
    
    public boolean eliminaAllArticulos(){
        List<ArticuloEntrada> lista = artEntDao.listaArtEnt(eliminaFac.getIdFactura());
        boolean hayArticulos = false;
        for(ArticuloEntrada ae: lista){
            if(salArtDao.encuentraArticulosSal(ae.getIdArticuloEntrada())){
                hayArticulos = true;
            }
        }
        
        if(hayArticulos){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Hay por lo Menos un Articulo Asignado a una Salida " ) );
        }else{
            try{
                for (ArticuloEntrada ae2 : lista) {
                    boolean eliminados = artEntDao.eliminaArticuloEntrada(ae2);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Articulos Eliminados" ) );
            }catch(Exception e){
                hayArticulos = true;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al Eliminar los Articulos de la Factura" ) );
            }
            
        }
        
        return hayArticulos;
    }
   
    
    public void habilitarTxt(){
        if(idUdm == 1){
            uxcaja = null;
            uxpaquete = null;
            cantidad = null;
            txtCantidad = true;
            txtCaja = true;
            txtPaquete = true;
            txtLitros = false;
            txtMts = false;
        }
        if(idUdm == 2){
            txtCantidad = true;
            txtCaja = false;
            txtPaquete = true;
            txtLitros = false;
            txtMts = false;
            uxcaja = null;
            uxpaquete = null;
            cantidad = null;
            costoUnitario = null;
        }
        if(idUdm == 3){
            txtCaja = false;
            txtPaquete = false;
            txtCantidad = true;
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
        
    } 
     
     
    public void verFrmArticulos(){
        activaFrmArt = true;   
    }
    
    public void ocultarFrmArticulos(){
        activaFrmArt = false;
        listaArtEnt = null;
        limpiaTxt();
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
    
}
