package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIAS_AFILIADOS")
public class CategoriaAfiliado implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 10)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="AFILIADO", nullable=false)
	private Afiliado afiliado;

	
	@Column(name = "PUNTOS", length = 10, nullable = false)
	private int puntos;

	@Column(name = "NOMBRE", length = 20, nullable = false)
	private String nombre;

	public CategoriaAfiliado() {
	}

	public CategoriaAfiliado(int codigo, Afiliado afiliado,  int puntos, String nombre) {
		super();
		this.codigo = codigo;
		this.puntos = puntos;
		this.nombre = nombre;
		this.afiliado = afiliado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	

	public Afiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
