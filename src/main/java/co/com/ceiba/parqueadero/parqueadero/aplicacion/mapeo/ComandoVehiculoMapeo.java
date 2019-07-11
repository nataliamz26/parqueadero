package co.com.ceiba.parqueadero.parqueadero.aplicacion.mapeo;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;

public final class ComandoVehiculoMapeo {

	private ComandoVehiculoMapeo() {
		
	}
	
	private static final ComandoVehiculoMapeo INSTANCIA = new ComandoVehiculoMapeo();
	
	public static ComandoVehiculoMapeo getInstance() {
		return INSTANCIA;
	}
	
	public ComandoVehiculo convertirAComando(Vehiculo entidadVehiculo) {
		ComandoVehiculo vehiculo = new ComandoVehiculo();
		vehiculo.setPlaca(entidadVehiculo.getPlaca());
		vehiculo.setTipoVehiculo(entidadVehiculo.getTipoVehiculo());
		vehiculo.setCilindraje(entidadVehiculo.getCilindraje());
		return vehiculo;
	} 

}
