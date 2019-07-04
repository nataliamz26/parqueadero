package co.com.ceiba.parqueadero.parqueadero.dominio.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParqueaderoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParqueaderoMoto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlacaConLetraA;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoExiste;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;


public class ServicioCrearVehiculo {
	
	private static final String EL_VEHICULO_NO_PUEDE_INGRESAR = "No está autorizado a ingresar solo puede ingresar los Domingos y Lunes";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_CARRO = "El Parqueadero no tiene cupo para carro";
	private static final String EL_PARQUEADERO_NO_TIENE_CUPO_MOTO = "El Parqueadero no tiene cupo para moto";
	private static final String EL_VEHICULO_EXISTE = "El vehiculo se encuentra en el parqueadero";
	private static final String EL_VEHICULO_NO_EXISTE = "El vehiculo no se encuentra en el parqueadero";
	
	private static final int CAPACIDAD_MAXIMA_CARRO = 20;
	private static final int CAPACIDAD_MAXIMA_MOTO = 10;

	//Inyección de dependencias por constructor
	private RepositorioVehiculo repositorioVehiculo;
	

	public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}
	
	public void registrarVehiculo(Vehiculo vehiculo) throws ExcepcionVehiculoExiste {
		validarExistenciaPrevia(vehiculo);
		this.repositorioVehiculo.crear(vehiculo);
	}
	
	
	private void validarExistenciaPrevia(Vehiculo vehiculo) throws ExcepcionVehiculoExiste {
		boolean existe = this.repositorioVehiculo.existe(vehiculo);
		if(existe) {
			throw new ExcepcionVehiculoExiste(EL_VEHICULO_EXISTE);
		}
		
	}

	
		
	public Boolean recibirCarro(Vehiculo vehiculo) throws ExcepcionPlacaConLetraA, ExcepcionCupoParqueaderoCarro {
		// Validaciones
		if (vehiculo.getPlaca().substring(0,1).equals("A") && (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) > 2)) {
			throw new ExcepcionPlacaConLetraA(EL_VEHICULO_NO_PUEDE_INGRESAR);			
		}
		if (repositorioVehiculo.contarCarro(null)==CAPACIDAD_MAXIMA_CARRO) {
			throw new ExcepcionCupoParqueaderoCarro(EL_PARQUEADERO_NO_TIENE_CUPO_CARRO);
		}
		repositorioVehiculo.almacenarCarro(vehiculo);
		return true;
	}

	public Boolean recibirMoto(Vehiculo vehiculo) throws ExcepcionPlacaConLetraA, ExcepcionCupoParqueaderoMoto {
		//Validaciones
		if (vehiculo.getPlaca().substring(0,1).equals("A") && (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) > 2)) {
			throw new ExcepcionPlacaConLetraA(EL_VEHICULO_NO_PUEDE_INGRESAR);
		}
		if (repositorioVehiculo.contarMoto(null)==CAPACIDAD_MAXIMA_MOTO) {
			throw new ExcepcionCupoParqueaderoMoto(EL_PARQUEADERO_NO_TIENE_CUPO_MOTO);
		}
		repositorioVehiculo.almacenarMoto(vehiculo);
		return true;
	}

	/*public void recibirMoto1(Vehiculo vehiculo) {
		boolean existe = repositorioVehiculo
		
	}*/
	
	
	
	public long SetExit(String placa){
	        return 0;
	    }

	    public List<Vehiculo> listarVehiculo() {
	        return repositorioVehiculo.listar();
	    }

		public void recibirMoto(Integer id, String tipoVehiculo, String placa, String cilindraje, Date fechaIngreso,
				Date fechaSalida, long valor) {
			// TODO Auto-generated method stub
			
		}

	


	
	
	
	
	
}
