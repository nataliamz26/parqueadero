package co.com.ceiba.parqueadero.parqueadero.dominio.modelo.unitaria;

import org.junit.Test;


import co.com.ceiba.parqueadero.parqueadero.dominio.BasePrueba;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.testdatabuilder.VehiculoTestDataBuilder;


public class VehiculoTest {
	
	@Test
	public void validarPlacaObligatorio() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conPlaca(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> {
			try {
				return vehiculoTestDataBuilder.build();
			} catch (ExcepcionPlaca e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculo e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculoIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeRequerido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		},ExcepcionPlaca.class, "La placa es un dato obligatorio");
	}
	
	@Test
	public void validarTipoVehiculoObligatorio() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conTipoVehiculo(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> {
			try {
				return vehiculoTestDataBuilder.build();
			} catch (ExcepcionPlaca e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculo e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculoIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeRequerido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		},ExcepcionTipoVehiculo.class, "El tipo vehículo es un dato obligatorio.");
	}
	
	
	 @Test
	 public void validarTipoVehiculoIncorrecto() {
	    //Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conTipoVehiculo("AUTO");

	    //Act - Assert
		BasePrueba.assertThrows(() -> {
			try {
				return vehiculoTestDataBuilder.build();
			} catch (ExcepcionPlaca e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculo e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculoIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeRequerido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		},ExcepcionTipoVehiculoIncorrecto.class,"El campo tipo vehículo (AUTO) no es valido para el sistema.");
	    }
	
	 
		 
	  @Test
	  public void  validarCilindrajeRequerido() {
	     //Arrange
		 VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		 vehiculoTestDataBuilder.conTipoVehiculo("MOTO");
		 vehiculoTestDataBuilder.conCilindraje(null);
	   
	     //Act - Assert
		 BasePrueba.assertThrows(() -> {
			try {
				return vehiculoTestDataBuilder.build();
			} catch (ExcepcionPlaca e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculo e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculoIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeRequerido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}, ExcepcionCilindrajeRequerido.class,"El campo cilindraje es un dato obligatorio para moto.");
	    }
	 
	  @Test
	  public void validarCilindrajeIncorrecto() {
	     //Arrange
		 VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		 vehiculoTestDataBuilder.conTipoVehiculo("MOTO");
		 vehiculoTestDataBuilder.conCilindraje("cien");

	     //Act - Assert
		 BasePrueba.assertThrows(() -> {
			try {
				return vehiculoTestDataBuilder.build();
			} catch (ExcepcionPlaca e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculo e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionTipoVehiculoIncorrecto e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionCilindrajeRequerido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}, ExcepcionCilindrajeIncorrecto.class,"El campo cilindraje debe ser numérico.");
	    }
	
	 
	 	  
}
