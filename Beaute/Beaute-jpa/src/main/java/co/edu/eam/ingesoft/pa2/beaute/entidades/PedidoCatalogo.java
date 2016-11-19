package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.TipoPagoEnum;

import javax.persistence.Temporal;

@Entity
@Table(name = "PEDIDOS_CATALOGOS")
@NamedQueries({
		@NamedQuery(name = PedidoCatalogo.LISTAR_PEDIDOS_AFI, query = "select p from PedidoCatalogo p where p.afiliado.cedulaAfiliado=?1 and p.estadoPedido=false"),
		@NamedQuery(name = PedidoCatalogo.TAMANIO, query = "select p from PedidoCatalogo p"),
		@NamedQuery(name = PedidoCatalogo.LISTAR_PEDIDOS_APROBADOS, query = "select p from PedidoCatalogo p where p.afiliado.cedulaAfiliado=?1 and p.estadoPedido=true")})
public class PedidoCatalogo implements Serializable {

	public static final String LISTAR_PEDIDOS_AFI = "PedidoCatalogo.listar";

	public static final String TAMANIO = "PedidoCatalogo.Tamanio";

	public static final String LISTAR_PEDIDOS_APROBADOS = "PedidoCatalogo.Aprobados";

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

	@Column(name = "ESTADO_PEDIDO")
	private boolean estadoPedido;

	public PedidoCatalogo() {
	}

	public PedidoCatalogo(int codigo, Afiliado afiliado, Cliente cliente, Date fechaPedido, TipoPagoEnum tipoPago,
			boolean estadoPedido) {
		super();
		this.codigo = codigo;
		this.afiliado = afiliado;
		this.cliente = cliente;
		this.fechaPedido = fechaPedido;
		this.tipoPago = tipoPago;
		this.estadoPedido = estadoPedido;
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

	public boolean isEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(boolean estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

}
