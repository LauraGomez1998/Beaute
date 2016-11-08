package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 15)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "PAIS", nullable = false)
	private Pais pais;

	@Column(name = "NOMBRE", length = 15, nullable = false)
	private String nombre;

	public Departamento() {
	}

	public Departamento(int codigo, String nombre, Pais pais) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.pais = pais;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
