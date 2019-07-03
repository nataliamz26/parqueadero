package co.com.ceiba.parqueadero.parqueadero.dominio.modelo;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculoIncorrecto;

public class Validador {
	
	private Validador() {}
	
		public static void validarPlaca(String placa, String mensajePlacaRequerida) throws ExceptionPlaca {
			if (placa == null) {
				throw new ExceptionPlaca(mensajePlacaRequerida);
			}
		}

		public static void validarTipoVehiculo(String tipoVehiculo, String mensajeTipoVehiculoRequerido) throws ExceptionTipoVehiculo {
			if (tipoVehiculo == null) {
				throw new ExceptionTipoVehiculo(mensajeTipoVehiculoRequerido);
			}
			
		}

		public static void validarTipoVehiculoIncorrecto(String format) throws ExceptionTipoVehiculoIncorrecto {
			throw new ExceptionTipoVehiculoIncorrecto(format);
		}

		public static void validarCilindrajeRequerido(String cilindraje, String mensajeCilindrajeRequerido) throws ExceptionCilindrajeRequerido {
			if (cilindraje == null) {
				throw new ExceptionCilindrajeRequerido(mensajeCilindrajeRequerido);
			}
			
		}

		public static void validarCilindrajeIncorrecto(String cilindraje, String mensajeCilindrajeIncorrecto) throws ExceptionCilindrajeIncorrecto {
			try {
				Integer.parseInt(cilindraje);
			}catch(NumberFormatException numberFormatException){
				throw new ExceptionCilindrajeIncorrecto(mensajeCilindrajeIncorrecto);
			}
			
		}


	

		

}
