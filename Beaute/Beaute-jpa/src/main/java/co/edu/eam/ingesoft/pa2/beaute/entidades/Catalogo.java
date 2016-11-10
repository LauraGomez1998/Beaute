package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CATALOGOS")
public class Catalogo implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 20)
	private int codigo;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_VIGENCIA", nullable = false)
	private Date fechaVigencia;

	@Column(name = "UNIDADES", length = 20, nullable = false)
	private int unidades;

	public Catalogo() {
	}

	public Catalogo(int codigo, Date fechaVigencia, int unidades) {
		super();
		this.codigo = codigo;
		this.fechaVigencia = fechaVigencia;
		this.unidades = unidades;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

}
