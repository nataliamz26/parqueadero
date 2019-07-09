package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionVehiculoNoPuedeIngresar extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionVehiculoNoPuedeIngresar(String mensaje) {
		super(mensaje);
	
	}

	
	
}
