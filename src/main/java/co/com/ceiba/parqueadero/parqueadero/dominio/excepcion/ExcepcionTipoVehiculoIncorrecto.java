package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionTipoVehiculoIncorrecto extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionTipoVehiculoIncorrecto(String mensaje) {
		super(mensaje);
	}
}
