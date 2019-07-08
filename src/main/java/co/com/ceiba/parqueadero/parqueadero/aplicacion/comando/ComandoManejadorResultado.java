package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando;

import org.springframework.transaction.annotation.Transactional;

public interface ComandoManejadorResultado<C, R> {

	@Transactional
	R exec(C comandoVehiculo);
	
}
