package co.com.ceiba.parqueadero.parqueadero.dominio.testdatabuilder;

import java.util.Date;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;


public class VehiculoTestDataBuilder {

	private Integer id;
	private String tipoVehiculo;
	private String placa;
	private String cilindraje;
	private Date  fechaIngreso;
	private Date fechaSalida;
	private long valor;
	
	
	public VehiculoTestDataBuilder() {
		
		this.id = 1;
		this.tipoVehiculo = "CARRO";
		this.placa = "XDX123";
		this.cilindraje = null;
		this.fechaIngreso = new Date();
		this.fechaSalida = null;
		this.valor = 0;
	}
	
	public VehiculoTestDataBuilder conId(Integer id) {
		this.id = id;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public VehiculoTestDataBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public VehiculoTestDataBuilder conFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public VehiculoTestDataBuilder conValor(Long valor) {
		this.valor = valor;
		return this;
	}
	
	public Vehiculo build() throws ExcepcionPlaca, ExcepcionTipoVehiculo, ExcepcionCilindrajeIncorrecto, ExcepcionTipoVehiculoIncorrecto, ExcepcionCilindrajeRequerido  {
		return new Vehiculo(id, tipoVehiculo, placa, cilindraje, fechaIngreso, fechaSalida, valor);
	}
	
}
