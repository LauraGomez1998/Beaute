package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Ciudad;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class CiudadEJB extends EJBGenerico<Ciudad> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Ciudad.class;
	}

	public Ciudad buscar(Object pk) {
		return dao.buscar(pk);
	}

	public void crear(Ciudad ciudad)  {
		dao.crear(ciudad);
	}

	public List<Ciudad> listarCiudades() {
		return dao.ejecutarNamedQuery(Ciudad.LISTAR_CIUDADES);
	}

}
