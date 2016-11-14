package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoPedidoAfiliado;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class CatalogoPedidoAfiliadoEJB extends EJBGenerico<CatalogoPedidoAfiliado> {

	@Override
	public Class getClase() {
		return CatalogoPedidoAfiliado.class;
	}

	public List<CatalogoPedidoAfiliado> listarCatalogoPedido(int cedulaAfiliado) {
		return dao.ejecutarNamedQuery(CatalogoPedidoAfiliado.LISTAR_PEDIDO_AFILIADO, cedulaAfiliado);
	}

	public CatalogoPedidoAfiliado buscarCatalogoPedido(int codigoPedido, String codigoProducto) {
		List<CatalogoPedidoAfiliado> lista = dao.ejecutarNamedQuery(CatalogoPedidoAfiliado.BUSCAR_PEDIDO_AFILIADO,
				codigoPedido, codigoProducto);
		if (lista.isEmpty()) {
			return null;
		} else {
			return lista.get(0);
		}
	}

	public void crear(CatalogoPedidoAfiliado pedido) {
		dao.crear(pedido);
	}

}
