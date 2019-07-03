package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExceptionCilindrajeIncorrecto extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExceptionCilindrajeIncorrecto(String mensajeCilindrajeIncorrecto) {
		super(mensajeCilindrajeIncorrecto);
	}

}
