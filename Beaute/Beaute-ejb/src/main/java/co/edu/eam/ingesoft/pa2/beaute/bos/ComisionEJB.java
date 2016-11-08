package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Comision;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class ComisionEJB extends EJBGenerico<Comision>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Comision.class;
	}

	public void crear(Comision comision)  {
		dao.crear(comision);

	}
	
	public Comision buscar(Object pk){
		return dao.buscar(pk);
	}
}
