package co.com.ceiba.parqueadero.parqueadero.dominio.modelo.unitaria;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoNoExiste;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioActualizarVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioActualizarVehiculoTest {

	private static final String EL_VEHICULO_NO_EXISTE = "El vehiculo no se encuentra en el parqueadero";
	private static final String TIPO_VEHICULO_CARRO = "CARRO";
	private static final String TIPO_VEHICULO_MOTO = "MOTO";
	private static final String PLACA = "XDX068";
	private static final String CILINGRAJE_ALTO = "600";
	private static final String CILINGRAJE = "300";
	private static final float PRECIO_DIA_MOTO = 4000;
	private static final int PRUEBA_DIA_CARRO = 1;
	private static final int PRUEBA_HORA_CARRO = 2;
	private static final int PRUEBA_PRECIO_CARRO = 11000;
	private static final int PRUEBA_DIA_MOTO = 0;
	private static final int PRUEBA_HORA_MOTO = 10;
	private static final int PRUEBA_PRECIO_MOTO = 6000;
	
	private RepositorioVehiculo repositorioVehiculo;
	private ServicioActualizarVehiculo servicioActualizarVehiculo;
	private VehiculoTestDataBuilder vehiculoTestDataBuilder;
	private Vehiculo vehiculo;
	
	@Before
	public void setUp() {
		// arrange
		this.repositorioVehiculo = mock(RepositorioVehiculo.class);
	}

	@Test
	public void build() {
		// act
		this.servicioActualizarVehiculo = new ServicioActualizarVehiculo(this.repositorioVehiculo);
		// assert
		assertNotNull(this.repositorioVehiculo);
		assertNotNull(this.servicioActualizarVehiculo);
	}

	@Test
	public void vehicleNotInParking() {
		// arrange
		when(this.repositorioVehiculo.validarSalidaVehiculo(PLACA)).thenReturn(false);
		when(this.repositorioVehiculo.registroSalidaVehiculo(this.vehiculo)).thenReturn(false);
		this.servicioActualizarVehiculo = new ServicioActualizarVehiculo(this.repositorioVehiculo);
		try {
			// act
			this.servicioActualizarVehiculo.registroSalidaVehiculo(PLACA);
			fail();
		} catch (ExcepcionVehiculoNoExiste e) {
			// assert
			assertEquals(e.getMessage(), EL_VEHICULO_NO_EXISTE);
		}
	}

	@Test
	public void vehicleInParking() {
		// arrange
		when(this.repositorioVehiculo.validarSalidaVehiculo(PLACA)).thenReturn(true);
		this.servicioActualizarVehiculo = new ServicioActualizarVehiculo(this.repositorioVehiculo);
		try {
			// act
			this.servicioActualizarVehiculo.registroSalidaVehiculo(PLACA);
		} catch (ExcepcionVehiculoNoExiste e) {
		}
	}
	

	@Test
	public void registroSalidaVehiculoCarro() {
		// arrange
		Calendar hoyCal = Calendar.getInstance();
		hoyCal.set(hoyCal.get(Calendar.YEAR), hoyCal.get(Calendar.MONTH),
				hoyCal.get(Calendar.DATE) - PRUEBA_DIA_CARRO, hoyCal.get(Calendar.HOUR_OF_DAY) - PRUEBA_HORA_CARRO, 0);
		Date fechaIngreso = hoyCal.getTime();
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_CARRO)
				.conFechaIngreso(fechaIngreso);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.retornoSalidaVehiculo(PLACA)).thenReturn(this.vehiculo);
		when(this.repositorioVehiculo.registroSalidaVehiculo(this.vehiculo)).thenReturn(true);
		this.servicioActualizarVehiculo = new ServicioActualizarVehiculo(this.repositorioVehiculo);
		// act
		Float precio = this.servicioActualizarVehiculo.registroSalidaVehiculo(PLACA);
		boolean salida = this.repositorioVehiculo.registroSalidaVehiculo(this.vehiculo);
		// assert
		assertEquals(PRUEBA_PRECIO_CARRO, precio, 0);
		assertEquals(true, salida);
	}
	
	@Test
	public void registroSalidaVehiculoMotoAltoCilingraje() {
		// arrange
		Calendar hoyCal = Calendar.getInstance();
		hoyCal.set(hoyCal.get(Calendar.YEAR), hoyCal.get(Calendar.MONTH),
				hoyCal.get(Calendar.DATE) - PRUEBA_DIA_MOTO,
				hoyCal.get(Calendar.HOUR_OF_DAY) - PRUEBA_HORA_MOTO, 0);
		Date fechaIngreso = hoyCal.getTime();
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conCilindraje(CILINGRAJE_ALTO)
				.conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_MOTO).conFechaIngreso(fechaIngreso);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.retornoSalidaVehiculo(PLACA)).thenReturn(this.vehiculo);
		when(this.repositorioVehiculo.registroSalidaVehiculo(this.vehiculo)).thenReturn(true);
		this.servicioActualizarVehiculo = new ServicioActualizarVehiculo(this.repositorioVehiculo);
		// act
		Float precio = this.servicioActualizarVehiculo.registroSalidaVehiculo(PLACA);
		boolean salida = this.repositorioVehiculo.registroSalidaVehiculo(this.vehiculo);
		// assert
		assertEquals(PRUEBA_PRECIO_MOTO, precio, 0);
		assertEquals(true, salida);
	}

	@Test
	public void registroSalidaVehiculoMoto() {
		// arrange
		Calendar hoyCal = Calendar.getInstance();
		hoyCal.set(hoyCal.get(Calendar.YEAR), hoyCal.get(Calendar.MONTH),
				hoyCal.get(Calendar.DATE) - PRUEBA_DIA_MOTO,
				hoyCal.get(Calendar.HOUR_OF_DAY) - PRUEBA_HORA_MOTO, 0);
		Date fechaIngreso = hoyCal.getTime();
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conCilindraje(CILINGRAJE).conPlaca(PLACA)
				.conTipoVehiculo(TIPO_VEHICULO_MOTO).conFechaIngreso(fechaIngreso);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.retornoSalidaVehiculo(PLACA)).thenReturn(this.vehiculo);
		when(this.repositorioVehiculo.registroSalidaVehiculo(this.vehiculo)).thenReturn(true);
		this.servicioActualizarVehiculo = new ServicioActualizarVehiculo(this.repositorioVehiculo);
		// act
		Float precio = this.servicioActualizarVehiculo.registroSalidaVehiculo(PLACA);
		boolean salida = this.repositorioVehiculo.registroSalidaVehiculo(this.vehiculo);
		// assert
		assertEquals(PRECIO_DIA_MOTO, precio, 0);
		assertEquals(true, salida);
	}

	


	
}
