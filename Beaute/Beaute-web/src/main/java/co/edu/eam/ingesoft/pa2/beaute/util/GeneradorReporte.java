package co.edu.eam.ingesoft.pa2.beaute.util;

import java.io.IOException;import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * Clase utilitaria para generar el reporte.
 *
 * @author Camilo Andres Ferrer Bustos<br/>
 *         email: caferrerb@gmail.com <br/>
 *         Fecha: 17/11/2015<br/>
 */
public class GeneradorReporte {

	/**
	 * conexion
	 */
	private Connection con;

	public GeneradorReporte(Connection con) {
		this.con = con;
	}

	/**
	 * Metodo para generar el reporte.
	 *
	 * @author Camilo Andres Ferrer Bustos<br/>
	 *         email: caferrerb@gmail.com <br/>
	 *         Fecha: 17/11/2015<br/>
	 * @param parametros,
	 *            mapa con parametros.
	 * @param rutaJrxml,
	 *            ruta del archivo.
	 * @param nombreReporte,
	 *            nombre del reporte.
	 * @throws JRException
	 * @throws IOException
	 */
	public byte[] generarReporte(Map<String, Object> parametros, String rutaJrxml, String nombreReporte,
			OutputStream salida) throws JRException, IOException {

		try (InputStream input = this.getClass().getResourceAsStream(rutaJrxml);) {
			// carga la plantilla para ser compilada.
			JasperDesign platilla = JRXmlLoader.load(input);

			// compila el reporte..
			JasperReport report = JasperCompileManager.compileReport(platilla);
			byte[] byteStream = JasperRunManager.runReportToPdf(report, parametros, con);

			return byteStream;

		}

	}
}
