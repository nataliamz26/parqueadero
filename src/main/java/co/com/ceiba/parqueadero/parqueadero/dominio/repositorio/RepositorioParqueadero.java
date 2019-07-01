package co.com.ceiba.parqueadero.parqueadero.dominio.repositorio;

import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.SolicitudIngresoCarro;

public interface RepositorioParqueadero {
	public int consultarCantidadCarros();

	public void almacenarCarro(SolicitudIngresoCarro solicitudIngresoCarro);
}
