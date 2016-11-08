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
@Table(name = "AFILIADOS_PREMIOS")
public class AfiliadoPremio implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 50, nullable = false)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "AFILIADO", nullable = false)
	private Afiliado afiliado;

	@ManyToOne
	@JoinColumn(name = "PREMIO", nullable = false)
	private Premio premio;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_PREMIO", nullable = false)
	private Date fecha;

	public AfiliadoPremio() {
	}

	public AfiliadoPremio(int codigo, Afiliado afiliado, Premio premio, Date fecha) {
		super();
		this.codigo = codigo;
		this.afiliado = afiliado;
		this.premio = premio;
		this.fecha = fecha;
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

	public Premio getPremio() {
		return premio;
	}

	public void setPremio(Premio premio) {
		this.premio = premio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
