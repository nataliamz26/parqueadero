package co.com.ceiba.parqueadero.parqueadero.infraestructura.controlador.integracion;

import javax.swing.Spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceiba.parqueadero.parqueadero.dominio.testdatabuilder.VehiculoTestDataBuilder;
import co.com.ceiba.parqueadero.parqueadero.infraestructura.controlador.ControladorVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ControladorVehiculo.class)
public class ControladorVehiculoTest {
	
	private MockMvc mockMvc;
	
	private final ControladorVehiculo controladorVehiculo = new ControladorVehiculo();

	
	
	@Before
	public void VehiculoTest() {
		WebApplicationContext wac;
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	@Test
	public void validarPlacaObligatorio() throws Exception {
		mockMvc.perform(requestBuilder)
	}
	
}
