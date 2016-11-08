package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Table(name = "COMISIONES")
public class Comision implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 10)
	private int codigo;

	@Column(name = "PORCENTAJE", length = 10, nullable = false)
	private double porcentaje;

	public Comision() {
	}

	public Comision(int codigo, double porcentaje) {
		super();
		this.codigo = codigo;
		this.porcentaje = porcentaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
