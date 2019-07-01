package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoSolicitudIngresoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.CupoParqueaderoException;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.PlacaConLetraAException;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.SolicitudIngresoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.Vigilante;

@Component
public class ManejadorGestionarParqueadero {

	 private final Vigilante vigilante;

	    public ManejadorGestionarParqueadero(Vigilante vigilante){
	        this.vigilante = vigilante;
	    }

	    public  void recibirCarro(ComandoSolicitudIngresoCarro comandoSolicitudIngresoCarro) throws PlacaConLetraAException, CupoParqueaderoException{
	        this.vigilante.recibirCarro(new SolicitudIngresoCarro(comandoSolicitudIngresoCarro.getPlaca()));
	    }
	
}
