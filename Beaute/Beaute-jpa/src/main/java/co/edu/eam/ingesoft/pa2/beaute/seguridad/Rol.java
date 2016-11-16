package co.edu.eam.ingesoft.pa2.beaute.seguridad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Rol implements Serializable {

	@Id
	@Column(name = "CODIGO")
	private String id;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	public Rol() {
		super();
	}

	public Rol(String id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getId() {
		return id;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setId(String id) {
		this.id = id;
	}

}
