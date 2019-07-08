package co.com.ceiba.parqueadero.parqueadero.aplicacion.generacion;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ComandoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;

@Component
public class GenerarTiquete {



	public Vehiculo crear(ComandoVehiculo comandoVehiculo) {
		return new Vehiculo(comandoVehiculo.getPlaca(),
				comandoVehiculo.getTipoVehiculo(),
				comandoVehiculo.getCilindraje(),
				Calendar.getInstance().getTime());
		
	}
	
	
	
	
}
