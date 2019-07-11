package co.com.ceiba.parqueadero.parqueadero.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.consulta.ConsultarVehiculoActivo;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;


public interface RepositorioVehiculo {
	
	/**
     *Metodo que permite registrar el ingreso de un vehiculo
     *
     * @param  Objeto que tiene la informacion del registro a crear
     */
	public Vehiculo registroIngresoVehiculo(Vehiculo vehiculo);
	
	/**
     * Permite listar los registros de vehiculos
     *
     * @return
     */
     public List<ConsultarVehiculoActivo> consultarVehiculo();

     /**
 	 * Metodo que registra la finalizalion de un ticket
 	 * 
 	 * @param ticket a finalizar
 	 * @return boolean con true si se finalizo correctamente y false si no
 	 */
 	public boolean registroSalidaVehiculo(Vehiculo vehiculo);

      /**
      * Metodo que valida si un vehiculo ya se encuentra en el parqueadero
      * 
      * @param placa de vehiculo a verificar
      * @return boolean con la respuesta si se encontro el vehiculo en el parqueadero
      */  
	public boolean validarSalidaVehiculo(String placa);
	
	
		
	/**
	 * Metodo que retorna un vehiculo del parqueadero que aun no ha salido
	 * 
	 * @param placa de vehiculo a verificar
	 * @return ticket con la respuesta si se encontro el vehiculo con ticket activo
	 */
	public Vehiculo retornoSalidaVehiculo(String placa);
	 
   	 /**
     * Metodo que permite contar la cantidad de carros en el paquedero
     *
     * @return int con la candidad de vehiculo
     */
	public int contarCarro();
    
	 /**
     * Metodo que permite contar la cantidad de motos en el paquedero
     *
     * @return int con la candidad de vehiculo
     */
	public int contarMoto();
  
	
}
