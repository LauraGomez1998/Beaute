package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Promocion;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PromocionEJB extends EJBGenerico<Promocion> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Promocion.class;
	}

	public void crear(Promocion pro) {
		dao.crear(pro);
	}

	public Promocion buscar(Object pk) {

		return dao.buscar(pk);
	}
}
