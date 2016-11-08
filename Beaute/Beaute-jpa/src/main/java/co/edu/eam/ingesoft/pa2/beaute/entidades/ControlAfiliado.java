package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTROLES_AFILIADOS")
public class ControlAfiliado implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 7)
	private int codigo;

	@Column(name = "DIAS", length = 7, nullable = false)
	private int dias;

	public ControlAfiliado() {
	}

	public ControlAfiliado(int codigo, int dias) {
		super();
		this.codigo = codigo;
		this.dias = dias;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

}
