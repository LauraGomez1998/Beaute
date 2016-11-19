package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CUOTAS")
@NamedQueries({ @NamedQuery(name = Cuota.LISTAR_CUOTAS, query = "select c from Cuota c where c.pedidoCatalogo=?1"),
		@NamedQuery(name = Cuota.AUTOINCREMENTAL, query = "select c from Cuota c"),
		@NamedQuery(name = Cuota.CUOTAS_PEDIDO, query = "select c from Cuota c where c.pedidoCatalogo.codigo=?1") })
public class Cuota implements Serializable {

	public static final String LISTAR_CUOTAS = "Cuotas.listar";

	public static final String AUTOINCREMENTAL = "Cuotas.Incremental";

	public static final String CUOTAS_PEDIDO = "Cuotas.Pedido";

	@Id
	@Column(name = "CODIGO", length = 50)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "PEDIDO_CATALOGO", nullable = false)
	private PedidoCatalogo pedidoCatalogo;

	@Column(name = "NUMERO_CUOTAS", length = 10, nullable = false)
	private int numeroCuotas;

	public Cuota() {
	}

	public Cuota(int codigo, PedidoCatalogo pedidoCatalogo, int numeroCuotas) {
		super();
		this.codigo = codigo;
		this.pedidoCatalogo = pedidoCatalogo;
		this.numeroCuotas = numeroCuotas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public PedidoCatalogo getPedidoCatalogo() {
		return pedidoCatalogo;
	}

	public void setPedidoCatalogo(PedidoCatalogo pedidoCatalogo) {
		this.pedidoCatalogo = pedidoCatalogo;
	}

	public int getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

}
