package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VENTAS")
public class Venta implements Serializable {

	@Id
	@Column(name = "CODIGO", length = 10)
	private int codigo;

	@Column(name = "TOTAL_VENTA", length = 10, nullable = false)
	private double totalVenta;

	public Venta() {
	}

	public Venta(int codigo, double totalVenta) {
		super();
		this.codigo = codigo;
		this.totalVenta = totalVenta;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

}
