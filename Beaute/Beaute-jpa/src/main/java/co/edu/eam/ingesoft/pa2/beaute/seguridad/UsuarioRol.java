package co.edu.eam.ingesoft.pa2.beaute.seguridad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;

@Entity
@IdClass(value = UsuarioRolPK.class)
@Table(name = "USUARIOS_ROLES")
@NamedQueries({
		@NamedQuery(name = UsuarioRol.LISTAR_ROL_USUARIO, query = "select uR.rol from UsuarioRol uR where uR.usuario=?1") })
public class UsuarioRol implements Serializable {

	public static final String LISTAR_ROL_USUARIO = "usuarioRol.listar";

	@Id
	@ManyToOne
	@JoinColumn(name = "USUARIO")
	private Afiliado usuario;

	@Id
	@ManyToOne
	@JoinColumn(name = "ROL")
	private Rol rol;

	public UsuarioRol() {
		super();
	}

	public UsuarioRol(Afiliado usuario, Rol rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public Afiliado getUsuario() {
		return usuario;
	}

	public void setUsuario(Afiliado usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
