package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.swing.ProgressMonitorInputStream;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoPremioEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PremioAfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PremioEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.AfiliadoPremio;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Premio;
import co.edu.eam.ingesoft.pa2.beaute.entidades.PremioAfiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.PremioVenta;

@Named("afiliadopremioWeb")
@ViewScoped
public class ControladorVentanaAfiliadoPremio implements Serializable {

	@EJB
	private PremioEJB premioEJB;

	@EJB
	private AfiliadoEJB afiliadoEJB;

	@EJB
	private AfiliadoPremioEJB afiliadoPremioEJB;

	private List<PremioAfiliado> premiosAfiliados;

	private List<PremioVenta> premiosVentas;

	private boolean activarAfiliado;

	private boolean activarVentas;

	private int codigo;

	private int afiliado;

	private String tipoPremioSeleccionado;

	private Premio premioSeleccionado;

	@PostConstruct
	public void iniciar() {
		PremioAfiliado p = new PremioAfiliado("1", "Ni idea", 12, "afiliado");
		premioEJB.crear(p);
		PremioVenta pre = new PremioVenta("2", "Ni idea", 12, "venta");
		premioEJB.crear(pre);
		listarPremiosA();
		activarAfiliado = true;
		activarVentas = false;
	}

	/**
	 * metodo para listar los premios
	 */
	public void listarPremiosA() {
		List<Premio> lista = premioEJB.listarPremios();
		premiosAfiliados = new ArrayList<>();
		premiosVentas = new ArrayList<>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) instanceof PremioAfiliado) {
				premiosAfiliados.add((PremioAfiliado) lista.get(i));
			} else {
				premiosVentas.add((PremioVenta) lista.get(i));
			}

		}
	}

	/**
	 * metodo que registra un premio a un afiliado
	 */
	public void registrarPremio() {
		Afiliado afi = afiliadoEJB.buscar(afiliado);
		if (afi != null) {
			AfiliadoPremio afiliadoPremio = new AfiliadoPremio();
			if (premioSeleccionado instanceof PremioAfiliado) {
				afiliadoPremio = new AfiliadoPremio(codigo, afi, (PremioAfiliado) premioSeleccionado,
						Calendar.getInstance().getTime());
			} else {
				afiliadoPremio = new AfiliadoPremio(codigo, afi, (PremioVenta) premioSeleccionado,
						Calendar.getInstance().getTime());
			}
			afiliadoPremioEJB.crear(afiliadoPremio);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El premio ha sido registrado", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se ha encontrado un afiliado",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void tipoPremioSelect() {
		if (tipoPremioSeleccionado.equals("0")) {
			activarAfiliado = true;
			activarVentas = false;
		} else {
			activarAfiliado = false;
			activarVentas = true;
		}
	}

	public boolean isActivarAfiliado() {
		return activarAfiliado;
	}

	public void setActivarAfiliado(boolean activarAfiliado) {
		this.activarAfiliado = activarAfiliado;
	}

	public boolean isActivarVentas() {
		return activarVentas;
	}

	public void setActivarVentas(boolean activarVentas) {
		this.activarVentas = activarVentas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(int afiliado) {
		this.afiliado = afiliado;
	}

	public String getTipoPremioSeleccionado() {
		return tipoPremioSeleccionado;
	}

	public void setTipoPremioSeleccionado(String tipoPremioSeleccionado) {
		this.tipoPremioSeleccionado = tipoPremioSeleccionado;
	}

	public Premio getPremioSeleccionado() {
		return premioSeleccionado;
	}

	public void setPremioSeleccionado(Premio premioSeleccionado) {
		this.premioSeleccionado = premioSeleccionado;
	}

	public List<PremioAfiliado> getPremiosAfiliados() {
		return premiosAfiliados;
	}

	public void setPremiosAfiliados(List<PremioAfiliado> premiosAfiliados) {
		this.premiosAfiliados = premiosAfiliados;
	}

	public List<PremioVenta> getPremiosVentas() {
		return premiosVentas;
	}

	public void setPremiosVentas(List<PremioVenta> premiosVentas) {
		this.premiosVentas = premiosVentas;
	}
}
