package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTROLES_PAGOS")
public class ControlPago implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 7)
	private int codigo;

	@Column(name = "PORCENTAJE", length = 7, nullable = false)
	private int porcentaje;

	@Column(name = "NIVEL", length = 7, nullable = false)
	private int nivel;

	public ControlPago() {
	}

	public ControlPago(int codigo, int porcentaje, int nivel) {
		super();
		this.codigo = codigo;
		this.porcentaje = porcentaje;
		this.nivel = nivel;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
