package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Pedido;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PedidoEJB extends EJBGenerico<Pedido>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Pedido.class;
	}
	
	public void crear(Pedido pedido){
		dao.crear(pedido);

	}
	
	public Pedido buscar(Object pk){
		return dao.buscar(pk);
	}

}
