package co.com.ceiba.parqueadero.parqueadero.infraestructura.adaptador.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.consulta.ConsultarVehiculoActivo;
import co.com.ceiba.parqueadero.parqueadero.infraestructura.modelo.EntidadVehiculo;



public interface RepositorioVehiculoJPA extends CrudRepository<EntidadVehiculo, Integer>{
	

	 @Query("SELECT v FROM EntidadVehiculo v WHERE v.estado = true AND v.placa = :placa")
	 EntidadVehiculo findByPlaca(@Param("placa") String placa);

	 @Query("SELECT new co.com.ceiba.parqueadero.parqueadero.aplicacion.consulta.ConsultarVehiculoActivo(v.placa,v.fechaIngreso,v.tipoVehiculo) FROM EntidadVehiculo v WHERE v.estado = true")
	 List<ConsultarVehiculoActivo> vehiculoActivo();

	 @Query("SELECT COUNT(*) FROM EntidadVehiculo v WHERE v.tipoVehiculo = 'CARRO' AND v.estado = true")
	 int contarCarro();

	 @Query("SELECT COUNT(*) FROM EntidadVehiculo v WHERE v.tipoVehiculo = 'MOTO' AND v.estado = true")
	 int contarMoto();



}
