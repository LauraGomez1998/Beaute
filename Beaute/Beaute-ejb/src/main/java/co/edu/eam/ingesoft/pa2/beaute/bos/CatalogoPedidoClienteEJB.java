package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.dto.ProductoDTO;
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
	private CuotasEJB cuotaEjb;

	@EJB
	private CatalogoProductoEJB cataProductoEjb;

	@EJB
	private PedidoCatalogoEJB pedidoCatalogoEjb;

	private List<ListaProductoPedidoDTO> listaProductoPedido;

	public boolean RealizarPedidoCliente(PedidoClienteDTO dto) {
		listaProductoPedido =  new ArrayList<>();
		
		for (ListaProductoPedidoDTO lista : dto.getListaProductoPedidoDTO()) {

			if (lista != null && lista.getCantidad() > 0) {
				if (listaProductoPedido.isEmpty()) {
					ListaProductoPedidoDTO productoAgregar = new ListaProductoPedidoDTO(lista.getCodigo(),
							lista.getCantidad());
					listaProductoPedido.add(productoAgregar);
				} else {
					boolean encontro = false;
					for (int i = 0; i < listaProductoPedido.size(); i++) {
						if (listaProductoPedido.get(i).getCodigo().equalsIgnoreCase(lista.getCodigo())) {
							int cant = listaProductoPedido.get(i).getCantidad();
							listaProductoPedido.get(i).setCantidad(cant + lista.getCantidad());
							encontro = true;
						}
					}
					if (!encontro) {
						ListaProductoPedidoDTO productoAgregar = new ListaProductoPedidoDTO(lista.getCodigo(),
								lista.getCantidad());
						listaProductoPedido.add(productoAgregar);
					}
				}
			}
		}

		if (dto != null) {
			Cliente cliente = clienteEjb.buscar(dto.getCliente());
			Afiliado afiliado = AfiliadoEjb.buscar(dto.getAfiliado());
			PedidoCatalogo pedidoCatalogo;
			if (dto.getCuotas() == 1) {
				pedidoCatalogo = new PedidoCatalogo(afiliado, cliente, GregorianCalendar.getInstance().getTime(),
						TipoPagoEnum.CONTADO);
				pedidoCatalogoEjb.crear(pedidoCatalogo);
			} else {
				pedidoCatalogo = new PedidoCatalogo(afiliado, cliente, GregorianCalendar.getInstance().getTime(),
						TipoPagoEnum.CREDITO);
				pedidoCatalogoEjb.crear(pedidoCatalogo);
				Cuota cuota = new Cuota(pedidoCatalogo, dto.getCuotas());
				cuotaEjb.crear(cuota);
			}

			for (ListaProductoPedidoDTO lista : listaProductoPedido) {
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
