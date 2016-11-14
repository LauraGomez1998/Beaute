package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Catalogo;

@Named("catalogoWeb")
@ViewScoped
public class ControladorVentanaCatalogo implements Serializable {

	@EJB
	private CatalogoEJB catalogoEJB;

	private int codigo;

	private Date fechaVigencia;

	private int unidades;

	private Catalogo catalogo;

	public void crear() {

		if (codigo != 0 && fechaVigencia != null && unidades != 0) {
			catalogo = catalogoEJB.buscarUltimoCatalogo();
			Date fechaActual = Calendar.getInstance().getTime();
			if (catalogo != null) {
				Date fechaVigenciaCatalogoAnterior = catalogo.getFechaVigencia();

				if (fechaVigenciaCatalogoAnterior.before(fechaActual) && fechaActual.before(fechaVigencia)) {
					Catalogo cata = new Catalogo(codigo, fechaVigencia, unidades);
					catalogoEJB.crear(cata);
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Se registró catalogo exitosamente", null);
					FacesContext.getCurrentInstance().addMessage(null, message);
				} else {
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fechas inconsitentes", null);
					FacesContext.getCurrentInstance().addMessage(null, message);

				}
			} else {
				if (fechaActual.before(fechaVigencia)) {
					Catalogo cata = new Catalogo(codigo, fechaVigencia, unidades);
					catalogoEJB.crear(cata);
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Se registró catalogo exitosamente", null);
					FacesContext.getCurrentInstance().addMessage(null, message);
				} else {
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fechas inconsitentes", null);
					FacesContext.getCurrentInstance().addMessage(null, message);
				}

			}
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Llene campos", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void buscar() {
		catalogo = catalogoEJB.buscar(codigo);
		if (catalogo != null) {
			codigo = catalogo.getCodigo();
			fechaVigencia = catalogo.getFechaVigencia();
			unidades = catalogo.getUnidades();

		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No hay catalogo registrado", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void editar(){
		catalogo = catalogoEJB.buscarUltimoCatalogo();
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

}
