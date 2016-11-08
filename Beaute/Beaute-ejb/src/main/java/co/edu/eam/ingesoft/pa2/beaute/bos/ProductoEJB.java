/**
 * 
 */
package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

/**
 * @author jhoonatan
 *
 */
@Stateless
@LocalBean
public class ProductoEJB extends EJBGenerico<Producto> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Producto.class;
	}

	public void crear(Producto producto) {
		dao.crear(producto);

	}

	public Producto buscar(Object pk) {
		return dao.buscar(pk);
	}

}
