package co.edu.eam.ingesoft.pa2.beaute.excepciones;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ExcepcionNegocio extends RuntimeException {

	/**
	 * Constructor de la ExcepcionNegocio
	 * 
	 * @param message
	 * @param cause
	 */
	public ExcepcionNegocio(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public ExcepcionNegocio(String message) {
		super(message);
	}
}