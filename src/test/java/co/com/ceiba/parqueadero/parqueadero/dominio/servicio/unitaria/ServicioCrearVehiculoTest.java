package co.com.ceiba.parqueadero.parqueadero.dominio.servicio.unitaria;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParqueaderoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParqueaderoMoto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlacaConLetraA;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.servicio.ServicioCrearVehiculo;



public class ServicioCrearVehiculoTest {
	
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_CARRO = "El Parqueadero no tiene cupo para carro";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_MOTO = "El Parqueadero no tiene cupo para moto";
	
	
	@Test
	public void registroIngresoCarroParqueaderoVacio() throws ExcepcionPlacaConLetraA, ExcepcionCupoParqueaderoCarro, ExcepcionPlaca, ExcepcionTipoVehiculo, ExcepcionTipoVehiculoIncorrecto, ExcepcionCilindrajeRequerido, ExcepcionCilindrajeIncorrecto {
		// Arrange
		Vehiculo registroVehiculo = new Vehiculo(1, "CARRO", "BCD123", null, new Date(), null, 0);

		
		RepositorioVehiculo repositorioRegistroVehiculo = mock(RepositorioVehiculo.class);
		when(repositorioRegistroVehiculo.contarCarro(null)).thenReturn(0);
	
	
		ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioRegistroVehiculo);
		// Action
		Boolean permitirIngresoCarro = servicioCrearVehiculo.recibirCarro(registroVehiculo);
		// Assert
		assertTrue(permitirIngresoCarro);
	}
	
	@Test
	public void registroIngresoCarroParqueaderoLleno() throws ExcepcionPlacaConLetraA, ExcepcionPlaca, ExcepcionTipoVehiculo, ExcepcionTipoVehiculoIncorrecto, ExcepcionCilindrajeRequerido, ExcepcionCilindrajeIncorrecto {
		// Arrange
		Vehiculo registroVehiculo = new Vehiculo(1, "CARRO", "BCD123", null, new Date(), null, 0);
		
		
		RepositorioVehiculo repositorioRegistroVehiculo = mock(RepositorioVehiculo.class);
		when(repositorioRegistroVehiculo.contarCarro(null)).thenReturn(20);
	
		ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioRegistroVehiculo);
		// Action
		try {
			Boolean permitirIngresoCarro = servicioCrearVehiculo.recibirCarro(registroVehiculo);
			fail();
		} catch (ExcepcionCupoParqueaderoCarro e) {
			//assert
			Assert.assertEquals(EL_PARQUEADERO_NO_TIENE_CUPO_CARRO, e.getMessage());
		}
	}
	

	
	@Test
	public void registroIngresoMotoParqueaderoVacio() throws ExcepcionPlacaConLetraA, ExcepcionCupoParqueaderoCarro, ExcepcionPlaca, ExcepcionTipoVehiculo, ExcepcionTipoVehiculoIncorrecto, ExcepcionCilindrajeRequerido, ExcepcionCilindrajeIncorrecto, ExcepcionCupoParqueaderoMoto {
		// Arrange
		Vehiculo registroVehiculo = new Vehiculo(1, "MOTO", "XDX06C", "125", new Date(), null, 0);

		
		RepositorioVehiculo repositorioRegistroVehiculo = mock(RepositorioVehiculo.class);
		when(repositorioRegistroVehiculo.contarMoto(null)).thenReturn(0);
	
	
		ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioRegistroVehiculo);
		
		// Action
		Boolean permitirIngresoMoto = servicioCrearVehiculo.recibirMoto(registroVehiculo);
		// Assert
		assertTrue(permitirIngresoMoto);
	}
	
	@Test
	public void registroIngresoMotoParqueaderoLleno() throws ExcepcionPlacaConLetraA, ExcepcionPlaca, ExcepcionTipoVehiculo, ExcepcionTipoVehiculoIncorrecto, ExcepcionCilindrajeRequerido, ExcepcionCilindrajeIncorrecto {
		// Arrange
		Vehiculo registroVehiculo = new Vehiculo(1, "MOTO", "XDX06C", "125", new Date(), null, 0);
		
		
		RepositorioVehiculo repositorioRegistroVehiculo = mock(RepositorioVehiculo.class);
		when(repositorioRegistroVehiculo.contarCarro(null)).thenReturn(10);
	
		ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioRegistroVehiculo);
		// Action
		try {
			Boolean permitirIngresoMoto = servicioCrearVehiculo.recibirMoto(registroVehiculo);
		
		} catch (ExcepcionCupoParqueaderoMoto e) {
			//assert
			Assert.assertEquals(EL_PARQUEADERO_NO_TIENE_CUPO_MOTO, e.getMessage());
		}
	}
}
