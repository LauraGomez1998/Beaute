package co.edu.eam.ingesoft.pa2.beaute.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.beaute.bos.PromocionEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Promocion;

@Named
@FacesConverter(value = "promocion", forClass = Promocion.class)
public class PromocionConverter implements Converter {

@EJB
	private PromocionEJB promocionEJB;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0) {
			return null;
		}
		return promocionEJB.buscar(string);

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof Promocion) {
			Promocion promocion = (Promocion) arg2;
			return promocion.getCodigo();
		}
		return null;
	}

}
