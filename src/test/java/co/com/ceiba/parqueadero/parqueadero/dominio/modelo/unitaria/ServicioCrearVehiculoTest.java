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

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParquederoLleno;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoNoPuedeIngresar;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoExiste;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoNoExiste;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioCrearVehiculoTest {
	
	private RepositorioVehiculo repositorioVehiculo;
	private ServicioCrearVehiculo servicioCrearVehiculo;
	private VehiculoTestDataBuilder vehiculoTestDataBuilder;
	private Vehiculo vehiculo;
	private Date hoy;
	private static final String TIPO_VEHICULO_CARRO = "CARRO";
	private static final String TIPO_VEHICULO_MOTO = "MOTO";
	private static final int CAPACIDAD_MAXIMA_CARRO = 20;
	private static final int CAPACIDAD_MAXIMA_MOTO = 10;
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_CARRO = "El Parqueadero no tiene cupo para carro";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_MOTO = "El Parqueadero no tiene cupo para moto";
	private static final String CILINGRAJE = "300";
	private static final String PLACA = "SDX068";
	private static final String EL_VEHICULO_EXISTE = "El vehiculo se encuentra en el parqueadero";
	private static final String EL_VEHICULO_NO_PUEDE_INGRESAR = "No está autorizado a ingresar, solo esta permitido el día Domingo y Lunes";
	private static final String PRIMERA_LETRA_PLACA = "ADX068";

	
	@Before
	public void setUp() {
		// arrange
		this.repositorioVehiculo = mock(RepositorioVehiculo.class);
		this.hoy = Calendar.getInstance().getTime();
	}

	@Test
	public void build() {
		// act
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		// assert
		assertNotNull(this.repositorioVehiculo);
		assertNotNull(this.servicioCrearVehiculo);
	}

	
	@Test
	public void crearVehiculoCarro() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_CARRO)
				.conFechaIngreso(hoy);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_CARRO)
				.conFechaIngreso(hoy).conPrecio(0).conEstado(true);
		Vehiculo nuevoVehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.registroIngresoVehiculo(this.vehiculo)).thenReturn(nuevoVehiculo);
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		// act
		Vehiculo vehiculoResultado = this.servicioCrearVehiculo.registroIngresoVehiculo(this.vehiculo);
		// assert
		assertEquals(vehiculoResultado, nuevoVehiculo);
	}
	
	
	@Test
	public void crearVehiculoMoto() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conCilindraje(CILINGRAJE).conPlaca(PLACA)
				.conTipoVehiculo(TIPO_VEHICULO_MOTO).conFechaIngreso(hoy);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conCilindraje(CILINGRAJE).conPlaca(PLACA)
				.conTipoVehiculo(TIPO_VEHICULO_MOTO).conFechaIngreso(hoy).conPrecio(0).conEstado(true);
		Vehiculo nuevoVehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.registroIngresoVehiculo(this.vehiculo)).thenReturn(nuevoVehiculo);
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		// act
		Vehiculo vehiculoResultado = this.servicioCrearVehiculo.registroIngresoVehiculo(this.vehiculo);
		// assert
		assertEquals(vehiculoResultado, nuevoVehiculo);
	}



	@Test
	public void vehiculoExisteCarro() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_MOTO)
				.conFechaIngreso(hoy);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.validarSalidaVehiculo(PLACA)).thenReturn(true);
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		try {
			// act
			this.repositorioVehiculo.registroIngresoVehiculo(this.vehiculo);
		} catch (ExcepcionVehiculoExiste e) {
			// assert
			assertEquals(e.getMessage(), EL_VEHICULO_EXISTE);
		}
	}
	
	@Test
	public void vehiculoExisteMoto() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_MOTO)
				.conCilindraje(CILINGRAJE).conFechaIngreso(hoy);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.validarSalidaVehiculo(PLACA)).thenReturn(true);
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		try {
			// act
			this.repositorioVehiculo.registroIngresoVehiculo(this.vehiculo);
		} catch (ExcepcionVehiculoExiste e) {
			// assert
			assertEquals(e.getMessage(), EL_VEHICULO_EXISTE);
		}
	}
	
	
	@Test
	public void vehiculoNoExisteCarro() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_CARRO)
				.conFechaIngreso(hoy);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.validarSalidaVehiculo(PLACA)).thenReturn(false);
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		try {
			// act
			this.servicioCrearVehiculo.registroIngresoVehiculo(this.vehiculo);
		} catch (ExcepcionVehiculoNoExiste e) {
			
			
		}
	}
	
	@Test
	public void vehiculoNoExisteMoto() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_MOTO)
				.conCilindraje(CILINGRAJE).conFechaIngreso(hoy);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.validarSalidaVehiculo(PLACA)).thenReturn(false);
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		try {
			// act
			this.servicioCrearVehiculo.registroIngresoVehiculo(this.vehiculo);
		} catch (ExcepcionVehiculoNoExiste e) {
		}
	}

	
	@Test
	public void validarNoSalidaVehiculoCarro() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_CARRO)
				.conFechaIngreso(hoy);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.validarSalidaVehiculo(PLACA)).thenReturn(true);
		assertEquals(this.repositorioVehiculo.validarSalidaVehiculo(PLACA), true);
	}
	
	@Test
	public void validarNoSalidaVehiculoMoto() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_MOTO)
				.conCilindraje(CILINGRAJE).conFechaIngreso(hoy);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.validarSalidaVehiculo(PLACA)).thenReturn(true);
		assertEquals(this.repositorioVehiculo.validarSalidaVehiculo(PLACA), true);
	}
	
	@Test
	public void validarSalidaVehiculo() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_CARRO);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.validarSalidaVehiculo(PLACA)).thenReturn(false);
		assertEquals(this.repositorioVehiculo.validarSalidaVehiculo(PLACA), false);
	}


	@Test
	public void validarCupoParqueaderoCarro() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_CARRO);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.contarCarro()).thenReturn(CAPACIDAD_MAXIMA_CARRO);
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		try {
			// act
			this.servicioCrearVehiculo.registroIngresoVehiculo(this.vehiculo);
			fail();
		} catch (ExcepcionCupoParquederoLleno e) {
			// assert
			assertEquals(e.getMessage(), EL_PARQUEADERO_NO_TIENE_CUPO_CARRO);
		}
	}
	
	
	@Test
	public void validarCupoParqueaderoMoto() {
		// arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipoVehiculo(TIPO_VEHICULO_MOTO)
				.conCilindraje(CILINGRAJE).conFechaIngreso(hoy);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		when(this.repositorioVehiculo.contarMoto()).thenReturn(CAPACIDAD_MAXIMA_MOTO);
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		try {
			// act
			this.servicioCrearVehiculo.registroIngresoVehiculo(this.vehiculo);
			fail();
		} catch (ExcepcionCupoParquederoLleno e) {
			// assert
			assertEquals(e.getMessage(), EL_PARQUEADERO_NO_TIENE_CUPO_MOTO);
		}
	}

	

	@Test
	public void validarIngresoVehiculo() {
		// arrange
		Calendar hoyCal = Calendar.getInstance();
		hoyCal.set(2019, 7, 8);
		Date hoyModificada = hoyCal.getTime();
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conCilindraje(CILINGRAJE)
				.conPlaca(PRIMERA_LETRA_PLACA).conFechaIngreso(hoyModificada).conTipoVehiculo(TIPO_VEHICULO_MOTO);
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		this.servicioCrearVehiculo = new ServicioCrearVehiculo(this.repositorioVehiculo);
		try {
			// act
			this.servicioCrearVehiculo.registroIngresoVehiculo(this.vehiculo);
			fail();
		} catch (ExcepcionVehiculoNoPuedeIngresar e) {
			// assert
			assertEquals(e.getMessage(), EL_VEHICULO_NO_PUEDE_INGRESAR);
		}

	}
	
	

	
	

}
