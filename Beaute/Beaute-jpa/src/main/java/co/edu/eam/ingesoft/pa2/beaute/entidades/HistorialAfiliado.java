package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.EstadoHistorialEnum;

@Entity
@Table(name = "HISTORIALES_AFILIADOS")
public class HistorialAfiliado implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 15)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "AFILIADO", nullable = false)
	private Afiliado afiliado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_AFILIACION", nullable = false)
	private Date fechaAfiliacion;

	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO", length = 10, nullable = false)
	private EstadoHistorialEnum estado;

	public HistorialAfiliado() {
	}

	public HistorialAfiliado(int codigo, Afiliado afiliado, Date fechaAfiliacion, EstadoHistorialEnum estado) {
		super();
		this.codigo = codigo;
		this.afiliado = afiliado;
		this.fechaAfiliacion = fechaAfiliacion;
		this.estado = estado;
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

	public Date getFechaAfiliacion() {
		return fechaAfiliacion;
	}

	public void setFechaAfiliacion(Date fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	public EstadoHistorialEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoHistorialEnum estado) {
		this.estado = estado;
	}

}
