package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.VentaEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.VentaProductoPedidoEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.VentaProductoPedido;

@Named("historialWeb")
@ViewScoped
public class ControladorVentanaHistorialVentas implements Serializable {

	/**
	 * EJB de la clase venta
	 */
	@EJB
	private VentaProductoPedidoEJB ventaProductoPedidoEJB;

	@EJB
	private AfiliadoEJB afiliadoEJB;
	/**
	 * lista de ventas de un afiliado
	 */
	private List<VentaProductoPedido> listaVentas;

	/**
	 * metodo que inicializa
	 */
	@PostConstruct
	public void inicializar() {
		listaVentas = ventaProductoPedidoEJB.listarVentas(afiliadoEJB.CEDULAAFILIADO);
	}

	public List<VentaProductoPedido> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<VentaProductoPedido> listaVentas) {
		this.listaVentas = listaVentas;
	}
}
