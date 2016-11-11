package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.util.List;

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

	public List<AfiliadoPremio> listarPremios(int cedulaAfiliado) {
		return dao.ejecutarNamedQuery(AfiliadoPremio.LISTAR_PREMIO_AFILIADO, cedulaAfiliado);
	}

	public void crear(AfiliadoPremio afiliadoPremio) {
		dao.crear(afiliadoPremio);
	}

}
