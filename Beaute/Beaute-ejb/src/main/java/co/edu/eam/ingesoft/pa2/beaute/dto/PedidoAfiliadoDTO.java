package co.edu.eam.ingesoft.pa2.beaute.dto;

import java.util.List;

public class PedidoAfiliadoDTO {

	private List<ProductoDTO> productosPedidos;

	private int cedulaAfiliado;

	public PedidoAfiliadoDTO() {
	}

	public PedidoAfiliadoDTO(List<ProductoDTO> productosPedidos, int cedulaAfiliado) {
		super();
		this.productosPedidos = productosPedidos;
		this.cedulaAfiliado = cedulaAfiliado;
	}

	public List<ProductoDTO> getProductosPedidos() {
		return productosPedidos;
	}

	public void setProductosPedidos(List<ProductoDTO> productosPedidos) {
		this.productosPedidos = productosPedidos;
	}

	public int getCedulaAfiliado() {
		return cedulaAfiliado;
	}

	public void setCedulaAfiliado(int cedulaAfiliado) {
		this.cedulaAfiliado = cedulaAfiliado;
	}

}
