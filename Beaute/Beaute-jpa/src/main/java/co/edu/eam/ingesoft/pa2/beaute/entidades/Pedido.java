package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PEDIDOS")
@NamedQueries({ @NamedQuery(name = Pedido.TAMANIO, query = "select p from Pedido p") })
public class Pedido implements Serializable {

	public static final String TAMANIO = "Pedido.Tamanio";

	@Id
	@Column(name = "CODIGO", length = 10)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "AFILIADO", nullable = false)
	private Afiliado afiliado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_PEDIDO", nullable = false)
	private Date fechaPedido;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ENTREGA", nullable = false)
	private Date fechaEntrega;

	public Pedido() {
	}

	public Pedido(int codigo, Afiliado afiliado, Date fechaPedido, Date fechaEntrega) {
		super();
		this.codigo = codigo;
		this.afiliado = afiliado;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
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

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

}
