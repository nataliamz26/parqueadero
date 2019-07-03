package co.com.ceiba.parqueadero.parqueadero.dominio.modelo;

import java.util.Date;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculoIncorrecto;


public class RegistroVehiculo {
	
	 private static final String MENSAJE_PLACA_REQUERIDA = "La placa es un dato obligatorio.";
	 private static final String MENSAJE_TIPO_VEHICULO_REQUERIDO = "El tipo vehículo es un dato obligatorio.";
	 private static final String MENSAJE_TIPO_VEHICULO_INCORRECTO = "El campo tipo vehículo no es valido para el sistema.";
	 private static final String MENSAJE_CILINDRAJE_REQUERIDO = "El campo cilindraje es un dato obligatorio para moto.";
	 private static final String MENSAJE_CILINDRAJE_INCORRECTO  = "El campo cilindraje debe ser numérico.";

	 private static final String TIPO_VEHICULO_CARRO = "CARRO";
	 private static final String TIPO_VEHICULO_MOTO = "MOTO";

	private Integer id;
	private String tipoVehiculo;
	private String placa;
	private String cilindraje;
	private Date  fechaIngreso;
	private Date fechaSalida;
	private long valor;
	
	
	public RegistroVehiculo(Integer id, String tipoVehiculo, String placa, String cilindraje, Date fechaIngreso, Date fechaSalida, long valor) throws ExceptionPlaca, ExceptionTipoVehiculo, ExceptionTipoVehiculoIncorrecto, ExceptionCilindrajeRequerido, ExceptionCilindrajeIncorrecto {
		
	      	Validador.validarPlaca(placa, MENSAJE_PLACA_REQUERIDA);
	        Validador.validarTipoVehiculo(tipoVehiculo, MENSAJE_TIPO_VEHICULO_REQUERIDO);

	        if(!tipoVehiculo.contentEquals(TIPO_VEHICULO_CARRO) && !tipoVehiculo.contentEquals(TIPO_VEHICULO_MOTO)) {
	            Validador.validarTipoVehiculoIncorrecto(String.format(MENSAJE_TIPO_VEHICULO_INCORRECTO, tipoVehiculo));
	        }
	        if (tipoVehiculo.equalsIgnoreCase(TIPO_VEHICULO_MOTO)) {
	        	Validador.validarCilindrajeRequerido(cilindraje, MENSAJE_CILINDRAJE_REQUERIDO);
	        	Validador.validarCilindrajeIncorrecto(cilindraje, MENSAJE_CILINDRAJE_INCORRECTO);
	        }

		
		this.id = id;
        this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return this.placa;
	}
	
	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}


}
