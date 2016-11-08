package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.HistorialAfiliado;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class HistorialAfiliadoEJB extends EJBGenerico<HistorialAfiliado>{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return HistorialAfiliado.class;
	}

	public void crear(HistorialAfiliado historialAfiliado) {
		dao.crear(historialAfiliado);

	}
	
	public HistorialAfiliado buscar(Object pk){
		return dao.buscar(pk);
	}
}
