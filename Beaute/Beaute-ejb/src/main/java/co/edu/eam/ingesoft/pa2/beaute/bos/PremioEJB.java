package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Premio;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PremioEJB extends EJBGenerico<Premio> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Premio.class;
	}

	public void crear(Premio premio) {
		dao.crear(premio);

	}

	public Premio buscar(Object pk) {
		return dao.buscar(pk);
	}
	
	public List<Premio> listarPremios() {
        return dao.ejecutarNamedQuery(Premio.LISTAR_PREMIOS);
    }

}
