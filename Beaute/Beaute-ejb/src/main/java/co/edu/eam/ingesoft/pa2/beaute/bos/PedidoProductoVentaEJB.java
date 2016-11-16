package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.VentaProductoPedido;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PedidoProductoVentaEJB extends EJBGenerico<VentaProductoPedido> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return VentaProductoPedido.class;
	}

	public void crear(VentaProductoPedido pedidoProductoVenta) {
		dao.crear(pedidoProductoVenta);

	}

	public VentaProductoPedido buscar(Object pk) {
		return dao.buscar(pk);
	}

}
