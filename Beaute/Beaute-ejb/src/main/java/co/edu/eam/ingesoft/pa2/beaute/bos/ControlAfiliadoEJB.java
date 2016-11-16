package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.ControlAfiliado;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class ControlAfiliadoEJB extends EJBGenerico<ControlAfiliado> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return ControlAfiliado.class;
	}

	public void crear(ControlAfiliado controlAfiliado) {
		dao.crear(controlAfiliado);

	}

	public ControlAfiliado buscar(Object pk) {
		return dao.buscar(pk);
	}

}
