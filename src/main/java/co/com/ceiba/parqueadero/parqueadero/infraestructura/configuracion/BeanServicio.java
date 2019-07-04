package co.com.ceiba.parqueadero.parqueadero.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorCrearVehiculo;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorListarVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioCrearVehiculo;


@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioCrearVehiculo(repositorioVehiculo);
	}

	@Bean
	public ManejadorCrearVehiculo manejadorCrearVehiculo(ServicioCrearVehiculo servicioCrearVehiculo) {
		return new ManejadorCrearVehiculo(servicioCrearVehiculo);
	}

	@Bean
	public ManejadorListarVehiculo manejadorListarVehiculo(RepositorioVehiculo repositorioVehiculo) {
		return new ManejadorListarVehiculo(repositorioVehiculo);
	}
	
}
