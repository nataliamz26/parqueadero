package co.com.ceiba.parqueadero.parqueadero.infraestructura.adaptador.repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.consulta.ConsultarVehiculoActivo;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;
import co.com.ceiba.parqueadero.parqueadero.infraestructura.mapeo.MapeoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.infraestructura.modelo.EntidadVehiculo;

@Component
public class RepositorioVehiculoEnMemoria implements RepositorioVehiculo {

	private static final MapeoVehiculo mapeoVehiculo = MapeoVehiculo.getInstance();
	

	@Autowired
	private RepositorioVehiculoJPA jpa;
	
	@Override
	public Vehiculo registroIngresoVehiculo(Vehiculo vehiculo) {
		EntidadVehiculo entidadVehiculo = mapeoVehiculo.convertirAEntidad(vehiculo);
		return mapeoVehiculo.convertirADominio(jpa.save(entidadVehiculo));
	}
		
	@Override
	public List<ConsultarVehiculoActivo> consultarVehiculo() {
		return jpa.vehiculoActivo();
	}
	
	
	@Override
	public boolean registroSalidaVehiculo(Vehiculo vehiculo) {
		EntidadVehiculo entidadVehiculo = mapeoVehiculo.convertirAEntidad(vehiculo);
		return jpa.save(entidadVehiculo) != null;
		
	}


	@Override
	public boolean validarSalidaVehiculo(String placa) {
		EntidadVehiculo entidadVehiculo = jpa.findByPlaca(placa);
		return entidadVehiculo !=null;
	}
	
			
	@Override
	public Vehiculo retornoSalidaVehiculo(String placa) {
		EntidadVehiculo entidadVehiculo = jpa.findByPlaca(placa);
		return mapeoVehiculo.convertirADominio(entidadVehiculo);
	}
	
	

	@Override
	public int contarCarro() {
		return jpa.contarCarro();
	}


	@Override
	public int contarMoto() {
		return jpa.contarCarro();
	}
	
	
	

	
}
