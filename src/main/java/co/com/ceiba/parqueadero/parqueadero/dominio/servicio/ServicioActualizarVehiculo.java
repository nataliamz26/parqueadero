package co.com.ceiba.parqueadero.parqueadero.dominio.servicio;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoNoExiste;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.ValidadorArgumento;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;

@Component
public class ServicioActualizarVehiculo {

	private static final String EL_VEHICULO_NO_EXISTE = "El vehiculo no se encuentra en el parqueadero";
	private static final String MENSAJE_PLACA_REQUERIDA = "La placa es un dato obligatorio.";
	private static final float PRECIO_HORA_CARRO = 1000;
	private static final float PRECIO_DIA_CARRO = 8000;
	private static final float PRECIO_HORA_MOTO = 500;
	private static final float PRECIO_DIA_MOTO = 4000;
	private static final float PRECIO_ALTO_CILINDRAJE_MOTO = 2000;
	private static final String TIPO_VEHICULO_CARRO = "CARRO";
	private static final String TIPO_VEHICULO_MOTO = "MOTO";
	
	private RepositorioVehiculo repositorioVehiculo;
	
	public ServicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}

	public float registroSalidaVehiculo(String placa) {
		ValidadorArgumento.validarRequerido(placa, MENSAJE_PLACA_REQUERIDA);
		Vehiculo vehiculo = validarRegistroVehiculo(placa);
		vehiculo.setEstado(false);
		vehiculo.setFechaSalida(Calendar.getInstance().getTime());
		vehiculo.setPrecio(calcularPrecio(vehiculo));
		this.repositorioVehiculo.registroSalidaVehiculo(vehiculo);
		return vehiculo.getPrecio();
		
	}


	private Vehiculo validarRegistroVehiculo(String placa) {
		Vehiculo vehiculo = this.repositorioVehiculo.retornoSalidaVehiculo(placa);
		if(vehiculo == null) {
			throw new ExcepcionVehiculoNoExiste(EL_VEHICULO_NO_EXISTE);
		}
		return vehiculo;
	}
	
	private float calcularPrecio(Vehiculo vehiculo) {
		float precio = 0;
		long tiempoServicio = vehiculo.getFechaSalida().getTime() - vehiculo.getFechaIngreso().getTime();
		long minutos = TimeUnit.MILLISECONDS.toMinutes(tiempoServicio);
		tiempoServicio = TimeUnit.MILLISECONDS.toHours(tiempoServicio);
		long dias = (tiempoServicio / 24);
		long horasSobrantes = (tiempoServicio-(dias*24));
		if(minutos%60 > 0) {
			horasSobrantes++;
		}
		if(horasSobrantes >= 9) {
			dias++;
			horasSobrantes = 0;
		}
		if(horasSobrantes == 0 && dias == 0) {
			horasSobrantes = 1;
		}
		if(vehiculo.getTipoVehiculo().equalsIgnoreCase(TIPO_VEHICULO_CARRO)) {
			precio += dias * PRECIO_DIA_CARRO;
			precio += horasSobrantes * PRECIO_HORA_CARRO;
		}
		if(vehiculo.getTipoVehiculo().equalsIgnoreCase(TIPO_VEHICULO_MOTO)) {
			precio += dias * PRECIO_DIA_MOTO;
			precio += horasSobrantes * PRECIO_HORA_MOTO;
			if(Integer.parseInt(vehiculo.getCilindraje()) > 500) {
				precio += PRECIO_ALTO_CILINDRAJE_MOTO;
			}
		}
		return precio;
	}
	
	
	
	
}
