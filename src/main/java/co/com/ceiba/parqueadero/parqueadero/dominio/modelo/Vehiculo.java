package co.com.ceiba.parqueadero.parqueadero.dominio.modelo;

import java.util.Date;


public class Vehiculo {
	
	 private static final String MENSAJE_PLACA_REQUERIDA = "La placa es un dato obligatorio.";
	 private static final String MENSAJE_TIPO_VEHICULO_REQUERIDO = "El tipo vehículo es un dato obligatorio.";
	 private static final String MENSAJE_TIPO_VEHICULO_INCORRECTO = "El campo tipo vehículo no es valido para el sistema.";
	 private static final String MENSAJE_FECHA_ACTUAL_REQUERIDA = "La fecha actual es un dato obligatorio.";
	 private static final String MENSAJE_CILINDRAJE_REQUERIDO = "El campo cilindraje es un dato obligatorio para moto.";
	 private static final String TIPO_VEHICULO_MOTO = "MOTO";

	private long id;
	private String tipoVehiculo;
	private String placa;
	private String cilindraje;
	private Date  fechaIngreso;
	private Date fechaSalida;
	private float precio;
	private boolean estado;
	
	public Vehiculo(String tipoVehiculo, String placa, String cilindraje, Date fechaIngreso, Boolean estado) {
		ValidadorArgumento.validarRequerido(placa, MENSAJE_PLACA_REQUERIDA);
        ValidadorArgumento.validarRequerido(tipoVehiculo, MENSAJE_TIPO_VEHICULO_REQUERIDO);
        ValidadorArgumento.validarFechaRequerida(fechaIngreso, MENSAJE_FECHA_ACTUAL_REQUERIDA );
        ValidadorArgumento.validarTipoVehiculo(tipoVehiculo, MENSAJE_TIPO_VEHICULO_INCORRECTO);

        if (tipoVehiculo.equalsIgnoreCase(TIPO_VEHICULO_MOTO)) {
        	ValidadorArgumento.validarRequerido(cilindraje, MENSAJE_CILINDRAJE_REQUERIDO);
        	this.cilindraje = cilindraje;
        	
        }
        this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.estado = true;
	}

	public Vehiculo() {
		
	}

	public Vehiculo(String placa, String tipoVehiculo, String cilindraje, Date time) {
	
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTipoVehiculo() {
		return tipoVehiculo;
	}


	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


	public String getPlaca() {
		return placa;
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


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	

}
