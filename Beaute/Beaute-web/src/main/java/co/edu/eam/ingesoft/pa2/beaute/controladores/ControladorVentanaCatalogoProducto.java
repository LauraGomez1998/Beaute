package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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

	private Promocion promocion;

	private String promocionSelect;

	private List<Producto> productos;

	private List<Promocion> promociones;

	private Catalogo catalogoAnterior;

	private int codigoCatalogo;

	private boolean desactivar;

	private double precioVenta;

	@PostConstruct
	public void inicializar() {
		productos = productoEJB.listarProductos();
		cargarCatalogo();
		desactivar = false;
	}

	public void activarPromocion() {
		if (promocionSelect.equals("0")) {
			promociones = promcionEJB.listarPromociones();
			desactivar = true;
		} else {
			desactivar = false;
		}
	}

	public void mostrarPrecio() {
		if (producto != null) {
			precioVenta = producto.getPrecio();
		} else {
			precioVenta = 3;
		}

	}

	public void cargarCatalogo() {
		catalogoAnterior = catalogoEJB.buscarUltimoCatalogo();
		Date fechaActual = Calendar.getInstance().getTime();
		if (catalogoAnterior != null && catalogoAnterior.getFechaVigencia().after(fechaActual)) {
			codigoCatalogo = catalogoAnterior.getCodigo();
		} else {
			codigoCatalogo = 0;
		}
	}

	/**
	 * FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
	 * "El producto se registro en el catalogo exitosamente", null);
	 * FacesContext.getCurrentInstance().addMessage(null, message);
	 */
	public void crear() {
		System.out.println("ALGOOOOOOOOOOOOOOOOOOOO --------------gbvsdfghfdsbfnjfhgdfdcfghjkjhgfdsfghjkhgfdsdfghjhgfds");
		/**if (codigoCatalogo != 0) {
			System.out.println("HAY CATALOGOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			if (producto != null && desactivar == true) {
				CatalogoProducto c = catalogoProdEJB.validar(producto.getCodigo(), codigoCatalogo);
				System.out.println("entro--------------------------------------------------");
				if (c == null) {
					precioVenta = producto.getPrecio() * (promocion.getDescuento() / 100);
					CatalogoProducto catalogoProduc = new CatalogoProducto(catalogoAnterior, producto, promocion, fechaInicio, fechaFin, precioVenta);
					catalogoProdEJB.crear(catalogoProduc);
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El producto se ha registrado en el catalogo", null);
					FacesContext.getCurrentInstance().addMessage(null, message);
				} else {
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Este producto ya está registrado en el catalogo", null);
					FacesContext.getCurrentInstance().addMessage(null, message);
				}

			} else {
				System.out.println("producto nulo -----------------------------------");
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Llene campos", null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Por favor, ingrese un catálogo primero", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}**/
	}

	public void agregarPromocion() {

	}

	public void buscar() {

	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Catalogo getCatalogoAnterior() {
		return catalogoAnterior;
	}

	public void setCatalogoAnterior(Catalogo catalogoAnterior) {
		this.catalogoAnterior = catalogoAnterior;
	}

	public int getCodigoCatalogo() {
		return codigoCatalogo;
	}

	public void setCodigoCatalogo(int codigoCatalogo) {
		this.codigoCatalogo = codigoCatalogo;
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

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

}
