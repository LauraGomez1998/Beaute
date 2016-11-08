package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.ProductoPedido;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PedidoProductoEJB extends EJBGenerico<ProductoPedido> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return ProductoPedido.class;
	}
	
	public void crear(ProductoPedido pedidoProducto) {
		dao.crear(pedidoProducto);

	}
	
	public ProductoPedido buscar(Object pk){
		return dao.buscar(pk);
	}

}
