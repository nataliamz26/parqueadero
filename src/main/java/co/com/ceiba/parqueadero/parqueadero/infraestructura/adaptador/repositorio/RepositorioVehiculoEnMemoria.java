package co.com.ceiba.parqueadero.parqueadero.infraestructura.adaptador.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;
import co.com.ceiba.parqueadero.parqueadero.infraestructura.mapeo.MapeoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.infraestructura.modelo.EntidadVehiculo;

@Repository
public class RepositorioVehiculoEnMemoria implements RepositorioVehiculo {

	private IRepositorioVehiculoJPA repositorioVehiculoJPA;
	private MapeoVehiculo mapeoVehiclo; 
	
	public RepositorioVehiculoEnMemoria(IRepositorioVehiculoJPA repositorioVehiculoJPA, MapeoVehiculo mapeoVehiclo) {
		this.repositorioVehiculoJPA = repositorioVehiculoJPA;
        this.mapeoVehiclo = mapeoVehiclo;
	}
	

	
	@Override
	public void almacenarCarro(Vehiculo registroVehiculo) {
	
	}

	
	@Override
	public void almacenarMoto(Vehiculo registroVehiculo) {
		
	}

	@Override
	public void crear(Vehiculo vehiculo) {
		EntidadVehiculo entidadVehiculo = repositorioVehiculoJPA.save(mapeoVehiclo.convertirAEntidad(vehiculo));
        this.mapeoVehiclo.convertirADominio(entidadVehiculo);
		
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		EntidadVehiculo entidadVehiculo = repositorioVehiculoJPA.save(mapeoVehiclo.convertirAEntidad(vehiculo));
	     this.mapeoVehiclo.convertirADominio(entidadVehiculo);
		
	}

	@Override
	public List<Vehiculo> listar() {
		 final List<EntidadVehiculo> listarEntidadVehiculo = repositorioVehiculoJPA.listAll();
	     return mapeoVehiclo.listarConvertirADominio(listarEntidadVehiculo);
		
	}

	@Override
	public int contarTipoVehiculo(String tipoVehiculo) {
		return repositorioVehiculoJPA.contarTipoVehiculo(tipoVehiculo);
	}

	@Override
	public Vehiculo findByPlaca(String placa) {
		EntidadVehiculo entidadVehiculo = repositorioVehiculoJPA.findByPlaca(placa);
        return mapeoVehiclo.convertirADominio(entidadVehiculo);
	}

	@Override
	public boolean existe(Vehiculo vehiculo) {
		return repositorioVehiculoJPA.existe(vehiculo.getPlaca());
	}

	@Override
	public int contarCarro(String TipoVehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int contarMoto(String TipoVehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
