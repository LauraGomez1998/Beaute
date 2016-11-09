package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.CatalogoProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;
 
@Named("pedidoAfiliadoWeb")
@ViewScoped
public class ControladorVentanaPedidoAfiliado implements Serializable {

	@EJB
	private CatalogoProductoEJB catalogoProductoEJB;

	private List<Producto> listaProductos;

	private Producto productoSeleccionado;

	/**
	 * muestra los productos de la categoria seleccionada
	 * 
	 * @param seleccion
	 *            el valor seccionado
	 */ 
	public void mostrarProductos(int seleecionado) {
		if (seleecionado == 0) {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.POLVOS);
		} else if (seleecionado == 1) {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.LABIAL);
		} else if (seleecionado == 2) {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.JABONES);
		} else {
			listaProductos = catalogoProductoEJB.listarProductosCatalogo(CategoriaProductoEnum.OTROS);
		}
	}

	
	
	
	
	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}
}
