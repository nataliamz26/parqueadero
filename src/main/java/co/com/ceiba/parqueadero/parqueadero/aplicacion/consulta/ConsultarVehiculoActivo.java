package co.com.ceiba.parqueadero.parqueadero.aplicacion.consulta;

import java.util.Date;


public class ConsultarVehiculoActivo {
		

	private String tipoVehiculo;
	private String placa;
	private String cilindraje;
	private String fechaIngreso;
	
	
	public ConsultarVehiculoActivo(String tipoVehiculo,String placa, String cilindraje, Date fechaIngreso) {
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.fechaIngreso = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM", fechaIngreso);
			
	}


	public String getCilindraje() {
		return cilindraje;
	}


	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}


	public String getTipoVehiculo() {
		return tipoVehiculo;
	}


	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	

}
