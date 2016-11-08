package co.edu.eam.ingesoft.pa2.beaute.bos;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@LocalBean
@Stateless
public class AfiliadoEJB extends EJBGenerico<Afiliado> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Afiliado.class;
	}

	public void crear(Afiliado afiliado) {
		dao.crear(afiliado);

	}

	public Afiliado buscar(Object pk) {
		return dao.buscar(pk);
	}

}
