package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.PaisEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Pais;

@Named("paisWeb")
@ViewScoped
public class ControladorPais implements Serializable {

	@EJB
	private PaisEJB paisEJB;

	public void crear() {
		try {
			Pais pais = new Pais(1, "Colombia");
			paisEJB.crear(pais);
		} catch (Exception e) {
			System.out.println("excepcion:"+e.getClass());
			e.printStackTrace();
		}
	}

}
