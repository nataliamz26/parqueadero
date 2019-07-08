package co.com.ceiba.parqueadero.parqueadero.dominio.modelo.unitaria;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.testdatabuilder.VehiculoTestDataBuilder;


public class VehiculoTest {
	
	private VehiculoTestDataBuilder vehiculoTestDataBuilder;
	private Vehiculo vehiculo;
	private static final String TIPO_VEHICULO_CARRO = "CARRO";
	private static final String TIPO_VEHICULO_MOTO = "MOTO";
	private static final String PLACA_CARRO = "XDX068";
	private static final String PLACA_MOTO = "XDX06C";
	private static final String CILINDRAJE_CARRO = "";
	private static final String CILINDRAJE_MOTO = "500";
	private static final Date FECHA_INGRESO = Calendar.getInstance().getTime();	
	private static final boolean ESTADO_REGISTRADO = true;
		
	
	@Test
	public void createVehiculoCarro() {
		//Arrange
		this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_CARRO)
				.conPlaca(PLACA_MOTO).conCilindraje(CILINDRAJE_MOTO).conFechaIngreso(FECHA_INGRESO)
				.conEstado(ESTADO_REGISTRADO);
		//Act
		this.vehiculo = this.vehiculoTestDataBuilder.build();
		//Assert
		assertNotNull(vehiculo);
	}
	
	@Test
	public void createVehiculoMoto() {
		//Arrange
				this.vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conTipoVehiculo(TIPO_VEHICULO_MOTO)
						.conPlaca(PLACA_CARRO).conCilindraje(CILINDRAJE_CARRO).conFechaIngreso(FECHA_INGRESO)
						.conEstado(ESTADO_REGISTRADO);
				//Act
				this.vehiculo = this.vehiculoTestDataBuilder.build();
				//Assert
				assertNotNull(vehiculo);
	}
	
	
	
	 	  
}
