package co.com.ceiba.parqueadero.parqueadero.dominio.repositorio;

import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.RegistroVehiculo;

public interface RepositorioRegistroVehiculo {
	
	public int consultarCantidadCarro();

	public void almacenarCarro(RegistroVehiculo registroVehiculo);

	public int consultarCantidadMoto();

	public void almacenarMoto(RegistroVehiculo registroVehiculo);
	
	
}
