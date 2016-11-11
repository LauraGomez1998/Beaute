package co.edu.eam.ingesoft.pa2.beaute.services.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.beaute.bos.CiudadEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.ClienteEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Ciudad;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Cliente;

@Path("/cliente")
public class ClienteRest {

	@EJB
	private ClienteEJB clienteEjb;
	
	@EJB
	private CiudadEJB ciudadEJB;

	@Path("/crear")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO crear(Cliente cliente) {
		if (clienteEjb.crearCliente(cliente)) {
			return new RespuestaDTO(true, "se registro correctamente", "00");
		} else {
			return new RespuestaDTO(false, "el cliente ya esxisste", "-2");
		}
	}
	
	
	@Path("/buscar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO buscar(@FormParam(value = "cedula") int cedula) {
		Cliente cliente = clienteEjb.buscarCliente(cedula);
		System.out.println(cliente.getApellido() + "holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadddddddd");
		if (cliente != null) {
			return new RespuestaDTO(cliente);
		} else {
			return new RespuestaDTO(null, "este cliente no existe", "-2");
		}
	}

	
	@Path("/eliminar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO eliminar(Cliente cliente) {
		if (clienteEjb.eliminarCliente(cliente)) {
			return new RespuestaDTO(true, "se elimino correctamente", "00");
		} else {
			return new RespuestaDTO(false, "error al eliminar", "-2");
		}
	}
	
	
	
	@Path("/editar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO editar(Cliente cliente) {
		if (clienteEjb.editarCliente(cliente)) {
			return new RespuestaDTO(true, "se edito correctamente", "00");
		} else {
			return new RespuestaDTO(false, "error al editar", "-2");
		}
	}
	
	
	@Path("/listarCiudades")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarCiudades() {
		List<Ciudad> lista = ciudadEJB.listarCiudades();
		if (!lista.isEmpty()) {
			return new RespuestaDTO(lista);
		} else {
			return new RespuestaDTO(false, "error al cargar ciudades", "-2");
		}
	}
}
