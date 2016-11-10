package co.edu.eam.ingesoft.pa2.beaute.dtos;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;

public class ProductoDTO {

	private Producto producto;
	private int cantidad;

	public ProductoDTO() {
	}

	public ProductoDTO(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
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

}
