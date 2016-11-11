package co.edu.eam.ingesoft.pa2.beaute.util;

import java.util.List;

public class PedidoDTO {

	private List<ListaProductoPedidoDTO> listaProductoPedidoDTO;
	private int afiliado;
	
	
	
	
	public PedidoDTO(List<ListaProductoPedidoDTO> listaProductoPedidoDTO, int afiliado) {
		super();
		this.listaProductoPedidoDTO = listaProductoPedidoDTO;
		this.afiliado = afiliado;
	}
	
	
	public int getAfiliado() {
		return afiliado;
	}
	
	public List<ListaProductoPedidoDTO> getListaProductoPedidoDTO() {
		return listaProductoPedidoDTO;
	}
	
	public void setAfiliado(int afiliado) {
		this.afiliado = afiliado;
	}
	
	
	public void setListaProductoPedidoDTO(List<ListaProductoPedidoDTO> listaProductoPedidoDTO) {
		this.listaProductoPedidoDTO = listaProductoPedidoDTO;
	}
	
}
