package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoPedidoCliente;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoProducto;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Cliente;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Cuota;
import co.edu.eam.ingesoft.pa2.beaute.entidades.PedidoCatalogo;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.TipoPagoEnum;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.beaute.util.ListaProductoPedidoDTO;
import co.edu.eam.ingesoft.pa2.beaute.util.PedidoClienteDTO;

@LocalBean
@Stateless
public class CatalogoPedidoClienteEJB extends EJBGenerico<CatalogoPedidoCliente> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return CatalogoPedidoCliente.class;
	}

	@EJB
	private ClienteEJB clienteEjb;

	@EJB
	private AfiliadoEJB AfiliadoEjb;

	@EJB
	private CatalogoProductoEJB cataProductoEjb;

	@EJB
	private PedidoCatalogoEJB pedidoCatalogoEjb;

	public boolean RealizarPedidoCliente(PedidoClienteDTO dto) {
		if (dto != null) {
			Cliente cliente = clienteEjb.buscar(dto.getCliente());
			Afiliado afiliado = AfiliadoEjb.buscar(dto.getAfiliado());
			PedidoCatalogo pedidoCatalogo;
			if (dto.getCuotas() == 1) {
				pedidoCatalogo = new PedidoCatalogo(afiliado, cliente, GregorianCalendar.getInstance().getTime(),
						TipoPagoEnum.CONTADO);
			} else {
				pedidoCatalogo = new PedidoCatalogo(afiliado, cliente, GregorianCalendar.getInstance().getTime(),
						TipoPagoEnum.CREDITO);
				Cuota cuota = new Cuota(pedidoCatalogo, dto.getCuotas());
			}

			for (ListaProductoPedidoDTO lista : dto.getListaProductoPedidoDTO()) {
				CatalogoProducto catalogo = cataProductoEjb.buscarCatalogoProducto(lista.getCodigo());
				cataProductoEjb.crear(catalogo);
				CatalogoPedidoCliente catalogoCliente = new CatalogoPedidoCliente(catalogo, pedidoCatalogo,
						lista.getCantidad());
				crear(catalogoCliente);
			}
			return true;
		} else {
			return false;
		}
	}

	public void crear(CatalogoPedidoCliente catalogoCliente) {
		dao.crear(catalogoCliente);
	}

}
