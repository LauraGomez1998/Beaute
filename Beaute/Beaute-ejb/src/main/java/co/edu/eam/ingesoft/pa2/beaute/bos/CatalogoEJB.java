package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Catalogo;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class CatalogoEJB extends EJBGenerico<Catalogo> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Catalogo.class;
	}

	public Catalogo buscarUltimoCatalogo() {

		List<Catalogo> lista = dao.ejecutarNamedQuery(Catalogo.LISTAR_CATALOGO);
		if (!lista.isEmpty()) {
			return lista.get(0);
		} else {
			return null;
		}
	}

	public Catalogo buscar(Object pk) {
		return dao.buscar(pk);
	}

	public void crear(Catalogo c) {
		dao.crear(c);
	}

}
