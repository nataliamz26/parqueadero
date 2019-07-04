package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionCilindrajeIncorrecto extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExcepcionCilindrajeIncorrecto(String mensaje) {
		super(mensaje);
	}

}
