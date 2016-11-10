package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUOTAS")
public class Cuota implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CODIGO", length = 50)
	private int codigo;

	@ManyToOne
	@JoinColumn(name = "PEDIDO_CATALOGO", nullable = false)
	private PedidoCatalogo pedidoCatalogo;

	@Column(name = "NUMERO_CUOTAS", length = 10, nullable = false)
	private int numeroCuotas;

	public Cuota() {
	}

	public Cuota(PedidoCatalogo pedidoCatalogo, int numeroCuotas) {
		super();
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
