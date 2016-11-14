package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.PromocionEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Promocion;

@Named("promocionWeb")
@ViewScoped
public class ControladorVentanaPromocion implements Serializable {

	@EJB
	private PromocionEJB promocionEJB;

	private int codigo;

	private double descuento;

	public void crear() {
		Promocion p = promocionEJB.buscar(codigo);
		if (codigo != 0 && descuento != 0) {
			if (p == null) {
				Promocion pro = new Promocion(codigo, descuento);
				promocionEJB.crear(pro);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "La promocion ha sido registrada", null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La promocion ya ha sido registrada", null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Llene campos", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void buscar() {
		Promocion p = promocionEJB.buscar(codigo);
		if (p != null) {
			codigo = p.getCodigo();
			descuento = p.getDescuento();
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "La promocion no se ha registrado",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	
}
