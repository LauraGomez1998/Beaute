package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PREMIOS_VENTAS")
public class PremioVenta extends Premio implements Serializable {

	@Column(name = "CANTIDAD_VENTAS", length = 15, nullable = false)
	private int cantidadVentas;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	public PremioVenta() {
	}

	public PremioVenta(String codigo, String caracteristicas,int cantidadVentas, String descripcion) {
		super(codigo, caracteristicas);
		this.cantidadVentas = cantidadVentas;
		this.descripcion = descripcion;
	}

	public int getCantidadVentas() {
		return cantidadVentas;
	}

	public void setCantidadVentas(int cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
