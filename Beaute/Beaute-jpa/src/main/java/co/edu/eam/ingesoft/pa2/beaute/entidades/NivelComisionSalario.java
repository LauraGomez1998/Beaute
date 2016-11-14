package co.edu.eam.ingesoft.pa2.beaute.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMISION_SALARIO")
public class NivelComisionSalario implements Serializable{
	
	@Id
	@Column(name="CODIGO", nullable=false, length=10)
	private int codigo;
	
	@Column(name="COMISION", nullable=false, length=10)
	private double comision;
	
	@Column(name="NIVEL", nullable=false, length=10)
	private int nivel;
	
	public NivelComisionSalario() {
		// TODO Auto-generated constructor stub
	}

	public NivelComisionSalario(int codigo, double comision, int nivel) {
		super();
		this.codigo = codigo;
		this.comision = comision;
		this.nivel = nivel;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
	
	

}
