package co.com.ceiba.parqueadero.parqueadero.aplicacion.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.consulta.ConsultarVehiculoActivo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioConsultarVehiculo;

@Component
public class ManejadorConsultarVehiculo {
	
	private final ServicioConsultarVehiculo servicioConsultarVehiculo;

	public ManejadorConsultarVehiculo(ServicioConsultarVehiculo servicioConsultarVehiculo) {
		this.servicioConsultarVehiculo = servicioConsultarVehiculo;
	}
	
	public List<ConsultarVehiculoActivo> exec(){
		return this.servicioConsultarVehiculo.consultarVehiculo();
	}
	

}
