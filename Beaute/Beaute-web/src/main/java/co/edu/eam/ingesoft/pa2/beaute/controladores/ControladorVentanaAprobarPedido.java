package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoPedidoClienteEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CuotasEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PedidoCatalogoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PedidoEJB;
import co.edu.eam.ingesoft.pa2.beaute.dto.ProductoDTO;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoPedidoCliente;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Cuota;
import co.edu.eam.ingesoft.pa2.beaute.entidades.PedidoCatalogo;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.rest.util.AprobarPedidoDTO;

@Named("aprobarPedidoWeb")
@ViewScoped
public class ControladorVentanaAprobarPedido implements Serializable {

	/**
	 * EJB de la clase pedido catalogo
	 */
	@EJB
	private PedidoCatalogoEJB pedidoCatalogoEJB;
	/**
	 * EJB de la clase pedido catalogo
	 */
	@EJB
	private CatalogoPedidoClienteEJB pedidoCliente;

	/**
	 * EJB de la clase cuota
	 */
	@EJB
	private CuotasEJB cuotaEJB;

	/**
	 * EJB de la clase pedido
	 */
	@EJB
	private PedidoEJB pedidoEJB;
	/**
	 * lista de pedidos a un afiliado
	 */
	private List<PedidoCatalogo> listaPedidosPendientes;

	/**
	 * lista de pedidos por aprobar
	 */
	private List<AprobarPedidoDTO> pedidosPorAprobar;

	/**
	 * codigo del pedido
	 */
	private int codigoPedido;

	/**
	 * lista de pedido a un catalogo
	 */
	private List<CatalogoPedidoCliente> listaPedidoCatalogo;

	/**
	 * lista de productos pedidos
	 */
	private List<ProductoDTO> listaProductoPedido;

	@PostConstruct
	public void inicializar() {
		listaPedidosPendientes = pedidoCliente.listarPedidosAfiliado(123);
		pedidosPorAprobar = new ArrayList<>();
		for (int i = 0; i < listaPedidosPendientes.size(); i++) {
			Cuota c = cuotaEJB.buscarCuotaPedido(listaPedidosPendientes.get(i));
			AprobarPedidoDTO pedidos = new AprobarPedidoDTO(listaPedidosPendientes.get(i), c);
			pedidosPorAprobar.add(pedidos);
		}
	}

	/**
	 * muestra los producos en un pedido
	 */
	public void verProductos() {
		listaPedidoCatalogo = new ArrayList<>();
		listaPedidoCatalogo = pedidoCliente.listaProductosPedido(codigoPedido);
	}

	/**
	 * realiza un pedido
	 */
	public void pedir() {
		PedidoCatalogo catalogo = pedidoCatalogoEJB.buscar(codigoPedido);
		listaProductoPedido = new ArrayList<>();
		if (catalogo != null) {
			catalogo.setEstadoPedido(true);
			pedidoCatalogoEJB.editar(catalogo);
			List<CatalogoPedidoCliente> lista = pedidoCliente.listaProductosPedido(catalogo.getCodigo());
			for (int i = 0; i < lista.size(); i++) {
				ProductoDTO e = new ProductoDTO(lista.get(i).getCatalogo().getProducto(), lista.get(i).getCantidad());
				listaProductoPedido.add(e);
				pedidoEJB.crearPedidoCliente(listaProductoPedido, 123);
			}
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"No se ha encontrado el pedido ingresado", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public ControladorVentanaAprobarPedido() {
	}

	public List<PedidoCatalogo> getListaPedidosPendientes() {
		return listaPedidosPendientes;
	}

	public void setListaPedidosPendientes(List<PedidoCatalogo> listaPedidosPendientes) {
		this.listaPedidosPendientes = listaPedidosPendientes;
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public List<AprobarPedidoDTO> getPedidosPorAprobar() {
		return pedidosPorAprobar;
	}

	public void setPedidosPorAprobar(List<AprobarPedidoDTO> pedidosPorAprobar) {
		this.pedidosPorAprobar = pedidosPorAprobar;
	}

	public List<CatalogoPedidoCliente> listaPedidoCatalogo() {
		return listaPedidoCatalogo;
	}

	public void listaPedidoCatalogo(List<CatalogoPedidoCliente> listaProducto) {
		this.listaPedidoCatalogo = listaProducto;
	}
}
