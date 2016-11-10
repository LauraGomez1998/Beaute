package co.edu.eam.ingesoft.pa2.beaute.bos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.beaute.entidades.CatalogoProducto;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;
import co.edu.eam.ingesoft.pa2.beaute.implementacion.EJBGenerico;

@Stateless
@LocalBean
public class CatalogoProductoEJB extends EJBGenerico<CatalogoProducto> {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return CatalogoProducto.class;
	}

	public void crear(CatalogoProducto catalogoProducto) {
		dao.crear(catalogoProducto);
	}

	public List<CatalogoProducto> buscarCatalogoProducto(int codigo) {
		return dao.ejecutarNamedQuery(CatalogoProducto.BUSCAR_CATALOGO_PRODUCTO, codigo);
	}

	public List<Producto> listarProductosCatalogo(CategoriaProductoEnum categoria) {
		return dao.ejecutarNamedQuery(CatalogoProducto.LISTAR_PRODUCTOS_CATALOGO, categoria);
	}

}
