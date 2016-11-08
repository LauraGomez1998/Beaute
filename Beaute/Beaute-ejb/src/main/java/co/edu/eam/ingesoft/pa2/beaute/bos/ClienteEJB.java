package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;


import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Cliente;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class ClienteEJB extends EJBGenerico<Cliente> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Cliente.class;
	}

	public void crear(Cliente cliente)  {
		dao.crear(cliente);
	}

	public Cliente buscar(Object pk) {
		return dao.buscar(pk);
	}

}
