package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Venta;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class VentaEJB extends EJBGenerico<Venta> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Venta.class;
	}

	public void crear(Venta venta) {
		dao.crear(venta);

	}

	public Venta buscar(Object pk) {
		return dao.buscar(pk);
	}
	
	public int autoIncrementar(){
		return dao.ejecutarNamedQuery(Venta.TAMANIO).size();
	}

	
}
