package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PREMIOS")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({ @NamedQuery(name = Premio.LISTAR_PREMIOS, query = "select p from Premio p") })
public class Premio implements Serializable {

	public final static String LISTAR_PREMIOS = "Premio.listar";
	@Id
	@Column(name = "CODIGO", length = 10)
	protected String codigo;

	@Column(name = "DESCRIPCION", length = 50, nullable = false)
	protected String descripcion;

	public Premio() {
	}

	public Premio(String codigo, String descripcion) {
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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Premio) {
			Premio tmpPremio = (Premio) obj;
			if (this.codigo.equals(tmpPremio.codigo)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
