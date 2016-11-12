package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.XMLConstants;

@Entity
@Table(name = "PROMOCIONES")
public class Promocion implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 10)
	private String codigo;

	@Column(name = "DESCRIPCION", length = 50, nullable = false)
	private String descripcion;

	public Promocion() {
	}

	public Promocion(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
