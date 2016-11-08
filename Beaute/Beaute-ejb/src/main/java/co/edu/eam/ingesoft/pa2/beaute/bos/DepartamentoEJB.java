package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;
import java.util.List;



import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Departamento;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class DepartamentoEJB extends EJBGenerico<Departamento>{

	@Override
	public Class getClase() {
		return Departamento.class;
	}

	public Departamento buscar(Object pk) {
		return dao.buscar(pk);
	}

	public void crear(Departamento departamento) {
		dao.crear(departamento);
	}
}
