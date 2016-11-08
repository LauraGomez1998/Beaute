package co.edu.eam.ingesoft.pa2.beaute.pks;

import java.io.Serializable;


public class CatalogoPedidoAfiliadoPK implements Serializable {

	private CatalogoProductoPK catalogo;
	private int pedido;

	public CatalogoPedidoAfiliadoPK() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalogo == null) ? 0 : catalogo.hashCode());
		result = prime * result + pedido;
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
		CatalogoPedidoAfiliadoPK other = (CatalogoPedidoAfiliadoPK) obj;
		if (catalogo == null) {
			if (other.catalogo != null)
				return false;
		} else if (!catalogo.equals(other.catalogo))
			return false;
		if (pedido != other.pedido)
			return false;
		return true;
	}

	
}
