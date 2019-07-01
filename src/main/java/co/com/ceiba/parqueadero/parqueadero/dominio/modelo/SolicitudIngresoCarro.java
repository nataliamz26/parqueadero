package co.com.ceiba.parqueadero.parqueadero.dominio.modelo;

public class SolicitudIngresoCarro {

	private String placa;
	
	public SolicitudIngresoCarro(String placa) {
		this.placa = placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return this.placa;
	}
}
