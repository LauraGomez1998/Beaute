package co.edu.eam.ingesoft.pa2.beaute.util;

import java.util.List;

public class PedidoClienteDTO {

	private List<ListaProductoPedidoDTO> listaProductoPedidoDTO;
	private int afiliado;
	private int cliente;
	private int cuotas;
	
	
	public PedidoClienteDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PedidoClienteDTO(List<ListaProductoPedidoDTO> listaProductoPedidoDTO, int afiliado, int cliente,
			int cuotas) {
		super();
		this.listaProductoPedidoDTO = listaProductoPedidoDTO;
		this.afiliado = afiliado;
		this.cliente = cliente;
		this.cuotas = cuotas;
	}
	public List<ListaProductoPedidoDTO> getListaProductoPedidoDTO() {
		return listaProductoPedidoDTO;
	}
	public void setListaProductoPedidoDTO(List<ListaProductoPedidoDTO> listaProductoPedidoDTO) {
		this.listaProductoPedidoDTO = listaProductoPedidoDTO;
	}
	public int getAfiliado() {
		return afiliado;
	}
	public void setAfiliado(int afiliado) {
		this.afiliado = afiliado;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
	
	
}
