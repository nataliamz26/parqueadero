package co.com.ceiba.parqueadero.parqueadero.dominio.servicio;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.CupoParqueaderoException;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.PlacaConLetraAException;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.SolicitudIngresoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioParqueadero;

@Service
public class Vigilante {
	
	private RepositorioParqueadero repositorioParqueadero;
	
	@Autowired
	public Vigilante(RepositorioParqueadero repositorioParqueadero) {
		this.repositorioParqueadero = repositorioParqueadero;
	}

	private static final String EL_VEHICULO_NO_PUEDE_INGRESAR = "No está autorizado a ingresar";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO = "El Parqueadero no tiene cupo";

	public Boolean recibirCarro(SolicitudIngresoCarro solicitudIngresoCarro) throws PlacaConLetraAException, CupoParqueaderoException {
		// Validaciones
		if (solicitudIngresoCarro.getPlaca().substring(0,1).equals("A") && (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) > 2)) {
			throw new PlacaConLetraAException(EL_VEHICULO_NO_PUEDE_INGRESAR);			
		}
		if (repositorioParqueadero.consultarCantidadCarros()==20) {
			throw new CupoParqueaderoException(EL_PARQUEADERO_NO_TIENE_CUPO);
		}
		repositorioParqueadero.almacenarCarro(solicitudIngresoCarro);
		return true;
	}

}
