package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.GeneroAfiliadoEnum;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.NivelAfiliadoEnum;

@Entity
@Table(name = "AFILIADOS")
@NamedQueries({
		@NamedQuery(name = Afiliado.LISTAR_AFILADOS_CIUDAD, query = "select a from Afiliado a where a.ciudad.codigo =?1") })
public class Afiliado implements Serializable {

	public static final String LISTAR_AFILADOS_CIUDAD = "Afiliado.listarAfiliado";

	@Id
	@Column(name = "CEDULA_AFILIADO", length = 50)
	private int cedulaAfiliado;

	@Enumerated(EnumType.STRING)
	@Column(name = "GENERO", length = 10, nullable = false)
	private GeneroAfiliadoEnum genero;

	@ManyToOne()
	@JoinColumn(name = "AFILIADOR", nullable = true)
	private Afiliado afiliador;

	@ManyToOne
	@JoinColumn(name = "CIUDAD", nullable = false)
	private Ciudad ciudad;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_AFILIACION", nullable = false)
	private Date fechaIngreso;

	@Column(name = "TELEFONO", length = 7, nullable = false)
	private int telefono;

	@Column(name = "USUARIO", unique = true, length = 10, nullable = false)
	private String usuario;

	@Column(name = "CONTRASENIA", length = 10, nullable = false)
	private String contrasenia;

	@Column(name = "NOMBRE", length = 50, nullable = false)
	private String nombre;

	@Column(name = "APELLIDO", length = 50, nullable = false)
	private String apellido;

	@Column(name = "ESTADO")
	private boolean estado;

	public Afiliado() {
	}

	public Afiliado(int cedulaAfiliado, GeneroAfiliadoEnum genero, Afiliado afiliador, Ciudad ciudad, Date fechaIngreso,
			int telefono, String usuario, String contrasenia, String nombre, String apellido, boolean estado) {
		super();
		this.cedulaAfiliado = cedulaAfiliado;
		this.genero = genero;
		this.afiliador = afiliador;
		this.ciudad = ciudad;
		this.fechaIngreso = fechaIngreso;
		this.telefono = telefono;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estado = estado;
	}

	public int getCedulaAfiliado() {
		return cedulaAfiliado;
	}

	public void setCedulaAfiliado(int cedulaAfiliado) {
		this.cedulaAfiliado = cedulaAfiliado;
	}

	public GeneroAfiliadoEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroAfiliadoEnum genero) {
		this.genero = genero;
	}

	public Afiliado getAfiliador() {
		return afiliador;
	}

	public void setAfiliador(Afiliado afiliador) {
		this.afiliador = afiliador;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public static String getListarAfiladosCiudad() {
		return LISTAR_AFILADOS_CIUDAD;
	}

}
