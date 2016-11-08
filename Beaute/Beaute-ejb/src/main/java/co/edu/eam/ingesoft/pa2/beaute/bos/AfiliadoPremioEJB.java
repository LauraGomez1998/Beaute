package co.edu.eam.ingesoft.pa2.beaute.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.AfiliadoPremio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@LocalBean
@Stateless
public class AfiliadoPremioEJB extends EJBGenerico<AfiliadoPremio> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return AfiliadoPremio.class;
	}

	public void crear(AfiliadoPremio afiliadoPremio) {
		dao.crear(afiliadoPremio);
	}

}
