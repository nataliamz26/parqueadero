package co.com.ceiba.parqueadero.parqueadero.dominio.modelo;

import java.util.Date;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;

public class Vehiculo {
	
	 private static final String MENSAJE_PLACA_REQUERIDA = "La placa es un dato obligatorio.";
	 private static final String MENSAJE_TIPO_VEHICULO_REQUERIDO = "El tipo vehículo es un dato obligatorio.";
	 private static final String MENSAJE_TIPO_VEHICULO_INCORRECTO = "El campo tipo vehículo (%S) no es valido para el sistema.";
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
	
	
	public Vehiculo(Integer id, String tipoVehiculo, String placa, String cilindraje, Date fechaIngreso, Date fechaSalida, long valor) throws ExcepcionPlaca, ExcepcionTipoVehiculo, ExcepcionCilindrajeIncorrecto, ExcepcionTipoVehiculoIncorrecto, ExcepcionCilindrajeRequerido {
		
	      	ValidadorArgumento.validarPlaca(placa, MENSAJE_PLACA_REQUERIDA);
	        ValidadorArgumento.validarTipoVehiculo(tipoVehiculo, MENSAJE_TIPO_VEHICULO_REQUERIDO);

	        if(!tipoVehiculo.contentEquals(TIPO_VEHICULO_CARRO) && !tipoVehiculo.contentEquals(TIPO_VEHICULO_MOTO)) {
	            ValidadorArgumento.validarTipoVehiculoIncorrecto(String.format(MENSAJE_TIPO_VEHICULO_INCORRECTO, tipoVehiculo));
	        }
	        if (tipoVehiculo.equalsIgnoreCase(TIPO_VEHICULO_MOTO)) {
	        	ValidadorArgumento.validarCilindrajeRequerido(cilindraje, MENSAJE_CILINDRAJE_REQUERIDO);
	        	ValidadorArgumento.validarCilindrajeIncorrecto(cilindraje, MENSAJE_CILINDRAJE_INCORRECTO);
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

	public String getPlaca() {
		return this.placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
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
