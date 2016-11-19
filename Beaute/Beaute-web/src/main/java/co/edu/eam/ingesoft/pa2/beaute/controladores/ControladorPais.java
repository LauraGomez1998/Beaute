package co.edu.eam.ingesoft.pa2.beaute.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.beaute.bos.PaisEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Pais;

@Named("paisWeb")
@ViewScoped
public class ControladorPais implements Serializable {

	@EJB
	private PaisEJB paisEJB;

	public void crear() {
		try {
			Pais pais = new Pais(1, "Argentina");
			paisEJB.crear(pais);
		} catch (EJBTransactionRolledbackException e) {
			System.out.println("Excepcion---- " + e.getClass());
			System.out.println("Excepcion2---- " + e.getCause());
			Throwable t = e;
			while (!(t.getCause() instanceof SQLException)) {
				t = t.getCause();
				if (t == null) {
					break;
				}
				if (t.getCause() instanceof SQLException) {
					SQLException sql = (SQLException) t.getCause();
					System.out.println(" ----------------------");
					if (sql.getErrorCode() == 20001) {

						System.out.println(sql.getMessage() + " ----------------------");
					}
				}
			}

			// while (true) {
			// t = t.getCause();
			// if (t.getCause() instanceof SQLException) {
			// break;
			// }
			// System.out.println(t.getCause());
			// if (t == null) {
			// break;
			// }
			// }
		}
	}
	
	
	
	
	
	
	
	
	
}
