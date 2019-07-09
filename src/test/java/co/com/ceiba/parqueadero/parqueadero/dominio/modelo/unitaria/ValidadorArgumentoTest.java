package co.com.ceiba.parqueadero.parqueadero.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionValidadorArgumento;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.ValidadorArgumento;


public class ValidadorArgumentoTest {

	private static final String CAMPO_VACIO = "";
	private static final String TIPO_VEHICULO_PATINES = "PATINES";
	private static final String PLACA_REQUERIDA = "La placa es un dato obligatorio.";
	private static final String TIPO_VEHICULO_INCORRECTO = "El campo tipo vehículo no es valido para el sistema.";

	@Test
	public void ValidadorArgumentoVacio() {
		try {
			// act
			ValidadorArgumento.validarRequerido(CAMPO_VACIO,PLACA_REQUERIDA);
			fail();
		} catch (ExcepcionValidadorArgumento e) {
			// assert
			assertEquals(e.getMessage(), PLACA_REQUERIDA);
		}
	}
	
	@Test
	public void argumentValidatorIsNull() {
		try {
			// act
			ValidadorArgumento.validarRequerido(null,PLACA_REQUERIDA);
			fail();
		} catch (ExcepcionValidadorArgumento e) {
			// assert
			assertEquals(e.getMessage(), PLACA_REQUERIDA);
		}
	}
	
	@Test
	public void argumentValidatorDateIsNull() {
		try {
			// act
			ValidadorArgumento.validarFechaRequerida(null,PLACA_REQUERIDA);
			fail();
		} catch (ExcepcionValidadorArgumento e) {
			// assert
			assertEquals(e.getMessage(), PLACA_REQUERIDA);
		}
	}
	
	@Test
	public void argumentValidatorInvalidTypeVehicle() {
		try {
			// act
			ValidadorArgumento.validarTipoVehiculo(TIPO_VEHICULO_PATINES,TIPO_VEHICULO_INCORRECTO);
			fail();
		} catch (ExcepcionTipoVehiculoIncorrecto e) {
			// assert
			assertEquals(e.getMessage(), TIPO_VEHICULO_INCORRECTO);
		}
	}
	
}
