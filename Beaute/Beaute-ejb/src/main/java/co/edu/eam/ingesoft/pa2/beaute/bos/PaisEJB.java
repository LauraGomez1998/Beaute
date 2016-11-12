package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.sql.SQLException;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import co.edu.eam.ingesoft.pa2.beaute.entidades.Pais;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class PaisEJB extends EJBGenerico<Pais> {

	@Override
	public Class getClase() {
		return Pais.class;
	}

	public Pais buscar(Object pk) {
		return dao.buscar(pk);
	}

	public void crear(Pais pais) {
//		try {

			dao.crear(pais);
//		}catch(Exception e){
//			Throwable t=e;
//			System.out.println("EN EL EJB:"+e.getClass()+"-"+e.getMessage());
//			while(t.getCause() instanceof java.sql.SQLException){
//				t=e.getCause();
//				if(t==null){
//					break;
//				}
//			}
		}

}

