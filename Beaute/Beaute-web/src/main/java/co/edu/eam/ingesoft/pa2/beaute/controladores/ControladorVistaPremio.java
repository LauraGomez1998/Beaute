package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoPremioEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.AfiliadoPremio;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Premio;

@Named("vistaPremiosWeb")
@ViewScoped
public class ControladorVistaPremio implements Serializable {
	/**
	 * EJB de la clase premio afiliado
	 */
	@EJB
	private AfiliadoPremioEJB premioAfiliadoEJB;
	/**
	 * lista de premios de un afiliado
	 */
	private List<AfiliadoPremio> listaPremios;

	/**
	 * metodo que inicializa la lista de premios
	 */
	@PostConstruct
	public void iniciar() {
		listaPremios = new ArrayList<>();
		//corregir dato quemado
		listaPremios = premioAfiliadoEJB.listarPremios(123);
	}

	/**
	 * accesores y modificadores
	 */
	public List<AfiliadoPremio> getListaPremios() {
		return listaPremios;
	}

	public void setListaPremios(List<AfiliadoPremio> listaPremios) {
		this.listaPremios = listaPremios;
	}

}
