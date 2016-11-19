package co.edu.eam.ingesoft.pa2.beaute.dto;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Cuota;
import co.edu.eam.ingesoft.pa2.beaute.entidades.PedidoCatalogo;

public class PedidoTotalDTO {

	private PedidoCatalogo pedidoCatalogo;

	private double total;

	private Cuota cuota;

	private double valorRestante;

	public PedidoTotalDTO() {
	}

	public PedidoTotalDTO(PedidoCatalogo pedidoCatalogo, double total, Cuota cuota, double valorRestante) {
		super();
		this.pedidoCatalogo = pedidoCatalogo;
		this.total = total;
		this.cuota = cuota;
		this.valorRestante = valorRestante;
	}

	public PedidoCatalogo getPedidoCatalogo() {
		return pedidoCatalogo;
	}

	public void setPedidoCatalogo(PedidoCatalogo pedidoCatalogo) {
		this.pedidoCatalogo = pedidoCatalogo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cuota getCuota() {
		return cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

	public double getValorRestante() {
		return valorRestante;
	}

	public void setValorRestante(double valorRestante) {
		this.valorRestante = valorRestante;
	}

}
