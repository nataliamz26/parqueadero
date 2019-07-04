package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionPlaca extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExcepcionPlaca(String mensaje) {
        super(mensaje);
    }

}
