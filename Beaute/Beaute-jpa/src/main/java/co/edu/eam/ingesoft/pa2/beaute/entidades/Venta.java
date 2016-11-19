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
@Table(name = "VENTAS")
@NamedQueries({ @NamedQuery(name = Venta.TAMANIO, query = "select v from Venta v") })
public class Venta implements Serializable {

	public static final String TAMANIO = "Venta.Tamanio";


	@Id
	@Column(name = "CODIGO", length = 10)
	private int codigo;

	@Column(name = "TOTAL_VENTA", length = 10, nullable = false)
	private double totalVenta;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_VENTA", nullable = false)
	private Date fecha_venta;

	public Venta() {
	}

	public Venta(int codigo, double totalVenta, Date fecha_venta) {
		super();
		this.codigo = codigo;
		this.totalVenta = totalVenta;
		this.fecha_venta = fecha_venta;
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

	public Date getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

}
