package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "VENTA_PROD_VENTAS")
@NamedQueries({ @NamedQuery(name = VentaProductoPedido.TAMANIO, query = "select v from VentaProductoPedido v") })
public class VentaProductoPedido implements Serializable {

	public static final String TAMANIO = "VentaProductoPedido.Tamanio";

	@Id
	@Column(name = "CODIGO", length = 10)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "VENTA", nullable = false)
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "PRODUCTO", nullable = false)
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "PEDIDO", nullable = false)
	private Pedido pedido;

	@Column(name = "CANTIDAD", length = 10, nullable = false)
	private int cantidad;

	public VentaProductoPedido() {
	}

	public VentaProductoPedido(int codigo, Venta venta, Producto producto, Pedido pedido, int cantidad) {
		super();
		this.codigo = codigo;
		this.venta = venta;
		this.producto = producto;
		this.pedido = pedido;
		this.cantidad = cantidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
