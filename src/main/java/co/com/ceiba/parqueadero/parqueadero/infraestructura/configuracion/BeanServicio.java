package co.com.ceiba.parqueadero.parqueadero.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioActualizarVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioConsultarVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioCrearVehiculo;


@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioCrearVehiculo servicioCrearUsuario(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioCrearVehiculo(repositorioVehiculo);
	}

	@Bean
	public ServicioActualizarVehiculo servicioEliminarUsuario(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioActualizarVehiculo(repositorioVehiculo);
	}

	@Bean
	public ServicioConsultarVehiculo servicioActualizarUsuario(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioConsultarVehiculo(repositorioVehiculo);
	}
	
}
