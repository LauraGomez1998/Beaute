package co.edu.eam.ingesoft.pa2.beaute.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.beaute.bos.CiudadEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Ciudad;
 
@Named
@FacesConverter(value = "programa", forClass = Ciudad.class)
public class CiudadConverter implements Converter {

	@EJB 
	private CiudadEJB ciudadEJB;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0) {
			System.out.println("222222222222222 " + string);
			return null;
		}
		System.out.println("11111111111111111111 " + string);
		return ciudadEJB.buscar(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof Ciudad) {
			Ciudad ciudad = (Ciudad) arg2;
			System.out.println("33333333333333333333333 " + ciudad.getCodigo());
			return ciudad.getCodigo();
		}
		return null;
	}
}

