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
	
	public ComandoVehiculo convertirAComando(Vehiculo entidad) {
		ComandoVehiculo dominio = new ComandoVehiculo();
		dominio.setPlaca(entidad.getPlaca());
		dominio.setTipoVehiculo(entidad.getTipoVehiculo());
		dominio.setCilindraje(entidad.getCilindraje());
		return dominio;
	} 

}
