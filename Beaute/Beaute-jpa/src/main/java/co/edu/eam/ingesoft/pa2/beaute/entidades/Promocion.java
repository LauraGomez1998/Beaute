package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.XMLConstants;

@Entity
@Table(name = "PROMOCIONES")
@NamedQueries({ @NamedQuery(name = Promocion.LISTAR_PROMOCIONES, query = "Select p from Promocion p") })
public class Promocion implements Serializable {

	public static final String LISTAR_PROMOCIONES = "Promocion.listar";

	@Id
	@Column(name = "CODIGO", length = 10)
	private String codigo;

	@Column(name = "DESCUENTO", length = 50, nullable = false)
	private double descuento;

	public Promocion() {

	}

	public Promocion(String codigo, double descuento) {
		super();
		this.codigo = codigo;
		this.descuento = descuento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Promocion) {
			Promocion tmpPromocion = (Promocion) obj;
			if (this.codigo.equals(tmpPromocion.codigo)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
