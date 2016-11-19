package co.edu.eam.ingesoft.pa2.beaute.services.rest;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoPedidoAfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PedidoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PromocionEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;
import co.edu.eam.ingesoft.pa2.beaute.seguridad.MD5Util;
import co.edu.eam.ingesoft.pa2.beaute.util.PedidoDTO;

@Path("/pedidoAndroid")
public class PedidoAndroidRest {

	@EJB
	private PromocionEJB pedidoEjb;

	@EJB
	private AfiliadoEJB afiliadoEjb;

	@EJB
	CatalogoPedidoAfiliadoEJB catalogoPedidoAfiliadoEjb;

	@EJB
	CatalogoProductoEJB catalogoProductoEJb;

	public PedidoAndroidRest() {
		// TODO Auto-generated constructor stub
	}

	@Path("/loginAndroid")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public int loginAndroid(@FormParam(value = "usuario") String usuario,
			@FormParam(value = "contrasenia") String contrasenia) {
		String contra = MD5Util.code(contrasenia);
		Afiliado afiliado = afiliadoEjb.loginAfiliado(usuario, contra).get(0);
		if (afiliado != null) {
			return afiliado.getCedulaAfiliado();
		} else {
			return 0;
		}

	}

	@Path("/realizarPedido")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean realizarPedido(PedidoDTO dto) {
		System.out.println("entro aquiippppppppppppppppp");
		if (catalogoPedidoAfiliadoEjb.pedir(dto)) {
			return true;
		} else {
			return false;
		}

	}

	@Path("/listarProductosCatalogo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<Producto> listarProductosCatalogo(@FormParam(value = "categoria") CategoriaProductoEnum categoria) {
		List<Producto> lista = catalogoProductoEJb.listarProductosCatalogo(categoria);
		if (!lista.isEmpty()) {
			return lista;
		} else {
			return null;
		}

	}

}