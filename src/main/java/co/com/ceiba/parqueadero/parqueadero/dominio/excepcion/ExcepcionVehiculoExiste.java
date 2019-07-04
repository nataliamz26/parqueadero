package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionVehiculoExiste extends Exception {
	  
	private static final long serialVersionUID = 1L;

	    
	public ExcepcionVehiculoExiste(String mensaje) {
	        super(mensaje);
	}
}
