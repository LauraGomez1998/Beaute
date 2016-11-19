package co.edu.eam.ingesoft.pa2.beaute.services.rest;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.beaute.bos.ClienteEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Cliente;
import co.edu.eam.ingesoft.pa2.beaute.seguridad.MD5Util;



/**
 * 
 * @author Jairo Andres
 *
 */
@Path("/login")
public class LoginRest {

	/**
	 * EJB de cliente
	 */
	@EJB
	private ClienteEJB clienteEJB;

	

	/**
	 * servicio rest para verificar usuario
	 * 
	 * @param usuario
	 *            el usuario
	 * @param contrasenia
	 *            la contrasenia del usuairo
	 * @return dto con mensaje de error u objeto
	 */
	@POST
	@Path("/verificar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO login(@FormParam(value = "usuario") String usuario,
			@FormParam(value = "contrasenia") String contrasenia) {
		String contra = MD5Util.code(contrasenia);
		Cliente c = clienteEJB.buscarClienteUsuario(usuario, contra);
		if (c != null) {
//			String token = UUID.randomUUID().toString();
//			tokens.put(token, u.getId());
//			LoginOutDTO obj = new LoginOutDTO(token, usuario, u.getId() + "");
			return new RespuestaDTO(c);
		} else {
			return new RespuestaDTO(null, "Usuario o contraseña incorrectos", "-1");
		}
	}

	

}