package co.com.ceiba.parqueadero.parqueadero.infraestructura.repositorio;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;

@Repository
public class RepositorioParqueaderoJPA implements RepositorioRegistroVehiculo {

	@Override
	public int consultarCantidadCarro() {
	
		return 0;
	}

	@Override
	public void almacenarCarro(RegistroVehiculo registroVehiculo) {
	
	}

	@Override
	public int consultarCantidadMoto() {
		return 0;
	}

	@Override
	public void almacenarMoto(RegistroVehiculo registroVehiculo) {
		
	}
	
}
