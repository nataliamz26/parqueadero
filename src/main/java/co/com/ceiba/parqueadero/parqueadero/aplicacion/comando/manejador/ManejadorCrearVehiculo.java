package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParqueaderoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParqueaderoMoto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlacaConLetraA;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoExiste;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioCrearVehiculo;

@Component
public class ManejadorCrearVehiculo {

	 private final ServicioCrearVehiculo servicioCrearVehiculo;

	    public ManejadorCrearVehiculo(ServicioCrearVehiculo servicioCrearVehiculo){
	        this.servicioCrearVehiculo = servicioCrearVehiculo;
	    }

	    public  void registrarVehiculo(ComandoVehiculo comandoVehiculo) throws ExcepcionPlaca, ExcepcionCupoParqueaderoCarro, ExcepcionPlaca, ExcepcionTipoVehiculo, ExcepcionTipoVehiculoIncorrecto, ExcepcionCilindrajeRequerido, ExcepcionCilindrajeIncorrecto, ExcepcionPlacaConLetraA, ExcepcionVehiculoExiste{
	        this.servicioCrearVehiculo.registrarVehiculo(new Vehiculo(comandoVehiculo.getId(), comandoVehiculo.getTipoVehiculo(), comandoVehiculo.getPlaca(), comandoVehiculo.getCilindraje(), comandoVehiculo.getFechaIngreso(), comandoVehiculo.getFechaSalida(), comandoVehiculo.getValor()));
	    }
	
	    
}
