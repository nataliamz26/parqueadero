package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionCupoParqueaderoMoto extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExcepcionCupoParqueaderoMoto(String mensaje) {
		super(mensaje);
	}
	
}
