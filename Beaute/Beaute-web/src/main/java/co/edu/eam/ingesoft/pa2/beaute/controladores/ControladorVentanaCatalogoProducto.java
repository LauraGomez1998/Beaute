package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryAbstractCellEditor;
import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.ProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PromocionEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Catalogo;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoProducto;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Promocion;

@Named("catalogoProductoWeb")
@ViewScoped
public class ControladorVentanaCatalogoProducto implements Serializable {

	@EJB
	private ProductoEJB productoEJB;

	@EJB
	private PromocionEJB promcionEJB;

	@EJB
	private CatalogoEJB catalogoEJB;

	@EJB
	private CatalogoProductoEJB catalogoProdEJB;

	private Date fechaInicio;

	private Date fechaFin;

	private Producto producto;

	private Catalogo catalogo;

	private Promocion promocion;

	private String promocionSelect;

	private List<Producto> productos;

	private List<Promocion> promociones;

	private List<Catalogo> catalogos;

	private boolean desactivar;

	@PostConstruct
	public void inicializar() {
		productos = productoEJB.listarProductos();
		catalogos = catalogoEJB.listar();
		
		
		desactivar = false;
	}

	public void activarPromocion() {
		if (promocionSelect.equals("0")) {
			promociones = promcionEJB.listarPromociones();
			System.out.println(promocionSelect);
			desactivar = true;
		} else {
			desactivar = false;
		}
	}

	public void crear() {
		if (catalogo != null && producto != null) {
				CatalogoProducto catProd = new CatalogoProducto(catalogo, producto, promocion, fechaInicio, fechaFin);
				catalogoProdEJB.crear(catProd);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"El producto se registro en el catalogo exitosamente", null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Llene campos", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Catalogo> getCatalogos() {
		return catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public String getPromocionSelect() {
		return promocionSelect;
	}

	public void setPromocionSelect(String promocionSelect) {
		this.promocionSelect = promocionSelect;
	}

	public boolean isDesactivar() {
		return desactivar;
	}

	public void setDesactivar(boolean desactivar) {
		this.desactivar = desactivar;
	}

}
