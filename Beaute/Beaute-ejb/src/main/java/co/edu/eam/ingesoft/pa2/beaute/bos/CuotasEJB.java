package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Cuota;
import co.edu.eam.ingesoft.pa2.beaute.entidades.PedidoCatalogo;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class CuotasEJB extends EJBGenerico<Cuota> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Cuota.class;
	}

	public void crear(Cuota cuota) {
		dao.crear(cuota);
	}

	public Cuota buscarCuotaPedido(PedidoCatalogo pedido) {
		List<Cuota> cuotas = dao.ejecutarNamedQuery(Cuota.LISTAR_CUOTAS, pedido);
		if (cuotas.isEmpty()) {
			return null;
		} else {
			return cuotas.get(0);
		}
	}

}
