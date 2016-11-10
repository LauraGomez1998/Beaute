package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PedidoEJB;
import co.edu.eam.ingesoft.pa2.beaute.dto.PedidoAfiliadoDTO;
import co.edu.eam.ingesoft.pa2.beaute.dto.ProductoDTO;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;

@Named("pedidoAfiliadoWeb")
@ViewScoped
public class ControladorVentanaPedidoAfiliado implements Serializable {

	@EJB
	private CatalogoProductoEJB catalogoProductoEJB;

	@EJB
	private PedidoEJB pedidoEJB;

	private int cantidad;

	private List<Producto> listaProductos;

	private Producto productoSeleccionado;

	private List<ProductoDTO> listaProductoPedido;

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
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.POLVOS);
		} else if (seleecionado == 1) {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.LABIAL);
		} else if (seleecionado == 2) {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.JABONES);
		} else {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.OTROS);
		}
	}

	public void pedir() {
		PedidoAfiliadoDTO pedidoAfiliado = new PedidoAfiliadoDTO(listaProductoPedido, 123);
		pedidoEJB.crearPedido(pedidoAfiliado);
	}

	public void agregarProducto() {
		if (productoSeleccionado != null && cantidad > 0) {
			ProductoDTO productoAgregar = new ProductoDTO(productoSeleccionado, cantidad);
			listaProductoPedido.add(productoAgregar);
		}
	}

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
