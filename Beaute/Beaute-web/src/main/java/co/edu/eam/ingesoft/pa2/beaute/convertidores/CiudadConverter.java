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
@FacesConverter(value = "ciudad", forClass = Ciudad.class)
public class CiudadConverter implements Converter {

	@EJB
	private CiudadEJB ciudadEJB;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0) {
			return null;
		}
		return ciudadEJB.buscar(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof Ciudad) {
			Ciudad ciudad = (Ciudad) arg2;
			return ciudad.getCodigo();
		}
		return null;
	}
}
