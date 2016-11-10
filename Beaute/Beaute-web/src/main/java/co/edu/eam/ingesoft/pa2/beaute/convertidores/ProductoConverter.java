package co.edu.eam.ingesoft.pa2.beaute.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.beaute.bos.ProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;

@Named
@FacesConverter(value = "producto", forClass = Producto.class)
public class ProductoConverter implements Converter {

	@EJB
	private ProductoEJB productoEJB;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0) {
			return null;
		}
		return productoEJB.buscar(string);

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof Producto) {
			Producto producto = (Producto) arg2;
			return producto.getCodigo();
		}
		return null;
	}

}
