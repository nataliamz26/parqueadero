package co.com.ceiba.parqueadero.parqueadero.infraestructura.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import co.com.ceiba.parqueadero.parqueadero.infraestructura.entidad.EntidadVehiculo;



public interface IRepositorioVehiculoJPA extends CrudRepository<EntidadVehiculo, Integer>{
	
	 @Query("SELECT COUNT(id) FROM EntidadVehiculo v WHERE v.tipoVehiculo = :tipoVehiculo AND v.fechaSalida IS NULL")
	 int contarTipoVehiculo(@Param("vehicleType") String tipoVehiculo);

	 @Query("SELECT v FROM EntidadVehiculo v WHERE v.placa = :placa")
	 EntidadVehiculo findByPlaca(@Param("placa") String placa);

	 @Query("SELECT v FROM EntidadVehiculo v WHERE v.fechaSalida IS NULL")
	 List<EntidadVehiculo> listAll();

	 @Query("SELECT CASE WHEN COUNT(v.id) > 0 THEN true ELSE false END FROM EntidadVehiculo v WHERE v.placa = :placa AND v.fechaSalida IS NULL")
	 boolean existe(@Param("placa") String placa);

}
