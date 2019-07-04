package co.com.ceiba.parqueadero.parqueadero.dominio.modelo;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;

public class ValidadorArgumento {
	
	private ValidadorArgumento() {}
	
		public static void validarPlaca(Object valor, String mensaje) throws ExcepcionPlaca  {
			if (valor == null) {
				throw new ExcepcionPlaca(mensaje);
			}
		}

		public static void validarTipoVehiculo(String valor, String mensaje) throws ExcepcionTipoVehiculo  {
			if (valor == null) {
				throw new ExcepcionTipoVehiculo(mensaje);
			}
			
		}

		public static void validarTipoVehiculoIncorrecto(String mensaje) throws ExcepcionTipoVehiculoIncorrecto  {
			throw new ExcepcionTipoVehiculoIncorrecto(mensaje);
		}

		public static void validarCilindrajeRequerido(String valor, String mensaje) throws ExcepcionCilindrajeRequerido {
			if (valor == null) {
				throw new ExcepcionCilindrajeRequerido(mensaje);
			}
			
		}

		public static void validarCilindrajeIncorrecto(String valor, String mensaje) throws ExcepcionCilindrajeIncorrecto {
			try {
				Integer.parseInt(valor);
			}catch(NumberFormatException numberFormatException){
				throw new ExcepcionCilindrajeIncorrecto(mensaje);
			}
			
		}


	

		

}
