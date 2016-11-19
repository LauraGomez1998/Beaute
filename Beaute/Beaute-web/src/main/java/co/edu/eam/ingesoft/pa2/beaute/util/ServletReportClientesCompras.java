package co.edu.eam.ingesoft.pa2.beaute.util;

import java.io.IOException;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clientesCompras")
public class ServletReportClientesCompras extends HttpServlet{
	@Resource(lookup = "java:jboss/datasources/Beaute")
	private javax.sql.DataSource ds;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String id=req.getParameter("id");
		
		//-----EJEMPLO-------------------------------------
		try(Connection con=ds.getConnection();
				) {
			ServletOutputStream salida=resp.getOutputStream();
			GeneradorReporte generador=new GeneradorReporte(con);
			byte[] byteStream=generador.generarReporte(null, "/reportes/clientesCompras.jrxml", "test", salida);
			resp.setHeader("Content-Disposition","filename=myReport.pdf");
			resp.setContentType("application/pdf");
			resp.setContentLength(byteStream.length);
			salida.write(byteStream,0,byteStream.length);  
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
