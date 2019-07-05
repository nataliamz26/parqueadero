package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionCupoParquederoLleno extends RuntimeException {

		private static final long serialVersionUID = 1L;

	public ExcepcionCupoParquederoLleno(String mensaje) {
		super(mensaje);
		
	}
	
	
	
}
