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
	private String usuario;
	private String contrasenia;
	private boolean ocultar;
	private boolean afiliadoUser;
	private boolean adminUser;

	@PostConstruct
	public void inicializar() {
		ocultar = false;
		afiliadoUser = false;
		adminUser = false;
	}

	public String login() {
		 contrasenia = MD5Util.code(contrasenia);
		int resultado = afiliadoEJB.login(usuario, contrasenia);
		if (resultado == -1) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El usuario o contraseña son incorrectos", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else if (resultado == 1) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usted se encuentra desafiliado", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			if (afiliadoEJB.CEDULAAFILIADO == -1) {
				adminUser = true;
			} else {
				afiliadoUser = true;
			}
			ocultar = true;
			return "/paginas/afiliado.jsf?faces-redirect=true";
		}
		Faces.getSession().invalidate();
		return "/login.jsf?faces-redirect=true";
	}

	public String logOut() {
		ocultar = false;
		afiliadoUser = false;
		adminUser = false;
		return "/paginas/login.jsf?faces-redirect=true";
	}

	public String reporte() {
		return "/reporteAfiliados";
	}

	public String getContrasenia() {
		return contrasenia;
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

	public boolean isAdminUser() {
		return adminUser;
	}

	public boolean isAfiliadoUser() {
		return afiliadoUser;
	}

	public void setAfiliadoUser(boolean afiliadoUser) {
		this.afiliadoUser = afiliadoUser;
	}

	public void setAdminUser(boolean adminUser) {
		this.adminUser = adminUser;
	}
}
