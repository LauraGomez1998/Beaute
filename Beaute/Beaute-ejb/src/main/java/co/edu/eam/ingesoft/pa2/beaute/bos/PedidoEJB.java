package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.dto.PedidoAfiliadoDTO;
import co.edu.eam.ingesoft.pa2.beaute.dto.ProductoDTO;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoPedidoAfiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoProducto;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Pedido;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PedidoEJB extends EJBGenerico<Pedido> {

	@EJB
	private AfiliadoEJB afiliadoEJB;

	@EJB
	private CatalogoPedidoAfiliadoEJB catalogoPedido;

	@EJB
	private CatalogoProductoEJB catalogoProductoEJB;

	@Override
	public Class getClase() {
		return Pedido.class;
	}

	public int autoIncremental() {
		return dao.ejecutarNamedQuery(Pedido.TAMANIO).size();
	}

	/**
	 * metodo que crea el pedido del afiliado
	 * 
	 * @param pedidoAfiliado
	 *            dto con datos necesarios para realizar el pedido
	 */
	public void crearPedido(PedidoAfiliadoDTO pedidoAfiliado) {
		int codP = autoIncremental();
		Afiliado afiliado = afiliadoEJB.buscar(pedidoAfiliado.getCedulaAfiliado());
		Pedido pedido = new Pedido(codP, afiliado, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
		crear(pedido);
		for (int i = 0; i < pedidoAfiliado.getProductosPedidos().size(); i++) {
			CatalogoProducto catalogoP = catalogoProductoEJB
					.buscarCatalogoProducto(pedidoAfiliado.getProductosPedidos().get(i).getProducto().getCodigo());
			int cantidad = pedidoAfiliado.getProductosPedidos().get(i).getCantidad();
			CatalogoPedidoAfiliado pedidoAfi = new CatalogoPedidoAfiliado(catalogoP, pedido, cantidad);
			catalogoPedido.crear(pedidoAfi);
		}
	}

	/**
	 * metodo que crea el pedido del afiliado cuando esta a sido aprobado
	 * 
	 * @param productos
	 *            la lista de productos pedidos
	 * @param cedAfiliado
	 *            la cedula del afiliado
	 */
	public void crearPedidoCliente(List<ProductoDTO> productos, int cedAfiliado) {
		Afiliado afiliado = afiliadoEJB.buscar(cedAfiliado);
		int codP = autoIncremental();
		Pedido pedido = new Pedido(codP, afiliado, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
		crear(pedido);
		for (int i = 0; i < productos.size(); i++) {
			CatalogoProducto catalogoP = catalogoProductoEJB
					.buscarCatalogoProducto(productos.get(i).getProducto().getCodigo());
			int cantidad = productos.get(i).getCantidad();
			CatalogoPedidoAfiliado pedidoAfi = new CatalogoPedidoAfiliado(catalogoP, pedido, cantidad);
			catalogoPedido.crear(pedidoAfi);
		}
	}

	public void crear(Pedido pedido) {
		dao.crear(pedido);
	}

	public Pedido buscar(Object pk) {
		return dao.buscar(pk);
	}

}
