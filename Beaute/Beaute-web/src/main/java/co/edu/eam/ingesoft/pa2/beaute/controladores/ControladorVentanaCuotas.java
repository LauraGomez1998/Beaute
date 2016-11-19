package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoPedidoAfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoPedidoClienteEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CuotasEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PedidoCatalogoEJB;
import co.edu.eam.ingesoft.pa2.beaute.dto.PedidoTotalDTO;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoPedidoCliente;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Cuota;
import co.edu.eam.ingesoft.pa2.beaute.entidades.PedidoCatalogo;

@Named("cuotasWeb")
@ViewScoped
public class ControladorVentanaCuotas implements Serializable {

	@EJB
	private PedidoCatalogoEJB pedidoCatalogoEJB;

	@EJB
	private AfiliadoEJB afiliadoEJB;

	@EJB
	private CatalogoPedidoClienteEJB catalogoPedidoClienteEJB;

	@EJB
	private CuotasEJB cuotaEJB;

	private int codigoPedido;

	private List<PedidoCatalogo> lista;

	private List<PedidoTotalDTO> pedidosAprobados;

	@PostConstruct
	public void inicializar() {
		pedidosAprobados = new ArrayList<>();
		valorPedido();
	}

	public void valorPedido() {
		lista = pedidoCatalogoEJB.listarAprobaods(afiliadoEJB.CEDULAAFILIADO);
		if (!lista.isEmpty()) {
			for (int i = 0; i < lista.size(); i++) {
				List<CatalogoPedidoCliente> pedidos = catalogoPedidoClienteEJB.listarPedidosCliente(lista.get(i));
				double total = 0;
				double restante = 0;
				Cuota c = cuotaEJB.buscarCuotaPedido(lista.get(i));
				for (int j = 0; j < pedidos.size(); j++) {
					total = total
							+ (pedidos.get(j).getCatalogo().getProducto().getPrecio() * pedidos.get(j).getCantidad());
				}
				restante = total / c.getNumeroCuotas();
				if (c.getNumeroCuotas() > 0) {
					PedidoTotalDTO pedidoTotalDTO = new PedidoTotalDTO(lista.get(i), total, c, restante);
					pedidosAprobados.add(pedidoTotalDTO);
				}
			}
		}
	}

	public void registroPago() {
		try {
			Cuota c = cuotaEJB.buscarCuota(codigoPedido);
			c.setNumeroCuotas(c.getNumeroCuotas() - 1);
			cuotaEJB.editar(c);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se registro el pago", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (EJBTransactionRolledbackException e) {
			Throwable t = e;
			while (!(t.getCause() instanceof SQLException)) {
				t = t.getCause();
				if (t == null) {
					break;
				}
				if (t.getCause() instanceof SQLException) {
					SQLException sql = (SQLException) t.getCause();
					if (sql.getErrorCode() == 20001) {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Este pedido no tiene mas cuotas por pagar", null);
						FacesContext.getCurrentInstance().addMessage(null, message);
					}
				}
			}
		}
	}

	public List<PedidoTotalDTO> getPedidosAprobados() {
		return pedidosAprobados;
	}

	public void setPedidosAprobados(List<PedidoTotalDTO> pedidosAprobados) {
		this.pedidosAprobados = pedidosAprobados;
	}

	public List<PedidoCatalogo> getLista() {
		return lista;
	}

	public void setLista(List<PedidoCatalogo> lista) {
		this.lista = lista;
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
}
