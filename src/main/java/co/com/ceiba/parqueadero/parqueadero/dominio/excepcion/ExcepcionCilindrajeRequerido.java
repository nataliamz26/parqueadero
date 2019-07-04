package co.com.ceiba.parqueadero.parqueadero.dominio.excepcion;

public class ExcepcionCilindrajeRequerido extends Exception {

	private static final long serialVersionUID = 1L;

		public ExcepcionCilindrajeRequerido (String mensaje) {
			super(mensaje);
		}
}
