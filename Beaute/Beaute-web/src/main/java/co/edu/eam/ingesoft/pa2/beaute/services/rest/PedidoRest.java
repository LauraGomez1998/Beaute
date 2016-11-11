package co.edu.eam.ingesoft.pa2.beaute.services.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoPedidoClienteEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoProductoEJB;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;
import co.edu.eam.ingesoft.pa2.beaute.util.PedidoClienteDTO;

@Path("/pedido")
public class PedidoRest {

	
	

	
	@EJB
	CatalogoProductoEJB catalogoProductoEJb;
	
	@EJB
	private CatalogoPedidoClienteEJB catapedEjb;

	public PedidoRest() {
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
	
	@Path("/realizarPedido")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO realizarPedido(PedidoClienteDTO dto) {

		if (catapedEjb.RealizarPedidoCliente(dto)) {
			return new RespuestaDTO(true, "Se ha realizado el pedido correctamente", "00");
		} else {
			return new RespuestaDTO(false, "error al hacer el pedido", "-2");
		}

	}
	
	
	
	
	@Path("/listarProductosCatalogo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO listarProductosCatalogo(@FormParam(value = "categoria") CategoriaProductoEnum categoria) {
     System.out.println("jajajajihrighrigjrigrigjrijgrijijiiiiiiiiiiiiiiiiiiiiiiiii");
		
		List<Producto> lista = catalogoProductoEJb.listarProductosCatalogo(categoria);
		if (!lista.isEmpty()) {
			return new RespuestaDTO(lista);
		} else {
			return new RespuestaDTO(null, "No hay prodcutos con esa categoria", "-2");
		}

	}

}