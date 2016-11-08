package co.edu.eam.ingesoft.pa2.beaute.pks;

import java.io.Serializable;

public class PedidoProductoPk implements Serializable {

	private int codigo;
	private int producto;

	public PedidoProductoPk() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + producto;
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
		if (producto != other.producto)
			return false;
		return true;
	}

}
