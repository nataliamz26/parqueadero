package co.com.ceiba.parqueadero.parqueadero.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;

public interface RepositorioVehiculo {
	
	/**
     *Metodo que permite registrar el ingreso de un vehiculo
     *
     * @param  Objeto que tiene la informacion del registro a crear
     */
	public Vehiculo registroIngresoVehiculo(Vehiculo vehiculo);

      

      /**
      * Método que verifica si un vehiculo ya se encuentra en el parqueadero
      * 
      * @param placa de vehiculo a verificar
      * @return boolean con la respuesta si se encontro el vehiculo en el parqueadero
      */  
	public boolean validarSalidaVehiculo(String placa);
	
	
	
	public void registroSalidaVehiculo(Vehiculo vehiculo);
	
	
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

	
	
	
	
	
	
	
	
	
	

    /**
     * Permite determinar si previamente se registro la placa
     * @param Vehiculo
     * @return si existe o no
     */
	
	  boolean existe(Vehiculo vehiculo);

	 /**
     *Actualizar el registro un vehiculo
     *
     * @param  Objeto que tiene la informacion del registro a actualizar
     */

    void actualizar(Vehiculo vehiculo);

    /**
     * Permite listar los registros de vehiculos
     *
     * @return
     */
     List<Vehiculo> listar();

    /**
     * Permite contar la lista de vehiculos de un tipo
     *
     * @param String con el tipo de vehicluo
     * @return int con la candida de vehiculo
     */
     int contarTipoVehiculo(String TipoVehiculo);

    /**
     * Permite buscar un vehiculo por su placa
     *  @param  Placa del vehiculo
     * @return Objeto de registro
     */
     Vehiculo findByPlaca(String placa);







	



	







	




     


	

	
		
	
	
   
	
}
