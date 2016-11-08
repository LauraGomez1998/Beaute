package test.lase;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.caferrer.testdata.junit.TestDataUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.beaute.bos.ClienteEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Cliente;

@RunWith(Arquillian.class)
public class PruebaEJBCliente {

	@EJB
	private ClienteEJB clienteEJB;

	@Deployment
	public static EnterpriseArchive desplegar() {
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../Beaute-ear/target/Beaute-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBCliente.class));
		return ear;
	}

	@Test
	public void testCrearCliente() {
try{
		Cliente cliente = new Cliente();
		cliente.setCedula(1234);
		cliente.setApellido("Matallana");
		cliente.setNombre("alejandro");
		cliente.setUsuario("jairillo");
		cliente.setTelefono(31243);
		cliente.setContrasenia("123");
		clienteEJB.crear(cliente);

		Cliente c = clienteEJB.buscar(1234);
		Assert.assertNotNull(c);
}catch(Exception e){
	
}
}

	@AfterClass
	public static void finalizar() {
		TestDataUtil.ejecutarSQL("sqltest/Prueba-del.sql");
	}
}
