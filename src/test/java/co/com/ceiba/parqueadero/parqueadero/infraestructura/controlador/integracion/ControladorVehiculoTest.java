package co.com.ceiba.parqueadero.parqueadero.infraestructura.controlador.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.ceiba.parqueadero.parqueadero.ApplicationMock;
import co.com.ceiba.parqueadero.parqueadero.ParqueaderoApplication;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoResultado;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoNoPuedeIngresar;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@SpringBootTest(classes = ParqueaderoApplication.class)
@AutoConfigureMockMvc
public class ControladorVehiculoTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mvc;
	private static final String URL_VEHICULO = "/parqueadero";
	private static final String PLACA_CARRO = "XDX068";
	private static final String PLACA_MOTO = "HHH300";
	private static final String PLACA_FALLIDA = "XDX06q";
	private static final String PLACA_INGRESO_FALLIDA = "ADX58p";
	private static final String TIPO_VEHICULO_CARRO = "CARRO";
	private static final String TIPO_VEHICULO_MOTO = "MOTO";
	private static final String CILINDRAJE = "400";;
	private static final float PRECIO_HORA_CARRO = 1000;
	private static final float PRECIO_HORA_MOTO = 500;
	private static final String MENSAJE_ERROR = "Ocurrió un error favor contactar al administrador.";
	private static final String EL_VEHICULO_NO_PUEDE_INGRESAR = "No está autorizado a ingresar, solo esta permitido el día Domingo y Lunes";

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void registrarIngresoMoto() throws Exception {
		ComandoVehiculoTestDataBuilder comandoVehiculoTestDataBuilder = new ComandoVehiculoTestDataBuilder()
				.conPlaca(PLACA_MOTO).conTipoVehiculo(TIPO_VEHICULO_MOTO).conCilindraje(CILINDRAJE);
		ComandoVehiculo comandoVehiculo = comandoVehiculoTestDataBuilder.build();
		JSONObject jsonComandoVehiculo = new JSONObject(comandoVehiculo);
		ComandoResultado<ComandoVehiculo> comandoResultado = new ComandoResultado<>(comandoVehiculo);
		JSONObject jsonVehiculoComandoResultado = new JSONObject(comandoResultado);
		mvc.perform(post(URL_VEHICULO).content(jsonComandoVehiculo.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(jsonVehiculoComandoResultado.toString()));
	}

	
	/*
	 * @Test public void registrarIngresoCarro() throws Exception {
	 * ComandoVehiculoTestDataBuilder comandoVehiculoTestDataBuilder = new
	 * ComandoVehiculoTestDataBuilder()
	 * .conPlaca(PLACA_CARRO).conTipoVehiculo(TIPO_VEHICULO_CARRO); ComandoVehiculo
	 * comandoVehiculo = comandoVehiculoTestDataBuilder.build(); JSONObject
	 * jsonComandoVehiculo = new JSONObject(comandoVehiculo);
	 * ComandoResultado<ComandoVehiculo> comandoResultado = new
	 * ComandoResultado<>(comandoVehiculo); JSONObject jsonVehiculoComandoResultado =
	 * new JSONObject(comandoResultado);
	 * mvc.perform(post(URL_VEHICULO).content(jsonComandoVehiculo.toString()).
	 * contentType(MediaType.APPLICATION_JSON))
	 * .andExpect(status().isOk()).andExpect(content().json(
	 * jsonVehiculoComandoResultado.toString())); }
	 */

	@Test
	public void getVehiculoActivo() throws Exception {
		this.mvc.perform(get(URL_VEHICULO).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void registrarSalidaCarro() throws Exception {
		ComandoVehiculoTestDataBuilder comandoVehiculoTestDataBuilder = new ComandoVehiculoTestDataBuilder()
				.conPlaca(PLACA_CARRO);
		ComandoVehiculo comandoVehiculo = comandoVehiculoTestDataBuilder.build();
		JSONObject jsonComandoVehiculo = new JSONObject(comandoVehiculo);
		ComandoResultado<Float> salidaResultado = new ComandoResultado<>(PRECIO_HORA_CARRO);
		JSONObject comandoResultado = new JSONObject(salidaResultado);
		mvc.perform(put(URL_VEHICULO).content(jsonComandoVehiculo.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect((content().json(comandoResultado.toString())));
	}
	
	
	  @Test public void registrarSalidaMoto() throws Exception {
		  ComandoVehiculoTestDataBuilder comandoVehiculoTestDataBuilder = new ComandoVehiculoTestDataBuilder().conPlaca(PLACA_MOTO); ComandoVehiculo
		  comandoVehiculo = comandoVehiculoTestDataBuilder.build(); 
		  JSONObject jsonComandoVehiculo = new JSONObject(comandoVehiculo);
		  ComandoResultado<Float> salidaResultado = new
	  ComandoResultado<>(PRECIO_HORA_MOTO); JSONObject comandoResultado = new
	  JSONObject(salidaResultado);
	  mvc.perform(put(URL_VEHICULO).content(jsonComandoVehiculo.toString()).
	  contentType(MediaType.APPLICATION_JSON))
	  .andExpect(status().isOk()).andExpect((content().json(comandoResultado.
	  toString()))); }
	 

	@Test
	public void registrarSalidaCarroFallo() throws Exception {
		ComandoVehiculoTestDataBuilder comandoVehiculoTestDataBuilder = new ComandoVehiculoTestDataBuilder()
				.conPlaca(PLACA_FALLIDA);
		ComandoVehiculo comandoVehiculo = comandoVehiculoTestDataBuilder.build();
		JSONObject jsonComandoVehiculo = new JSONObject(comandoVehiculo);
		NullPointerException error = new NullPointerException(MENSAJE_ERROR);
		JSONObject errorJsonResultado = new JSONObject(error);
		mvc.perform(put(URL_VEHICULO).content(jsonComandoVehiculo.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is5xxServerError()).andExpect((content().json(errorJsonResultado.toString())));
	}

}
