package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa2.beaute.pks.CatalogoProductoPK;

@Entity
@Table(name = "CATALOGOS_PRODUCTOS")
@IdClass(value = CatalogoProductoPK.class)
public class CatalogoProducto implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "CATALOGO", nullable = false)
	private Catalogo catalogo;

	@Id
	@ManyToOne
	@JoinColumn(name = "PRODUCTO", nullable = false)
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "PROMOCION", nullable = true)
	private Promocion promocion;

	@Temporal(TemporalType.TIME)
	@Column(name = "INICIO_PROMOCION", nullable = true)
	private Date inicioPromocion;

	@Temporal(TemporalType.TIME)
	@Column(name = "FIN_PROMOCION", nullable = true)
	private Date finPromocion;

	public CatalogoProducto() {
	}

	public CatalogoProducto(Catalogo catalogo, Producto producto, Promocion promocion, Date inicioPromocion,
			Date finPromocion) {
		super();
		this.catalogo = catalogo;
		this.producto = producto;
		this.promocion = promocion;
		this.inicioPromocion = inicioPromocion;
		this.finPromocion = finPromocion;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	public Date getInicioPromocion() {
		return inicioPromocion;
	}

	public void setInicioPromocion(Date inicioPromocion) {
		this.inicioPromocion = inicioPromocion;
	}

	public Date getFinPromocion() {
		return finPromocion;
	}

	public void setFinPromocion(Date finPromocion) {
		this.finPromocion = finPromocion;
	}

}
