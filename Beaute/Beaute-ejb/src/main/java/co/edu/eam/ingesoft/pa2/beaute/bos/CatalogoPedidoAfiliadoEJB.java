package co.edu.eam.ingesoft.pa2.beaute.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoPedidoAfiliado;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class CatalogoPedidoAfiliadoEJB extends EJBGenerico<CatalogoPedidoAfiliado>{

	@Override
	public Class getClase() {
		return CatalogoPedidoAfiliado.class;
	}
	
	
	public void crear(CatalogoPedidoAfiliado pedido){
		dao.crear(pedido);
	}

}
