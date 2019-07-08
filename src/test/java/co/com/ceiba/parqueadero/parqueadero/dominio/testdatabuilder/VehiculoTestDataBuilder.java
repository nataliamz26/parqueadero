package co.com.ceiba.parqueadero.parqueadero.dominio.testdatabuilder;

import java.util.Date;


import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;


public class VehiculoTestDataBuilder {

	private long id;
	private String tipoVehiculo;
	private String placa;
	private String cilindraje;
	private Date  fechaIngreso;
	private Date fechaSalida;
	private float precio;
	private boolean estado;
	
	
	
	public VehiculoTestDataBuilder() {
		
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
	
	public VehiculoTestDataBuilder conPrecio(float precio) {
		this.precio = precio;
		return this;
	}
	
	public VehiculoTestDataBuilder conEstado(Boolean estado) {
		this.estado = estado;
		return this;
	}
	
	public Vehiculo build() {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setId(this.id);
		vehiculo.setTipoVehiculo(this.tipoVehiculo);
		vehiculo.setPlaca(this.placa);
		vehiculo.setCilindraje(this.cilindraje);
		vehiculo.setFechaIngreso(this.fechaIngreso);
		vehiculo.setFechaSalida(this.fechaSalida);
		vehiculo.setPrecio(this.precio);
		vehiculo.setEstado(this.estado);
		return vehiculo;
	}
	
}
