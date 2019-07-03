package co.com.ceiba.parqueadero.parqueadero.dominio.servicio;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCupoParqueaderoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCupoParqueaderoMoto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionPlacaConLetraA;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;

@Service
public class RegistroServicio {
	
	private RepositorioRegistroVehiculo repositorioregistroVehiculo;
	
	@Autowired
	public RegistroServicio(RepositorioRegistroVehiculo repositorioregistroVehiculo) {
		this.repositorioregistroVehiculo = repositorioregistroVehiculo;
	}

	private static final String EL_VEHICULO_NO_PUEDE_INGRESAR = "No está autorizado a ingresar";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_CARRO = "El Parqueadero no tiene cupo para carro";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_MOTO = "El Parqueadero no tiene cupo para moto";

	public Boolean recibirCarro(RegistroVehiculo registroVehiculo) throws ExceptionPlacaConLetraA, ExceptionCupoParqueaderoCarro {
		// Validaciones
		if (registroVehiculo.getPlaca().substring(0,1).equals("A") && (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) > 2)) {
			throw new ExceptionPlacaConLetraA(EL_VEHICULO_NO_PUEDE_INGRESAR);			
		}
		if (repositorioregistroVehiculo.consultarCantidadCarro()==20) {
			throw new ExceptionCupoParqueaderoCarro(EL_PARQUEADERO_NO_TIENE_CUPO_CARRO);
		}
		repositorioregistroVehiculo.almacenarCarro(registroVehiculo);
		return true;
	}

	public Boolean recibirMoto(RegistroVehiculo registroVehiculo) throws ExceptionPlacaConLetraA, ExceptionCupoParqueaderoMoto {
		//Validaciones
		if (registroVehiculo.getPlaca().substring(0,1).equals("A") && (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) > 2)) {
			throw new ExceptionPlacaConLetraA(EL_VEHICULO_NO_PUEDE_INGRESAR);
		}
		if (repositorioregistroVehiculo.consultarCantidadMoto()==10) {
			throw new ExceptionCupoParqueaderoMoto(EL_PARQUEADERO_NO_TIENE_CUPO_MOTO);
		}
		repositorioregistroVehiculo.almacenarMoto(registroVehiculo);
		return true;
	}

}
