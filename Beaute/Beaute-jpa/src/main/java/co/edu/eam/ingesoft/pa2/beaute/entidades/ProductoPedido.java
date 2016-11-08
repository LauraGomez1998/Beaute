package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.beaute.pks.PedidoProductoPk;

@Entity
@Table(name = "PRODUCOTS_PEDIDOS")
@IdClass(value = PedidoProductoPk.class)
public class ProductoPedido implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 20)
	private int codigo;

	@Id
	@ManyToOne
	@JoinColumn(name = "PRODUCTO", nullable = false)
	private Producto producto;

	@Column(name = "CANTIDAD", length = 10, nullable = false)
	private int cantidad;

	@Column(name = "PRECIO", length = 10, nullable = false)
	private int precio;

	public ProductoPedido() {
	}

	public ProductoPedido(int codigo, Producto producto, int cantidad, int precio) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
