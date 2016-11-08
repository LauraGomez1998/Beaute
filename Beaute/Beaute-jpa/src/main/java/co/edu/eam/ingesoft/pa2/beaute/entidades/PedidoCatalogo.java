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
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.TipoPagoEnum;

import javax.persistence.Temporal;

@Entity
@Table(name = "PEDIDOS_CATALOGOS")
public class PedidoCatalogo implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 20)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "AFILIADO", nullable = false)
	private Afiliado afiliado;

	@ManyToOne
	@JoinColumn(name = "CLIENTE", nullable = false)
	private Cliente cliente;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_PEDIDO", nullable = false)
	private Date fechaPedido;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_PAGO", length = 10, nullable = false)
	private TipoPagoEnum tipoPago;

	public PedidoCatalogo() {
	}

	public PedidoCatalogo(int codigo, Afiliado afiliado, Cliente cliente, Date fechaPedido, TipoPagoEnum tipoPago) {
		super();
		this.codigo = codigo;
		this.afiliado = afiliado;
		this.cliente = cliente;
		this.fechaPedido = fechaPedido;
		this.tipoPago = tipoPago;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public TipoPagoEnum getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPagoEnum tipoPago) {
		this.tipoPago = tipoPago;
	}

}
