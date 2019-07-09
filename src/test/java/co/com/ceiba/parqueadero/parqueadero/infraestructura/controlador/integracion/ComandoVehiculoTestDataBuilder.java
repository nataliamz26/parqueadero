package co.com.ceiba.parqueadero.parqueadero.infraestructura.controlador.integracion;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ComandoVehiculo;

public class ComandoVehiculoTestDataBuilder {

	private String placa;
	private String cilindraje;
	private String tipoVehiculo;

	
	
	public ComandoVehiculoTestDataBuilder() {
		
	}

	
	public ComandoVehiculoTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	public ComandoVehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public ComandoVehiculoTestDataBuilder conCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}

	

	public ComandoVehiculo build() {
		ComandoVehiculo vehiculo = new ComandoVehiculo();
		vehiculo.setTipoVehiculo(this.tipoVehiculo);
		vehiculo.setPlaca(this.placa);
		vehiculo.setCilindraje(this.cilindraje);
		return vehiculo;
	}
	
}
