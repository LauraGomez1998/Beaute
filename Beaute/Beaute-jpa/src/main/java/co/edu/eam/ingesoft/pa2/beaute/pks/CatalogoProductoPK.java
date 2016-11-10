package co.edu.eam.ingesoft.pa2.beaute.pks;

import java.io.Serializable;

public class CatalogoProductoPK implements Serializable {

	private int catalogo;
	private String producto;

	public CatalogoProductoPK() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + catalogo;
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogoProductoPK other = (CatalogoProductoPK) obj;
		if (catalogo != other.catalogo)
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

}
