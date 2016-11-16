package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.Catalogo;
import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoProducto;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class CatalogoProductoEJB extends EJBGenerico<CatalogoProducto> {

	@Override
	public Class getClase() {
		return CatalogoProducto.class;
	}

	public void crear(CatalogoProducto catalogoProducto) {
		dao.crear(catalogoProducto);
	}

	public CatalogoProducto buscarCatalogoProducto(String codigo) {
		List<CatalogoProducto> catalogo = dao.ejecutarNamedQuery(CatalogoProducto.BUSCAR_CATALOGO_PRODUCTO, codigo);
		if (!catalogo.isEmpty()) {
			return catalogo.get(0);
		}
		return null;
	}

	public List<Producto> listarProductosCatalogo(CategoriaProductoEnum categoria) {
		return dao.ejecutarNamedQuery(CatalogoProducto.LISTAR_PRODUCTOS_CATALOGO, categoria);
	}

	public CatalogoProducto validar(String codigoProd, int codigoCat) {
		List<CatalogoProducto> catProd = dao.ejecutarNamedQuery(CatalogoProducto.VALIDAR_PRODUCTO_CATALOGO, codigoProd,
				codigoCat);
		if (!catProd.isEmpty()) {
			return catProd.get(0);
		} else {
			return null;
		}

	}

}
