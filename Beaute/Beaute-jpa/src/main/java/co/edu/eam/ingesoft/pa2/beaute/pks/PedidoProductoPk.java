package co.edu.eam.ingesoft.pa2.beaute.pks;

import java.io.Serializable;

public class PedidoProductoPk implements Serializable {

	private int codigo;
	private String producto;

	public PedidoProductoPk() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		PedidoProductoPk other = (PedidoProductoPk) obj;
		if (codigo != other.codigo)
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

}
