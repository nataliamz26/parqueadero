package co.com.ceiba.parqueadero.parqueadero.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoResultado;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ComandoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorActualizarVehiculo;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorCrearVehiculo;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.consulta.ConsultarVehiculoActivo;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.consulta.ManejadorConsultarVehiculo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/parqueadero")
@Api(tags = { " Controlador vehiculo" })
public class ControladorVehiculo {

	private final ManejadorCrearVehiculo manejadorCrearVehiculo;
	private final ManejadorActualizarVehiculo manejadorActualizarVehiculo;
	private final ManejadorConsultarVehiculo manejadorConsultarVehiculo; 
		

    @Autowired
    public ControladorVehiculo(ManejadorCrearVehiculo manejadorCrearVehiculo,
    		ManejadorActualizarVehiculo manejadorActualizarVehiculo,
    		ManejadorConsultarVehiculo manejadorConsultarVehiculo) {
    	this.manejadorCrearVehiculo = manejadorCrearVehiculo;
    	this.manejadorActualizarVehiculo = manejadorActualizarVehiculo;
    	this.manejadorConsultarVehiculo = manejadorConsultarVehiculo;
	}

	@PostMapping
	@ApiOperation("Guardar Vehiculo")
    public ComandoResultado<ComandoVehiculo> post(@RequestBody ComandoVehiculo comandoVehiculo) {
        return manejadorCrearVehiculo.exec(comandoVehiculo); 
    }
    
	@PutMapping()
	@ApiOperation("Actualizar Vehiculo")
	public ComandoResultado<Float> put(@RequestBody ComandoVehiculo comandoVehiculo) {
		return this.manejadorActualizarVehiculo.exec(comandoVehiculo.getPlaca());
	}
	
	
  @GetMapping
  @ApiOperation("Consultar Vehiculo")
    public List<ConsultarVehiculoActivo> get(){
        return this.manejadorConsultarVehiculo.exec();
    }

    




}
