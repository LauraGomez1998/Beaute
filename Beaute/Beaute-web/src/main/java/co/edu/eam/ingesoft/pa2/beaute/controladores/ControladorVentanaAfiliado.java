package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CiudadEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.DepartamentoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PaisEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Ciudad;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Departamento;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Pais;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.GeneroAfiliadoEnum;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;

@Named("afiliadoaWeb")
@ViewScoped
public class ControladorVentanaAfiliado implements Serializable {
	/**
	 * EJB de la clase afiliado
	 */
	@EJB
	private AfiliadoEJB afiliadoEJB;
	/**
	 * EJB de la clase Ciudad
	 */
	@EJB
	private CiudadEJB ciudadEJB;
	/**
	 * cedula del afiliador
	 */
	private int cedulaAfiliador;
	/**
	 * genero del afiliado
	 */
	private GeneroAfiliadoEnum genero;
	/**
	 * cedula del afiliado
	 */
	private int cedulaAfiliado;
	/**
	 * ciudad del afiliado
	 */
	private Ciudad ciudadSeleccionada;
	/**
	 * telefono del afiliado
	 */
	private int telefono;
	/**
	 * usuario del afiliado
	 */
	private String usuario;
	/**
	 * contrasenia del afiliado
	 */
	private String contrasenia;
	/**
	 * nombre del afiliado
	 */
	private String nombre;
	/**
	 * apellido del afiliado
	 */
	private String apellido;
	/**
	 * lista de ciudades
	 */
	private List<Ciudad> listaCiudades;
	/**
	 * lista de generos
	 */
	private List<GeneroAfiliadoEnum> listaGeneros;

	/**
	 * constructor vacio
	 */
	public ControladorVentanaAfiliado() {
	}

	/**
	 * metodo de inicializar
	 */
	@PostConstruct
	public void inicializar() {
		listaCiudades = ciudadEJB.listarCiudades();
		listarGenero();
	}

	/**
	 * metodo que lista los generos
	 */
	public void listarGenero() {
		listaGeneros = new ArrayList<>();
		GeneroAfiliadoEnum[] generos = GeneroAfiliadoEnum.values();
		for (int i = 0; i < generos.length; i++) {
			listaGeneros.add(generos[i]);
		}
	}

	/**
	 * metodo para registrar un afiliado
	 */
	public void registrarAfiliado() {
		Afiliado afiliador = afiliadoEJB.buscar(cedulaAfiliador);
		Afiliado afiliado = new Afiliado();
		if (afiliador == null) {
			afiliado = new Afiliado(cedulaAfiliado, genero, null, ciudadSeleccionada, Calendar.getInstance().getTime(),
					telefono, usuario, contrasenia, nombre, apellido, true);
		} else {
			afiliado = new Afiliado(cedulaAfiliado, genero, afiliador, ciudadSeleccionada,
					Calendar.getInstance().getTime(), telefono, usuario, contrasenia, nombre, apellido, true);
		}
		afiliadoEJB.crear(afiliado);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El afiliado ha sido registrado", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * metodo que busca un afiliado
	 */
	public void buscarAfiliado() {
		Afiliado afiliado = afiliadoEJB.buscar(cedulaAfiliado);
		if (afiliado != null) {
			cedulaAfiliado = afiliado.getCedulaAfiliado();
			genero = afiliado.getGenero();
			if (afiliado.getAfiliador() != null) {
				cedulaAfiliador = afiliado.getAfiliador().getCedulaAfiliado();
			}
			ciudadSeleccionada = afiliado.getCiudad();
			telefono = afiliado.getTelefono();
			usuario = afiliado.getUsuario();
			nombre = afiliado.getNombre();
			apellido = afiliado.getApellido();
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se ha encontrado el afiliado",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	/**
	 * metodo para editar un afiliado
	 */
	public void editar() {
		Afiliado afiliado = afiliadoEJB.buscar(cedulaAfiliado);
		if (afiliado != null) {
			Afiliado afiliadoEditar = new Afiliado();
			afiliadoEditar.setCedulaAfiliado(afiliado.getCedulaAfiliado());
			afiliadoEditar.setGenero(genero);
			afiliadoEditar.setAfiliador(afiliado.getAfiliador());
			afiliadoEditar.setCiudad(ciudadSeleccionada);
			afiliadoEditar.setTelefono(telefono);
			afiliadoEditar.setUsuario(afiliadoEditar.getUsuario());
			afiliadoEditar.setContrasenia(contrasenia);
			afiliadoEditar.setNombre(nombre);
			afiliadoEditar.setApellido(apellido);
			afiliadoEditar.setFechaIngreso(afiliado.getFechaIngreso());
			afiliadoEJB.editar(afiliadoEditar);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El afiliado ha sido editado", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se ha encontrado el afiliado",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * accesores y modificadores
	 * 
	 */
	public int getCedulaAfiliador() {
		return cedulaAfiliador;
	}

	public void setCedulaAfiliador(int cedulaAfiliador) {
		this.cedulaAfiliador = cedulaAfiliador;
	}

	public GeneroAfiliadoEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroAfiliadoEnum genero) {
		this.genero = genero;
	}

	public int getCedulaAfiliado() {
		return cedulaAfiliado;
	}

	public void setCedulaAfiliado(int cedulaAfiliado) {
		this.cedulaAfiliado = cedulaAfiliado;
	}

	public Ciudad getCiudadSeleccionada() {
		return ciudadSeleccionada;
	}

	public void setCiudadSeleccionada(Ciudad ciudadSeleccionada) {
		this.ciudadSeleccionada = ciudadSeleccionada;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<GeneroAfiliadoEnum> getListaGeneros() {
		return listaGeneros;
	}

	public void setListageneros(List<GeneroAfiliadoEnum> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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

}
