package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CIUDADES")
@NamedQueries({ @NamedQuery(name = Ciudad.LISTAR_CIUDADES, query = "select c from Ciudad c") })
public class Ciudad implements Serializable {
 
	public static final String LISTAR_CIUDADES = "Ciudad.listar"; 

	@Id
	@Column(name = "CODIGO", length = 15)
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "DEPARTAMENTO", nullable = false)
	private Departamento departamento;

	@Column(name = "NOMBRE", length = 15, nullable = false)
	private String nombre;

	public Ciudad() {
	}

	public Ciudad(String codigo, Departamento departamento, String nombre) {
		super();
		this.codigo = codigo;
		this.departamento = departamento;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ciudad) {
			Ciudad tmpCiudad = (Ciudad) obj;
			if (this.codigo.equals(tmpCiudad.codigo)
					&& this.nombre.equals(tmpCiudad.nombre)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
