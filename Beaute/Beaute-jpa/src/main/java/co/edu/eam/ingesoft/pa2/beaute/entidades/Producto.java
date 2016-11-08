package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;

@Entity
@Table(name = "PRODUCTOS")
public class Producto implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 20)
	private int codigo;

	@Enumerated(EnumType.STRING)
	@Column(name = "CATEGORIA", length = 10, nullable = false)
	private CategoriaProductoEnum categoria;

	@Column(name = "CANTIDAD", length = 10, nullable = false)
	private int cantidad;

	@Column(name = "PRECIO", length = 10, nullable = false)
	private double precio;

	@Column(name = "ESTADO", length = 10, nullable = true)
	private boolean estado;

	@Column(name = "NOMBRE", length = 50, nullable = false)
	private String nombre;

	@Column(name = "CARACTERISTICAS", length = 50, nullable = true)
	private String caracteristica;

	public Producto() {
	}

	public Producto(int codigo, CategoriaProductoEnum categoria, int cantidad, double precio, boolean estado,
			String nombre, String caracteristica) {
		super();
		this.codigo = codigo;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
		this.estado = estado;
		this.nombre = nombre;
		this.caracteristica = caracteristica;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public CategoriaProductoEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProductoEnum categoria) {
		this.categoria = categoria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

}
