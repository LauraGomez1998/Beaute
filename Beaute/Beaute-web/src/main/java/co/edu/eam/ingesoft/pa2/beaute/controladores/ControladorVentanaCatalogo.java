package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
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
	
	private List<Catalogo> catalogo;
	

	public void crear() {
		Catalogo c = catalogoEJB.buscar(codigo);
		if (codigo != 0 && fechaVigencia != null && unidades != 0) {
			if (c==null) {
				Catalogo cata = new Catalogo(codigo, fechaVigencia, unidades);
				catalogoEJB.crear(cata);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Se registró catalogo exitosamente", null);
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Ya se encuentra registrado un catalogo", null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Llene campos", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void buscar(){
		if(!catalogo.isEmpty()){
			codigo = catalogo.get(0).getCodigo();
			fechaVigencia =  catalogo.get(0).getFechaVigencia();
			unidades = catalogo.get(0).getUnidades();
			
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"No hay catalogo registrado", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
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

	public List<Catalogo> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Catalogo> catalogo) {
		this.catalogo = catalogo;
	}
	
	

}
