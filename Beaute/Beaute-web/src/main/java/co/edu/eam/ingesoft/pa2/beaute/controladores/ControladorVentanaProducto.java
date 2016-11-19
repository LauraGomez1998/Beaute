package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.ProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;

@Named("productoWeb")
@ViewScoped
public class ControladorVentanaProducto implements Serializable {

	/**
	 * EJB de la clase producto
	 */
	@EJB
	private ProductoEJB productoEJB;
	/**
	 * Lista de categorias
	 */
	private List<CategoriaProductoEnum> listaCategorias;
	/**
	 * Codigo del producto
	 */
	private String codigo;
	/**
	 * categoria del producto
	 */
	private CategoriaProductoEnum categoria;
	/**
	 * cantidad del producto
	 */
	private int cantidad;
	/**
	 * precio del producto
	 */
	private double precio;
	/**
	 * estado del producto
	 */
	private int estadoSeleccionado;
	/**
	 * nombre del producto
	 */
	private String nombre;
	/**
	 * caracteristicas del producto
	 */
	private String caracteristica;

	/**
	 * metodo de inicializar
	 */
	@PostConstruct
	public void inicializar() {
		listaCategorias();
	}

	/**
	 * metodo para listar las categorias
	 */
	public void listaCategorias() {
		listaCategorias = new ArrayList<>();
		CategoriaProductoEnum[] listaCatagoria = CategoriaProductoEnum.values();
		for (int i = 0; i < listaCatagoria.length; i++) {
			listaCategorias.add(listaCatagoria[i]);
		}
	}

	/**
	 * metodo para registrar un producto
	 */
	public void registrarProducto() {
		try {
			boolean estado = true;
			if (estadoSeleccionado != 0) {
				estado = false;
			}
			Producto p = new Producto(codigo, categoria, cantidad, precio, estado, nombre, caracteristica);
			productoEJB.crear(p);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se ha registrado el producto", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (EJBTransactionRolledbackException e) {
			Throwable t = e;
			while (!(t.getCause() instanceof SQLException)) {
				t = t.getCause();
				if (t == null) {
					break;
				}
				if (t.getCause() instanceof SQLException) {
					SQLException sql = (SQLException) t.getCause();
					if (sql.getErrorCode() == 20001) {
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"El producto ya se encuentra registrado", null);
						FacesContext.getCurrentInstance().addMessage(null, message);
					}
				}
			}
		}
	}

	/**
	 * metodo para buscar un producto
	 */
	public void buscarProducto() {
		Producto p = productoEJB.buscar(codigo);
		if (p != null) {
			codigo = p.getCodigo();
			categoria = p.getCategoria();
			cantidad = p.getCantidad();
			precio = p.getPrecio();
			if (p.isEstado()) {
				estadoSeleccionado = 0;
			} else {
				estadoSeleccionado = 1;
			}
			nombre = p.getNombre();
			caracteristica = p.getCaracteristica();
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se ha encontrado el producto",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	/**
	 * metodo para editar un producto
	 */
	public void editarProducto() {
		Producto p = productoEJB.buscar(codigo);
		if (p != null) {
			Producto prodEdit = new Producto();
			prodEdit.setCantidad(cantidad);
			prodEdit.setCaracteristica(caracteristica);
			prodEdit.setCategoria(categoria);
			prodEdit.setCodigo(p.getCodigo());
			boolean estado = true;
			if (estadoSeleccionado != 0) {
				estado = false;
			}
			prodEdit.setEstado(estado);
			prodEdit.setNombre(nombre);
			prodEdit.setPrecio(precio);
			productoEJB.editar(prodEdit);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El producto ha sido editado", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se ha encontrado el producto",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * merodo para eliminar un producto
	 */
	public void eliminarProducto() {
		Producto p = productoEJB.buscar(codigo);
		if (p != null) {
			productoEJB.eliminar(p);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se ha encontrado el producto",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * accesores y modificadores
	 */
	public List<CategoriaProductoEnum> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaProductoEnum> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public CategoriaProductoEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProductoEnum categoria) {
		this.categoria = categoria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getEstadoSeleccionado() {
		return estadoSeleccionado;
	}

	public void setEstadoSeleccionado(int estadoSeleccionado) {
		this.estadoSeleccionado = estadoSeleccionado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

}
