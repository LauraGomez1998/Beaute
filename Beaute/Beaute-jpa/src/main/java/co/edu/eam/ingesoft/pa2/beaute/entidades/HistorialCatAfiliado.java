package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HISTORIAL_CATE_AFIL")
public class HistorialCatAfiliado implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 10)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "CATEGORIA", nullable = false)
	private CategoriaAfiliado categoria;

	@ManyToOne
	@JoinColumn(name = "AFILIADO", nullable = false)
	private Afiliado afiliado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA", nullable = false)
	private Date fecha;

	public HistorialCatAfiliado() {
	}

	public HistorialCatAfiliado(int codigo, CategoriaAfiliado categoria, Afiliado afiliado, Date fecha) {
		super();
		this.codigo = codigo;
		this.categoria = categoria;
		this.afiliado = afiliado;
		this.fecha = fecha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public CategoriaAfiliado getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaAfiliado categoria) {
		this.categoria = categoria;
	}

	public Afiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
