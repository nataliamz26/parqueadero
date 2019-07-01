package co.com.ceiba.parqueadero.parqueadero.dominio.servicio;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.CupoParqueaderoException;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.PlacaConLetraAException;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.SolicitudIngresoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioParqueadero;



public class VigilanteTest {
	
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO = "El Parqueadero no tiene cupo";
	
	@Test
	public void solitudIngresoCarroParqueaderoVacio() throws PlacaConLetraAException, CupoParqueaderoException {
		// Arrange
		SolicitudIngresoCarro solicitudIngresoCarro = new SolicitudIngresoCarro("BCD123");

		
		RepositorioParqueadero repositorioParqueadero = mock(RepositorioParqueadero.class);
		when(repositorioParqueadero.consultarCantidadCarros()).thenReturn(0);
	
	
		Vigilante vigilante = new Vigilante(repositorioParqueadero);
		// Action
		Boolean permitirIngresoCarro = vigilante.recibirCarro(solicitudIngresoCarro);
		// Assert
		assertTrue(permitirIngresoCarro);
	}
	
	@Test
	public void solitudIngresoCarroParqueaderoLleno() throws PlacaConLetraAException {
		// Arrange
		SolicitudIngresoCarro solicitudIngresoCarro = new SolicitudIngresoCarro("BCD123");
		
		
		RepositorioParqueadero repositorioParqueadero = mock(RepositorioParqueadero.class);
		when(repositorioParqueadero.consultarCantidadCarros()).thenReturn(20);
	
		Vigilante vigilante = new Vigilante(repositorioParqueadero);
		// Action
		try {
			Boolean permitirIngresoCarro = vigilante.recibirCarro(solicitudIngresoCarro);
			fail();
		} catch (CupoParqueaderoException e) {
			//assert
			Assert.assertEquals(EL_PARQUEADERO_NO_TIENE_CUPO, e.getMessage());
		}
	}
}
