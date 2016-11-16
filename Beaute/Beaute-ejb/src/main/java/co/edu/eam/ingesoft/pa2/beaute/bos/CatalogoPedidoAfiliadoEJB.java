package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoPedidoAfiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoProducto;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Pedido;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;
import co.edu.eam.ingesoft.pa2.beaute.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.beaute.util.ListaProductoPedidoDTO;
import co.edu.eam.ingesoft.pa2.beaute.util.PedidoDTO;

@Stateless
@LocalBean
public class CatalogoPedidoAfiliadoEJB extends EJBGenerico<CatalogoPedidoAfiliado> {

	@Override
	public Class getClase() {
		return CatalogoPedidoAfiliado.class;
	}

	public List<CatalogoPedidoAfiliado> listarCatalogoPedido(int cedulaAfiliado) {
		return dao.ejecutarNamedQuery(CatalogoPedidoAfiliado.LISTAR_PEDIDO_AFILIADO, cedulaAfiliado);
	}

	public CatalogoPedidoAfiliado buscarCatalogoPedido(int codigoPedido, String codigoProducto) {
		List<CatalogoPedidoAfiliado> lista = dao.ejecutarNamedQuery(CatalogoPedidoAfiliado.BUSCAR_PEDIDO_AFILIADO,
				codigoPedido, codigoProducto);
		if (lista.isEmpty()) {
			return null;
		} else {
			return lista.get(0);
		}
	}

	public void crear(CatalogoPedidoAfiliado pedido) {
		dao.crear(pedido);
	}
	
	
	
	
	
	///// androooooooooooooooooid
	
	
	
	
	
	
	
	
	@EJB
	private PedidoEJB pedidoEJb;

	@EJB
	private AfiliadoEJB afiliadoEJb;

	@EJB
	private CatalogoProductoEJB cataProductoEJb;

	
	private List<ListaProductoPedidoDTO> listaProductoPedido;
	
	/**
	 * Androiiiiiiddd
	 * @param dto
	 * @return
	 * @throws ExcepcionNegocio
	 */
	public boolean pedir(PedidoDTO dto) throws ExcepcionNegocio {
		
		
//		listaProductoPedido = new ArrayList<>();
//
//		for (ListaProductoPedidoDTO lista : dto.getListaProductoPedidoDTO()) {
//
//			if (lista != null && lista.getCantidad() > 0) {
//				if (listaProductoPedido.isEmpty()) {
//					ListaProductoPedidoDTO productoAgregar = new ListaProductoPedidoDTO(lista.getCodigo(),
//							lista.getCantidad());
//					listaProductoPedido.add(productoAgregar);
//				} else {
//					boolean encontro = false;
//					for (int i = 0; i < listaProductoPedido.size(); i++) {
//						if (listaProductoPedido.get(i).getCodigo().equalsIgnoreCase(lista.getCodigo())) {
//							int cant = listaProductoPedido.get(i).getCantidad();
//							listaProductoPedido.get(i).setCantidad(cant + lista.getCantidad());
//							encontro = true;
//						}
//					}
//					if (!encontro) {
//						ListaProductoPedidoDTO productoAgregar = new ListaProductoPedidoDTO(lista.getCodigo(),
//								lista.getCantidad());
//						listaProductoPedido.add(productoAgregar);
//					}
//				}
//			}
//		}
//		
//		
		
		if (dto != null) {
			Afiliado afiliado = afiliadoEJb.buscar(dto.getAfiliado());
			Pedido pedido = new Pedido(5, afiliado, GregorianCalendar.getInstance().getTime(),
					GregorianCalendar.getInstance().getTime());
			pedidoEJb.crear(pedido);
			for (ListaProductoPedidoDTO lista : dto.getListaProductoPedidoDTO()) {
				CatalogoProducto catalogo = cataProductoEJb.buscarCatalogoProducto(lista.getCodigo());
				cataProductoEJb.crear(catalogo);
				CatalogoPedidoAfiliado catalogoAfiliado = new CatalogoPedidoAfiliado(catalogo, pedido,
						lista.getCantidad());
				crear(catalogoAfiliado);
			}
			return true;
		} else {
			return false;
		}
	}

	public CatalogoPedidoAfiliado buscar(Object pk) {
		return dao.buscar(pk);
	}
	
	
	public List<String> listarCategorias() {
		CategoriaProductoEnum categorias[] = CategoriaProductoEnum.values();
		ArrayList<String> lista = new ArrayList<>();
		for (int i = 0; i < categorias.length; i++) {
			lista.add(categorias[i].toString());
		}

		return lista;
	}

}
