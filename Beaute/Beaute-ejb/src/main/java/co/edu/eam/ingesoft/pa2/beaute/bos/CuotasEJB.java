package co.edu.eam.ingesoft.pa2.beaute.bos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Cuota;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class CuotasEJB extends  EJBGenerico<Cuota> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Cuota.class;
	}
	
	
	public void crear(Cuota cuota){
		dao.crear(cuota);
	}
	
	

}
