package co.com.ceiba.parqueadero.parqueadero.dominio.modelo;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionValidadorArgumento;

public class ValidadorArgumento {
	
	 private static final String CAMPO_VACIO = "";
	 private static final String TIPO_VEHICULO_CARRO = "CARRO";
	 private static final String TIPO_VEHICULO_MOTO = "MOTO";
	
	
	private ValidadorArgumento() {
		
	}


	public static void validarRequerido(Object valor, String mensaje) {
		if(valor == null || valor.equals(CAMPO_VACIO)) {
			throw new ExcepcionValidadorArgumento(mensaje);
		}
		
	}


	public static void validarFechaRequerida(Object valor, String mensaje) {
		if(valor == null) {
			throw new ExcepcionValidadorArgumento(mensaje);
		}
		
	}


	public static void validarTipoVehiculo(Object valor, String mensaje) {
		if(!valor.equals(TIPO_VEHICULO_MOTO) && !valor.equals(TIPO_VEHICULO_CARRO)) {
			throw new ExcepcionTipoVehiculoIncorrecto(mensaje);
		}
		
	}


		

}
