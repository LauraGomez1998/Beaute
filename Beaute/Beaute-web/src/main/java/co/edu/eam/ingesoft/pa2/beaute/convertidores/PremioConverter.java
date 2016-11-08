package co.edu.eam.ingesoft.pa2.beaute.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.beaute.bos.PremioEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Premio;

@Named
@FacesConverter(value = "premio", forClass = Premio.class)
public class PremioConverter implements Converter {

	@EJB
	private PremioEJB premioEJB;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0) {
			return null;
		}
		return premioEJB.buscar(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof Premio) {
			Premio premio = (Premio) arg2;
			return premio.getCodigo();
		}
		return null;
	}
}
