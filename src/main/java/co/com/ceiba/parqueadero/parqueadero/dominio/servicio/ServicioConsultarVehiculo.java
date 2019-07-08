package co.com.ceiba.parqueadero.parqueadero.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.consulta.ConsultarVehiculoActivo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;

@Component
public class ServicioConsultarVehiculo {

	private RepositorioVehiculo repositorioVehiculo;
	
	public ServicioConsultarVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}
	
	public List<ConsultarVehiculoActivo> consultarVehiculo(){
		return this.repositorioVehiculo.consultarVehiculo();
	}
	
}


