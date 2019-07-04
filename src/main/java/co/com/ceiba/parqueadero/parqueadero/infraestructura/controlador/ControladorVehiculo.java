package co.com.ceiba.parqueadero.parqueadero.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorListarVehiculo;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorCrearVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParqueaderoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParqueaderoMoto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionPlacaConLetraA;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoExiste;
import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;


@RestController
@RequestMapping("/vehiculo")
@CrossOrigin("Controlador vehiculo")
public class ControladorVehiculo {

	private ManejadorCrearVehiculo manejadorCrearVehiculo;
    private ManejadorListarVehiculo manejadorListarVehiculo;

    @Autowired
    public void ControladorVehiculo(ManejadorCrearVehiculo manejadorCrearVehiculo, ManejadorListarVehiculo manejadorListarParqueadero){
        this.manejadorCrearVehiculo = manejadorCrearVehiculo;
        this.manejadorListarVehiculo = manejadorListarParqueadero;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Vehiculo> listar(){
        return this.manejadorListarVehiculo.listarVehiculo();
    }

    @PostMapping
    public void Crear(@RequestBody ComandoVehiculo comandoVehiculo) throws ExcepcionPlacaConLetraA, ExcepcionCupoParqueaderoCarro, ExcepcionPlaca, ExcepcionTipoVehiculo, ExcepcionTipoVehiculoIncorrecto, ExcepcionCilindrajeRequerido, ExcepcionCilindrajeIncorrecto, ExcepcionVehiculoExiste {
        this.manejadorCrearVehiculo.registrarVehiculo(comandoVehiculo);
    }


}
