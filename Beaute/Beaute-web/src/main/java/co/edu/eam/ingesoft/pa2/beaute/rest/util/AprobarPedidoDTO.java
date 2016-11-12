package co.edu.eam.ingesoft.pa2.beaute.rest.util;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Cuota;
import co.edu.eam.ingesoft.pa2.beaute.entidades.PedidoCatalogo;

public class AprobarPedidoDTO {

	private PedidoCatalogo pedido;
	private Cuota cuota;

	public AprobarPedidoDTO() {
	}

	public AprobarPedidoDTO(PedidoCatalogo pedido, Cuota cuota) {
		super();
		this.pedido = pedido;
		this.cuota = cuota;
	}

	public PedidoCatalogo getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCatalogo pedido) {
		this.pedido = pedido;
	}

	public Cuota getCuota() {
		return cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

}
