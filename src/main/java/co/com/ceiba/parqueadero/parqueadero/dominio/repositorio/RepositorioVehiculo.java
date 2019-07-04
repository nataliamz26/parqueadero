package co.com.ceiba.parqueadero.parqueadero.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;

public interface RepositorioVehiculo {
	
	/**
     *Registra el ingreso de un vehiculo
     *
     * @param  Objeto que tiene la informacion del registro a crear
     */
     void crear(Vehiculo vehiculo);

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

    /**
     * Permite determinar si previamente se registro la placa
     * @param Vehiculo
     * @return si existe o no
     */
     boolean existe(Vehiculo vehiculo);
     
     

	int contarCarro(String TipoVehiculo);

	void almacenarCarro(Vehiculo vehiculo);

	int contarMoto(String TipoVehiculo);

	void almacenarMoto(Vehiculo vehiculo);

	

	
		
	
	
   
	
}
