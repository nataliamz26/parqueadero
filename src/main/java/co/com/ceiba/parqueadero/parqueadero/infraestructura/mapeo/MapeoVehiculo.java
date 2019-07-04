package co.com.ceiba.parqueadero.parqueadero.infraestructura.mapeo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.infraestructura.entidad.EntidadVehiculo;

@Component 
public class MapeoVehiculo {

	public Vehiculo convertirADominio(EntidadVehiculo entidadVehiculo) {
		Vehiculo vehiculo;
		
		if(entidadVehiculo != null) {
			vehiculo = null;
		}
		else {
			vehiculo = new Vehiculo(entidadVehiculo.getId(),entidadVehiculo.getTipoVehiculo(),entidadVehiculo.getPlaca()
                    ,entidadVehiculo.getCilindraje(), entidadVehiculo.getFechaIngreso(), entidadVehiculo.getFechaSalida()
                    ,entidadVehiculo.getValor());
		}
		return vehiculo;
	}

	public EntidadVehiculo convertirAEntidad(Vehiculo vehiculo) {
		EntidadVehiculo entidadVehiculo;
		
		if(vehiculo == null) {
			entidadVehiculo = null;
		}
		else {
			entidadVehiculo = new EntidadVehiculo(vehiculo.getId(),vehiculo.getTipoVehiculo(),vehiculo.getPlaca()
					,vehiculo.getCilindraje(),vehiculo.getFechaIngreso(),vehiculo.getFechaSalida(),vehiculo.getValor());
		}
		return entidadVehiculo;
	}

	public List<Vehiculo> listarConvertirADominio(List<EntidadVehiculo> listarEntidadVehiculo) {
		final List<Vehiculo> listarVehiculo = new ArrayList<>();
		
		listarEntidadVehiculo.forEach(entidadVehiculo -> listarVehiculo.add(new Vehiculo(entidadVehiculo.getId()
				,entidadVehiculo.getTipoVehiculo(),entidadVehiculo.getPlaca()
				,entidadVehiculo.getCilindraje(),entidadVehiculo.getFechaIngreso(),entidadVehiculo.getFechaSalida()
				,entidadVehiculo.getValor())));
		return listarVehiculo;
	}
	
	
	
	
}
