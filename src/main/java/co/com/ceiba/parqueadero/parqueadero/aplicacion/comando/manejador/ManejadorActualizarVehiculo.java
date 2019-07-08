package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoManejadorResultado;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoResultado;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioActualizarVehiculo;

@Component
public class ManejadorActualizarVehiculo implements ComandoManejadorResultado<String, ComandoResultado<Float>> {
	
	private final ServicioActualizarVehiculo servicioActualizarVehiculo;

	
	public ManejadorActualizarVehiculo(ServicioActualizarVehiculo servicioActualizarVehiculo) {
		this.servicioActualizarVehiculo = servicioActualizarVehiculo;
	}

	@Override
   	public ComandoResultado<Float> exec(String placa) {
		return new ComandoResultado<>(servicioActualizarVehiculo.registroSalidaVehiculo(placa));
	}
        
	

	
}
