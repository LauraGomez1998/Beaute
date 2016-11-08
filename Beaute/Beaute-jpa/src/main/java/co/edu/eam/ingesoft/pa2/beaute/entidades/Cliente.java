package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.GeneroAfiliadoEnum;

@Entity
@Table(name = "CLIENTES")
public class Cliente implements Serializable {

	@Id
	@Column(name = "CEDULA", length = 30)
	private int cedula;

	@Column(name = "NOMBRE", length = 50, nullable = false)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "CIUDAD", nullable = false)
	private Ciudad ciudad;

	@Column(name = "APELLIDO", length = 50, nullable = false)
	private String apellido;

	@Column(name = "TELEFONO", length = 7, nullable = true)
	private int telefono;

	@Column(name = "USUARIO", unique = true, length = 10, nullable = false)
	private String usuario;

	@Column(name = "CONTRASENIA", length = 10, nullable = false)
	private String contrasenia;

	@Enumerated(EnumType.STRING)
	@Column(name = "GENERO", length = 10, nullable = false)
	private GeneroAfiliadoEnum genero;

	public Cliente() {
	}

	public Cliente(int cedula, String nombre, String apellido, int telefono, String usuario, String contrasenia,
			GeneroAfiliadoEnum genero, Ciudad ciudad) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.genero = genero;
		this.ciudad=ciudad;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
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

	public GeneroAfiliadoEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroAfiliadoEnum genero) {
		this.genero = genero;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}
