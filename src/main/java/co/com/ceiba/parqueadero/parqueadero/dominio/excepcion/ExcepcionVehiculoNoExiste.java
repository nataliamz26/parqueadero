package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionVehiculoNoExiste extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionVehiculoNoExiste(String mensaje) {
		super(mensaje);
		
	}

	
}
