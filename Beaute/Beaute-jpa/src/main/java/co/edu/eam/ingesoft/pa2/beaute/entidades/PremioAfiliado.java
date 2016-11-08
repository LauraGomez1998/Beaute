package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PREMIOS_AFILIADOS")
public class PremioAfiliado extends Premio implements Serializable {

	@Column(name = "CANTIDAD_AFILIADOS", length = 10, nullable=false)
	private int cantidadAfiliados;

	@Column(name = "DESCRIPCION", length = 50, nullable = false)
	private String descripcion;

	public PremioAfiliado() {

	}

	public PremioAfiliado(String codigo, String caracteristicas, int cantidadAfiliados, String descripcion) {
		super(codigo, caracteristicas);
		this.cantidadAfiliados = cantidadAfiliados;
		this.descripcion = descripcion;
	}

	public int getCantidadAfiliados() {
		return cantidadAfiliados;
	}

	public void setCantidadAfiliados(int cantidadAfiliados) {
		this.cantidadAfiliados = cantidadAfiliados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
