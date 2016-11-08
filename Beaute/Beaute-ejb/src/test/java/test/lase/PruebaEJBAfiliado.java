package test.lase;

import java.util.GregorianCalendar;

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

import co.edu.eam.ingesoft.pa2.beaute.bos.AfiliadoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.CiudadEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.DepartamentoEJB;
import co.edu.eam.ingesoft.pa2.beaute.bos.PaisEJB;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Afiliado;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Ciudad;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Departamento;
import co.edu.eam.ingesoft.pa2.beaute.entidades.Pais;
import co.edu.eam.ingesoft.pa2.beaute.enumeraciones.GeneroAfiliadoEnum;

@RunWith(Arquillian.class)
public class PruebaEJBAfiliado {

	@EJB
	private AfiliadoEJB afiliadoEJB;

	@EJB
	private PaisEJB paisEJB;

	@EJB
	private DepartamentoEJB departamentoEJB;

	@EJB
	private CiudadEJB ciudadEJB;

	@Deployment
	public static EnterpriseArchive desplegar() {
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../Beaute-ear/target/Beaute-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaEJBAfiliado.class));
		return ear;
	}

	@Test
	public void testAfiliar() {
		try {
			Pais pais = new Pais();
			pais.setCodigo(123);
			pais.setNombre("Colombia");
			paisEJB.crear(pais);

			Departamento depto = new Departamento();
			depto.setCodigo(123);
			depto.setNombre("Quindio");
			depto.setPais(pais);
			departamentoEJB.crear(depto);

			Ciudad ciudad = new Ciudad();
			ciudad.setCodigo("123");
			ciudad.setDepartamento(depto);
			ciudad.setNombre("Armenia");
			ciudadEJB.crear(ciudad);

			Afiliado afiliador = new Afiliado();
			afiliador.setAfiliador(null);
			afiliador.setApellido("Rios");
			afiliador.setCedulaAfiliado(123);
			afiliador.setCiudad(ciudad);
			afiliador.setContrasenia("11234123");
			afiliador.setFechaIngreso(GregorianCalendar.getInstance().getTime());
			afiliador.setGenero(GeneroAfiliadoEnum.MASCULINO);
			afiliador.setNombre("Jairo");
			afiliador.setTelefono(311777666);
			afiliador.setUsuario("jairo");
			afiliadoEJB.crear(afiliador);

			Afiliado af = afiliadoEJB.buscar(123);

			Afiliado afiliado = new Afiliado();
			afiliado.setAfiliador(af);
			afiliado.setApellido("Vanegas");
			afiliado.setCedulaAfiliado(1234);
			afiliado.setCiudad(ciudad);
			afiliado.setContrasenia("11234123");
			afiliado.setFechaIngreso(GregorianCalendar.getInstance().getTime());
			afiliado.setGenero(GeneroAfiliadoEnum.MASCULINO);
			afiliado.setNombre("Jhonatan");
			afiliado.setTelefono(311777612);
			afiliado.setUsuario("jhonatan");
			afiliadoEJB.crear(afiliado);

			Afiliado a = afiliadoEJB.buscar(1234);
			Assert.assertNotNull(a);
		} catch (Exception e) {
		}
	}

	@AfterClass
	public static void finalizar() {
		TestDataUtil.ejecutarSQL("sqltest/Prueba-del.sql");
	}

}
