package co.com.ceiba.parqueadero.parqueadero.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParquederoLleno;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlacaConLetraA;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoExiste;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;


public class ServicioCrearVehiculo {
	
	private static final String EL_VEHICULO_NO_PUEDE_INGRESAR = "No está autorizado a ingresar, solo esta permitido el día Domingo y Lunes";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_CARRO = "El Parqueadero no tiene cupo para carro";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_MOTO = "El Parqueadero no tiene cupo para moto";
	private static final String EL_VEHICULO_EXISTE = "El vehiculo se encuentra en el parqueadero";
	private static final String PRIMERA_LETRA_PLACA = "A";
	
	private static final int CAPACIDAD_MAXIMA_CARRO = 20;
	private static final int CAPACIDAD_MAXIMA_MOTO = 10;
	private static final String TIPO_VEHICULO_CARRO = "CARRO";
	private static final String TIPO_VEHICULO_MOTO = "MOTO";

	//Inyección de dependencias por constructor
	private RepositorioVehiculo repositorioVehiculo;
	

	public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}
	
	public Vehiculo registroIngresoVehiculo(Vehiculo vehiculo) {
		validarRegistroVehiculo(vehiculo.getPlaca());
		validarCupoParqueadero(vehiculo.getTipoVehiculo());
		validarIngresoVehiculo(vehiculo.getPlaca(),vehiculo.getFechaIngreso());
		return this.repositorioVehiculo.registroIngresoVehiculo(vehiculo);
	}
	
	
	private void validarRegistroVehiculo(String placa) {
		boolean existe = this.repositorioVehiculo.validarSalidaVehiculo(placa);
		if(existe) {
			throw new ExcepcionVehiculoExiste(EL_VEHICULO_EXISTE);
		}
		
	}
	
	private void validarCupoParqueadero(String tipoVehiculo) {
		if(tipoVehiculo.equals(TIPO_VEHICULO_CARRO) && this.repositorioVehiculo.contarCarro() == CAPACIDAD_MAXIMA_CARRO) {
			throw new ExcepcionCupoParquederoLleno(EL_PARQUEADERO_NO_TIENE_CUPO_CARRO);
		}
		if(tipoVehiculo.equals(TIPO_VEHICULO_MOTO) && this.repositorioVehiculo.contarMoto() == CAPACIDAD_MAXIMA_MOTO) {
			throw new ExcepcionCupoParquederoLleno(EL_PARQUEADERO_NO_TIENE_CUPO_MOTO);
		}
		
	}
	

	private void validarIngresoVehiculo(String placa, Date date) {
		Calendar hoy = Calendar.getInstance();
		hoy.setTimeInMillis(date.getTime());
		int dia = hoy.get(Calendar.DAY_OF_WEEK);
		if (placa.startsWith(PRIMERA_LETRA_PLACA) && (dia > Calendar.MONDAY)) {
			throw new ExcepcionPlacaConLetraA(EL_VEHICULO_NO_PUEDE_INGRESAR);
		}
	}
	
}
