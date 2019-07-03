package co.com.ceiba.parqueadero.parqueadero.dominio.servicio.unitaria;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCupoParqueaderoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCupoParqueaderoMoto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionPlacaConLetraA;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.RegistroServicio;



public class RegistroServicioTest {
	
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_CARRO = "El Parqueadero no tiene cupo para carro";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_MOTO = "El Parqueadero no tiene cupo para moto";
	
	
	@Test
	public void registroIngresoCarroParqueaderoVacio() throws ExceptionPlacaConLetraA, ExceptionCupoParqueaderoCarro, ExceptionPlaca, ExceptionTipoVehiculo, ExceptionTipoVehiculoIncorrecto, ExceptionCilindrajeRequerido, ExceptionCilindrajeIncorrecto {
		// Arrange
		RegistroVehiculo registroVehiculo = new RegistroVehiculo(1, "CARRO", "BCD123", null, new Date(), null, 0);

		
		RepositorioRegistroVehiculo repositorioRegistroVehiculo = mock(RepositorioRegistroVehiculo.class);
		when(repositorioRegistroVehiculo.consultarCantidadCarro()).thenReturn(0);
	
	
		RegistroServicio registroServicio = new RegistroServicio(repositorioRegistroVehiculo);
		// Action
		Boolean permitirIngresoCarro = registroServicio.recibirCarro(registroVehiculo);
		// Assert
		assertTrue(permitirIngresoCarro);
	}
	
	@Test
	public void registroIngresoCarroParqueaderoLleno() throws ExceptionPlacaConLetraA, ExceptionPlaca, ExceptionTipoVehiculo, ExceptionTipoVehiculoIncorrecto, ExceptionCilindrajeRequerido, ExceptionCilindrajeIncorrecto {
		// Arrange
		RegistroVehiculo registroVehiculo = new RegistroVehiculo(1, "CARRO", "BCD123", null, new Date(), null, 0);
		
		
		RepositorioRegistroVehiculo repositorioRegistroVehiculo = mock(RepositorioRegistroVehiculo.class);
		when(repositorioRegistroVehiculo.consultarCantidadCarro()).thenReturn(20);
	
		RegistroServicio registroServicio = new RegistroServicio(repositorioRegistroVehiculo);
		// Action
		try {
			Boolean permitirIngresoCarro = registroServicio.recibirCarro(registroVehiculo);
			fail();
		} catch (ExceptionCupoParqueaderoCarro e) {
			//assert
			Assert.assertEquals(EL_PARQUEADERO_NO_TIENE_CUPO_CARRO, e.getMessage());
		}
	}
	

	
	@Test
	public void registroIngresoMotoParqueaderoVacio() throws ExceptionPlacaConLetraA, ExceptionCupoParqueaderoCarro, ExceptionPlaca, ExceptionTipoVehiculo, ExceptionTipoVehiculoIncorrecto, ExceptionCilindrajeRequerido, ExceptionCilindrajeIncorrecto, ExceptionCupoParqueaderoMoto {
		// Arrange
		RegistroVehiculo registroVehiculo = new RegistroVehiculo(1, "MOTO", "XDX06C", "125", new Date(), null, 0);

		
		RepositorioRegistroVehiculo repositorioRegistroVehiculo = mock(RepositorioRegistroVehiculo.class);
		when(repositorioRegistroVehiculo.consultarCantidadMoto()).thenReturn(0);
	
	
		RegistroServicio registroServicio = new RegistroServicio(repositorioRegistroVehiculo);
		// Action
		Boolean permitirIngresoMoto = registroServicio.recibirMoto(registroVehiculo);
		// Assert
		assertTrue(permitirIngresoMoto);
	}
	
	@Test
	public void registroIngresoMotoParqueaderoLleno() throws ExceptionPlacaConLetraA, ExceptionPlaca, ExceptionTipoVehiculo, ExceptionTipoVehiculoIncorrecto, ExceptionCilindrajeRequerido, ExceptionCilindrajeIncorrecto {
		// Arrange
		RegistroVehiculo registroVehiculo = new RegistroVehiculo(1, "MOTO", "XDX06C", "125", new Date(), null, 0);
		
		
		RepositorioRegistroVehiculo repositorioRegistroVehiculo = mock(RepositorioRegistroVehiculo.class);
		when(repositorioRegistroVehiculo.consultarCantidadCarro()).thenReturn(10);
	
		RegistroServicio registroServicio = new RegistroServicio(repositorioRegistroVehiculo);
		// Action
		try {
			Boolean permitirIngresoMoto = registroServicio.recibirMoto(registroVehiculo);
		
		} catch (ExceptionCupoParqueaderoMoto e) {
			//assert
			Assert.assertEquals(EL_PARQUEADERO_NO_TIENE_CUPO_MOTO, e.getMessage());
		}
	}
}
