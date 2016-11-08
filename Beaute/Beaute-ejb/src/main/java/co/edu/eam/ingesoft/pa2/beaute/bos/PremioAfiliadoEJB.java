package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.PremioAfiliado;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PremioAfiliadoEJB extends EJBGenerico<PremioAfiliado> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return PremioAfiliado.class;
	}
	
	public void crear(PremioAfiliado premioAfiliado){
		dao.crear(premioAfiliado);

	}
	
	public PremioAfiliado buscar(Object pk){
		return dao.buscar(pk);
	}

}
