package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando;

import java.util.Date;


public class ComandoVehiculo {
		
	private Integer id;
	private String tipoVehiculo;
	private String placa;
	private String cilindraje;
	private Date  fechaIngreso;
	private Date fechaSalida;
	private long valor;
	
	public Integer getId() {
		return id;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public String getPlaca() {
		return this.placa;
	}
	
	public String getCilindraje() {
		return cilindraje;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public long getValor() {
		return valor;
	}

}
