package co.com.ceiba.parqueadero.parqueadero.infraestructura.repositorio;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.SolicitudIngresoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioParqueadero;

@Repository
public class RepositorioParqueaderoJPA implements RepositorioParqueadero {

	@Override
	public int consultarCantidadCarros() {
	
		return 0;
	}

	@Override
	public void almacenarCarro(SolicitudIngresoCarro solicitudIngresoCarro) {
	
		
	}
	
}
