package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.PedidoCatalogo;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PedidoCatalogoEJB extends EJBGenerico<PedidoCatalogo> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return PedidoCatalogo.class;
	}

	public void crear(PedidoCatalogo catalogo){
		dao.crear(catalogo);

	}
	
	public PedidoCatalogo buscar(Object pk){
		return dao.buscar(pk);
	}
}
