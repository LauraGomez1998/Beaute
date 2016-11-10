package co.edu.eam.ingesoft.pa2.beaute.bos;

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

	

}
