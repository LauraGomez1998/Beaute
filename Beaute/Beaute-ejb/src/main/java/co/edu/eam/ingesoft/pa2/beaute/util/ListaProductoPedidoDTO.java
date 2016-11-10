package co.edu.eam.ingesoft.pa2.beaute.util;

public class ListaProductoPedidoDTO {

	private String codigo;
	private int cantidad;
	
	public ListaProductoPedidoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public ListaProductoPedidoDTO(String codigo, int cantidad) {
		super();
		this.codigo = codigo;
		this.cantidad = cantidad;
	}




	public int getCantidad() {
		return cantidad;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
