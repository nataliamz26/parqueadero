package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando;

import org.springframework.transaction.annotation.Transactional;

public interface ComandoManejador<C> {

	@Transactional
	void exec(C comandoVehiculo);
	
}
