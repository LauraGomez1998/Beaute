package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VENTA_PROD_VENTAS")
public class VentaProductoPedido implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 10)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "VENTA", nullable = false)
	private Venta venta;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "CODIGO_PEDIDO", referencedColumnName = "codigo", nullable = false),
			@JoinColumn(name = "PRODUCTO", referencedColumnName = "producto", nullable = false) })
	private ProductoPedido pedidoProducto;

	@Column(name = "CANTIDAD", length = 10, nullable = false)
	private int cantidad;

	public VentaProductoPedido() {
	}

	public VentaProductoPedido(int codigo, int cantidad, Venta venta, ProductoPedido pedidoProducto) {
		super();
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.venta = venta;
		this.pedidoProducto = pedidoProducto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public ProductoPedido getPedidoProducto() {
		return pedidoProducto;
	}

	public void setPedidoProducto(ProductoPedido pedidoProducto) {
		this.pedidoProducto = pedidoProducto;
	}

}
