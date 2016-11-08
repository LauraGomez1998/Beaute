package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.PremioVenta;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PremioVentaEJB extends EJBGenerico<PremioVenta> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return PremioVenta.class;
	}

	public void crear(PremioVenta premioVenta) {
		dao.crear(premioVenta);

	}

	public PremioVenta buscar(Object pk) {
		return dao.buscar(pk);
	}

}
