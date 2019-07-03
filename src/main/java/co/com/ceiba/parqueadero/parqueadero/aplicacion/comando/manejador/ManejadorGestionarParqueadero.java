package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCupoParqueaderoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCupoParqueaderoMoto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionPlacaConLetraA;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.RegistroServicio;

@Component
public class ManejadorGestionarParqueadero {

	 private final RegistroServicio registroServicio;

	    public ManejadorGestionarParqueadero(RegistroServicio registroServicio){
	        this.registroServicio = registroServicio;
	    }

	    public  void recibirCarro(ComandoRegistroVehiculo comandoRegistroVehiculo) throws ExceptionPlacaConLetraA, ExceptionCupoParqueaderoCarro, ExceptionPlaca, ExceptionTipoVehiculo, ExceptionTipoVehiculoIncorrecto, ExceptionCilindrajeRequerido, ExceptionCilindrajeIncorrecto{
	        this.registroServicio.recibirCarro(new RegistroVehiculo(null, null, comandoRegistroVehiculo.getPlaca(), null, null, null, 0));
	    }
	
	    public  void recibirMoto(ComandoRegistroVehiculo comandoRegistroVehiculo) throws ExceptionPlacaConLetraA, ExceptionCupoParqueaderoMoto, ExceptionPlaca, ExceptionTipoVehiculo, ExceptionTipoVehiculoIncorrecto, ExceptionCilindrajeRequerido, ExceptionCilindrajeIncorrecto{
	        this.registroServicio.recibirMoto(new RegistroVehiculo(null, null, comandoRegistroVehiculo.getPlaca(), null, null, null, 0));
	    }
}
