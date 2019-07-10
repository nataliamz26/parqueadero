package co.com.ceiba.parqueadero.parqueadero.infraestructura.error;

public class Error {

	private String excepcionNombre;
	private String mensaje;
	
	
	public Error(String excepcionNombre, String mensaje) {
		this.excepcionNombre = excepcionNombre;
		this.mensaje = mensaje;
	}


	public String getExcepcionNombre() {
		return excepcionNombre;
	}


	public String getMensaje() {
		return mensaje;
	}
	
	
}
