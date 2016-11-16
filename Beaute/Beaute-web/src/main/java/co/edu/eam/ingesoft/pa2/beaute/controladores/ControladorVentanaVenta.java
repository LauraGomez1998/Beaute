package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoPedidoAfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PedidoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.ProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.VentaEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.VentaProductoPedidoEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoPedidoAfiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Pedido;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Venta;
import co.edu.eam.ingesoft.pa2.beaute.entidades.VentaProductoPedido;

@Named("ventaWeb")
@ViewScoped
public class ControladorVentanaVenta implements Serializable {

	/**
	 * EJB de la clase catalogoPedidoAfiliado
	 */
	@EJB
	private CatalogoPedidoAfiliadoEJB catalogoPEdidoAfiliadoEJB;
	/**
	 * EJB de la clase producto
	 */
	@EJB
	private ProductoEJB productoEJB;
	/**
	 * EJB de la clase venta
	 */
	@EJB
	private VentaEJB ventaEJB;
	/**
	 * EJB de la clase VentaPedido
	 */
	@EJB
	private VentaProductoPedidoEJB ventaProductoPedidoEJB;
	/**
	 * EJB de la clase pedido
	 */
	@EJB
	private PedidoEJB pedidoEJB;
	/**
	 * lista de pedidos del afiliado
	 */
	private List<CatalogoPedidoAfiliado> listaInventario;
	/**
	 * codigo del producto
	 */
	private String codigoProducto;
	/**
	 * codigo del pedido
	 */
	private int codigoPedido;
	/**
	 * cantidad a vender
	 */
	private int cantidad;

	/**
	 * metodo que inicializa
	 */
	@PostConstruct
	public void inicializar() {
		listaInventario = catalogoPEdidoAfiliadoEJB.listarCatalogoPedido(123);
	}

	/**
	 * metodo para vender un producto
	 */
	public void vender() {
		CatalogoPedidoAfiliado productoPedido = catalogoPEdidoAfiliadoEJB.buscarCatalogoPedido(codigoPedido,
				codigoProducto);
		if (productoPedido != null) {
			Producto p = productoEJB.buscar(codigoProducto);
			Pedido pedido = pedidoEJB.buscar(codigoPedido);
			int codV = ventaEJB.autoIncrementar();
			Venta v = new Venta(codV, p.getPrecio() * cantidad, Calendar.getInstance().getTime());
			ventaEJB.crear(v);
			int cod = ventaProductoPedidoEJB.autoIncremental();
			VentaProductoPedido ventaPro = new VentaProductoPedido(cod, v, p, pedido, cantidad);
			ventaProductoPedidoEJB.crear(ventaPro);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Los datos ingresados son erroneos",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * Modificadores y accesores
	 */
	public List<CatalogoPedidoAfiliado> getListaInventario() {
		return listaInventario;
	}

	public void setListaInventario(List<CatalogoPedidoAfiliado> listaInventario) {
		this.listaInventario = listaInventario;
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
