package co.edu.eam.ingesoft.pa2.beaute.bean;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.omnifaces.util.Faces;

import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.SeguridadEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.seguridad.Acceso;
import co.edu.eam.ingesoft.pa2.beaute.seguridad.MD5Util;
import co.edu.eam.ingesoft.pa2.beaute.seguridad.Rol;

@Named("SesionBean")
@SessionScoped
public class SesionBean implements Serializable {

	@EJB
	private AfiliadoEJB afiliadoEJB;
	@EJB
	private SeguridadEJB seguridadEJB;
	private String usuario;
	private String contrasenia;
	private List<Rol> roles;
	private List<Acceso> accesos;
	private Afiliado afiliado;
	private boolean ocultar;

	@PostConstruct
	public void inicializar() {
		ocultar = false;
	}

	public String login() {
		afiliado = null;
		//contrasenia = MD5Util.code(contrasenia);
		int resultado = afiliadoEJB.login(usuario, contrasenia);
		if (resultado == -1) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El usuario o contraseña son incorrectos", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else if (resultado == 1) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usted se encuentra desafiliado", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			// afiliado = afiliadoEJB.buscar(afiliadoEJB.CEDULAAFILIADO);
			// roles = seguridadEJB.listarRolesPorUsuario(afiliado);
			// accesos = seguridadEJB.listarAccesosPorRol(roles);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se inicio seion con exito", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			ocultar = true;
			return "/paginas/afiliado.jsf?faces-redirect=true";
		}
		roles = null;
		accesos = null;
		Faces.getSession().invalidate();
		return "/login.jsf?faces-redirect=true";
	}

	public boolean isLogged() {
		return this.afiliado != null;
	}

	public String logOut() {
		Faces.getSession().invalidate();
		ocultar = false;
		return "/login.jsf?faces-redirect=true";
	}

	public List<Acceso> getAccesos() {
		return accesos;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean isOcultar() {
		return ocultar;
	}

	public void setOcultar(boolean ocultar) {
		this.ocultar = ocultar;
	}
}
