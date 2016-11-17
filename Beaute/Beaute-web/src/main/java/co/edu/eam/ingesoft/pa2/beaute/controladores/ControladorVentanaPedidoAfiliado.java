package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PedidoEJB;
import co.edu.eam.ingesoft.pa2.beaute.dto.PedidoAfiliadoDTO;
import co.edu.eam.ingesoft.pa2.beaute.dto.ProductoDTO;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;

@Named("pedidoAfiliadoWeb")
@ViewScoped
public class ControladorVentanaPedidoAfiliado implements Serializable {

	/**
	 * EJB de la clase afiliado
	 */
	@EJB
	private AfiliadoEJB afiliadoEJB;
	/**
	 * EJB de la clase catalogo producto
	 */
	@EJB
	private CatalogoProductoEJB catalogoProductoEJB;
	/**
	 * EJB de la clase pedido
	 */
	@EJB
	private PedidoEJB pedidoEJB;
	/**
	 * cantidad del producto
	 */
	private int cantidad;
	/**
	 * lista de productos
	 */
	private List<Producto> listaProductos;
	/**
	 * producto seleccionado
	 */
	private Producto productoSeleccionado;
	/**
	 * lista de productos pedidos
	 */
	private List<ProductoDTO> listaProductoPedido;

	/**
	 * metodo de inicializar
	 */
	@PostConstruct
	public void iniciar() {
		listaProductoPedido = new ArrayList<>();
	}

	/**
	 * muestra los productos de la categoria seleccionada
	 * 
	 * @param seleccion
	 *            el valor seccionado
	 */
	public void mostrarProductos(int seleecionado) {
		if (seleecionado == 0) {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.SALUD);
		} else if (seleecionado == 1) {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.MAQUILLAJE);
		} else if (seleecionado == 2) {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.ROPA);
		} else {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.JOYERÍA);
		}
	}

	/**
	 * crea el pedido del afiliado
	 */
	public void pedir() {
		try {
			PedidoAfiliadoDTO pedidoAfiliado = new PedidoAfiliadoDTO(listaProductoPedido, afiliadoEJB.CEDULAAFILIADO);
			pedidoEJB.crearPedido(pedidoAfiliado);
			listaProductoPedido = null;
			listaProductoPedido = new ArrayList<>();
		} catch (EJBTransactionRolledbackException e) {
			Throwable t = e;
			while (!(t.getCause() instanceof SQLException)) {
				t = t.getCause();
				if (t == null) {
					break;
				}
				if (t.getCause() instanceof SQLException) {
					SQLException sql = (SQLException) t.getCause();
					if (sql.getErrorCode() == 20001) {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"A superado la cantidad de productos disponibles", null);
						FacesContext.getCurrentInstance().addMessage(null, message);
					}
				}
			}
		}
	}

	/**
	 * agrega un producto a un pedido
	 */
	public void agregarProducto() {
		if (productoSeleccionado != null && cantidad > 0) {
			if (listaProductoPedido.isEmpty()) {
				ProductoDTO productoAgregar = new ProductoDTO(productoSeleccionado, cantidad);
				listaProductoPedido.add(productoAgregar);
			} else {
				boolean encontro = false;
				for (int i = 0; i < listaProductoPedido.size(); i++) {
					if (listaProductoPedido.get(i).getProducto().getCodigo()
							.equalsIgnoreCase(productoSeleccionado.getCodigo())) {
						int cant = listaProductoPedido.get(i).getCantidad();
						listaProductoPedido.get(i).setCantidad(cant + cantidad);
						encontro = true;
					}
				}
				if (!encontro) {
					ProductoDTO productoAgregar = new ProductoDTO(productoSeleccionado, cantidad);
					listaProductoPedido.add(productoAgregar);
				}
			}
		}
	}

	/**
	 * Accesores y modificadores
	 */
	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public List<ProductoDTO> getListaProductoPedido() {
		return listaProductoPedido;
	}

	public void setListaProductoPedido(List<ProductoDTO> listaProductoPedido) {
		this.listaProductoPedido = listaProductoPedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
