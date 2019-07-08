package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoManejadorResultado;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoResultado;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.generacion.GenerarTiquete;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.mapeo.ComandoVehiculoMapeo;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioCrearVehiculo;

@Component
public class ManejadorCrearVehiculo implements ComandoManejadorResultado<ComandoVehiculo, ComandoResultado<ComandoVehiculo>> {

	 private final ServicioCrearVehiculo servicioCrearVehiculo;
	 private final GenerarTiquete generarTiquete;
	 private static final ComandoVehiculoMapeo mapeo = ComandoVehiculoMapeo.getInstance();

	    public ManejadorCrearVehiculo(GenerarTiquete generarTiquete, ServicioCrearVehiculo servicioCrearVehiculo){
	        this.generarTiquete = generarTiquete;
	    	this.servicioCrearVehiculo = servicioCrearVehiculo;
	    }

	    public ComandoResultado<ComandoVehiculo> exec(ComandoVehiculo comandoVehiculo) {
	        Vehiculo vehiculo = this.generarTiquete.crear(comandoVehiculo);
	        return new ComandoResultado<>(mapeo.convertirAComando(this.servicioCrearVehiculo.registroIngresoVehiculo(vehiculo)));
	    }

	    
}
