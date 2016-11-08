package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.CiudadEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.ClienteEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Ciudad;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Cliente;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.GeneroAfiliadoEnum;

@Named("clienteWeb")
@ViewScoped
public class ControladorVentanaCliente implements Serializable {

	@EJB
	private ClienteEJB clienteEJB;

	@EJB
	private CiudadEJB ciudadEJB;

	/**
	 * cedula
	 */
	private int cedula;

	/**
	 * nombre
	 */
	private String nombre;
	/**
	 * Apellido
	 */
	private String apellido;
	/**
	 * genero
	 */
	private GeneroAfiliadoEnum genero;
	/**
	 * ciudad
	 */
	private Ciudad ciudadSeleccionada;
	/**
	 * lista ciudades
	 */
	private List<Ciudad> listaCiudades;
	/**
	 * telefono
	 */
	private int telefono;
	/**
	 * user
	 */
	private String user;
	/**
	 * pass
	 */
	private String pass;
	/**
	 * lista generos
	 */
	private List<GeneroAfiliadoEnum> listaGeneros;

	@PostConstruct
	public void inicializar() {
		listaCiudades = ciudadEJB.listarCiudades();
		listaGeneros = listaGeneros();

	}

	public void crear() {

		Cliente c = clienteEJB.buscar(cedula);
		if (cedula != 0 || nombre != null || apellido != null || telefono != 0 || user != null
				|| pass != null && c == null) {
			Cliente cliente = new Cliente(cedula, nombre, apellido, telefono, user, pass, genero, ciudadSeleccionada);

			clienteEJB.crear(cliente);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró cliente exitosamente",
					null);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Llene campos", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public List<GeneroAfiliadoEnum> listaGeneros() {
		listaGeneros = new ArrayList<>();
		GeneroAfiliadoEnum[] generos = GeneroAfiliadoEnum.values();
		for (int i = 0; i < generos.length; i++) {
			listaGeneros.add(generos[i]);
		}
		return listaGeneros;
	}

	public ClienteEJB getClienteEJB() {
		return clienteEJB;
	}

	public void setClienteEJB(ClienteEJB clienteEJB) {
		this.clienteEJB = clienteEJB;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Ciudad> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(List<Ciudad> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Ciudad getCiudadSeleccionada() {
		return ciudadSeleccionada;
	}

	public void setCiudadSeleccionada(Ciudad ciudadSeleccionada) {
		this.ciudadSeleccionada = ciudadSeleccionada;
	}

	public List<GeneroAfiliadoEnum> getListaGeneros() {
		return listaGeneros;
	}

	public void setListaGeneros(List<GeneroAfiliadoEnum> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}

	public void setGenero(GeneroAfiliadoEnum genero) {
		this.genero = genero;
	}

	public GeneroAfiliadoEnum getGenero() {
		return genero;
	}

}
