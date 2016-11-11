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

	public boolean crearCliente(Cliente cliente) {
		if (cliente != null) {
			dao.crear(cliente);
			return true;
		} else {
			return false;
		}
	}

	public Cliente buscarCliente(Object pk) {
	Cliente c = dao.buscar(pk);
	if(c!=null){
		return c;
	}else{
		return null;
	}

	}

	public boolean eliminarCliente(Cliente cliente) {
		if (cliente != null) {
			dao.eliminar(cliente);
			return true;
		} else {
			return false;
		}
	}

	public boolean editarCliente(Cliente cliente) {
		if (cliente != null) {
			dao.editar(cliente);
			return true;
		} else {
			return false;
		}
	}

}
