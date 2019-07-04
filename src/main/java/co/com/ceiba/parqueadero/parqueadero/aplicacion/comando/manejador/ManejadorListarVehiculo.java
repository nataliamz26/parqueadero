package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador;

import java.util.List;

import org.springframework.stereotype.Component;


import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.repositorio.RepositorioVehiculo;

@Component
public class ManejadorListarVehiculo {
	
	private final RepositorioVehiculo repositorioVehiculo;

	
	public ManejadorListarVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}

    public List<Vehiculo> listarVehiculo(){
        return this.repositorioVehiculo.listar();
    }

	public int contarCarro() {
		// TODO Auto-generated method stub
		return 0;
	}
        
	

	
}
