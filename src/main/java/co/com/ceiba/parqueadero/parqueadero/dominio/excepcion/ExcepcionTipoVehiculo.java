package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionTipoVehiculo extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExcepcionTipoVehiculo(String mensaje) {
		super(mensaje);
	}
}
