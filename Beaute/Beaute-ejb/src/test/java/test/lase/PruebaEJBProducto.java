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

import co.edu.eam.ingesoft.pa2.beaute.bos.ProductoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PromocionEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Producto;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.CategoriaProductoEnum;

@RunWith(Arquillian.class)
public class PruebaEJBProducto {

	@EJB
	private ProductoEJB productoEJB;

	@EJB
	private PromocionEJB promocionEJB;

	@Deployment
	public static EnterpriseArchive desplegar() {
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../Beaute-ear/target/Beaute-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBProducto.class));
		return ear;
	}

	@Test
	public void testCrearProducto() {
		try {
			Producto pro = new Producto();

			//pro.setCategoria(CategoriaProductoEnum.JABONES);
			pro.setCantidad(5);
			pro.setCaracteristica("caracteristica_prueba");
			pro.setCodigo("716523");
			pro.setEstado(true);  
			pro.setNombre("producto_prueba");
			pro.setPrecio(300);
			productoEJB.crear(pro);
			Producto producto = productoEJB.buscar(716523);
			Assert.assertNotNull(producto);
		} catch (Exception e) {

		}
	}

	@AfterClass
	public static void finalizar() {
		TestDataUtil.ejecutarSQL("sqltest/Prueba-del.sql");
	}

}