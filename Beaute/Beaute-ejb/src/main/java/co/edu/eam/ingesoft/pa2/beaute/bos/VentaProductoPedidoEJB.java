package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.VentaProductoPedido;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class VentaProductoPedidoEJB extends EJBGenerico<VentaProductoPedido> {

	@Override
	public Class getClase() {
		return VentaProductoPedido.class;
	}

	public void crear(VentaProductoPedido venta) {
		dao.crear(venta);
	}

	public int autoIncremental() {
		return dao.ejecutarNamedQuery(VentaProductoPedido.TAMANIO).size();
	}

	public List<VentaProductoPedido> listarVentas(int cedulaAfiliado) {
		return dao.ejecutarNamedQuery(VentaProductoPedido.LISTAR_VENTAS, cedulaAfiliado);
	}
}
