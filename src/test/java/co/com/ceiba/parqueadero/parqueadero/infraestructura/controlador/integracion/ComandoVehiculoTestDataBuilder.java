package co.com.ceiba.parqueadero.parqueadero.infraestructura.controlador.integracion;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoVehiculo;

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
		ComandoVehiculo comandoVehiculo = new ComandoVehiculo();
		comandoVehiculo.setTipoVehiculo(this.tipoVehiculo);
		comandoVehiculo.setPlaca(this.placa);
		comandoVehiculo.setCilindraje(this.cilindraje);
		return comandoVehiculo;
	}
	
}
