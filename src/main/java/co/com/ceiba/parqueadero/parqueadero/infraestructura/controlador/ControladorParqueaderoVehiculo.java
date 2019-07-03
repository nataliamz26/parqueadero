package co.com.ceiba.parqueadero.parqueadero.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorConsultarParqueadero;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorGestionarParqueadero;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCilindrajeRequerido;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCupoParqueaderoCarro;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionCupoParqueaderoMoto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionPlaca;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionPlacaConLetraA;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculo;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExceptionTipoVehiculoIncorrecto;


@RestController
@RequestMapping("/parqueadero")
@CrossOrigin("*")
public class ControladorParqueaderoVehiculo {

	private ManejadorGestionarParqueadero manejadorGestionarParqueadero;
    private ManejadorConsultarParqueadero manejadorConsultarParqueadero;

    @Autowired
    public void ControladorParqueaderoVehiculo(ManejadorGestionarParqueadero manejadorGestionarParqueadero, ManejadorConsultarParqueadero manejadorConsultarParqueadero){
        this.manejadorGestionarParqueadero = manejadorGestionarParqueadero;
        this.manejadorConsultarParqueadero = manejadorConsultarParqueadero;
    }

    @RequestMapping(method= RequestMethod.GET)
    public int consultarCantidadCarro() {
        return this.manejadorConsultarParqueadero.consultarCantidadCarro();
    }

    @PostMapping
    public void recibirCarro(@RequestBody ComandoRegistroVehiculo comandoRegistroVehiculo) throws ExceptionPlacaConLetraA, ExceptionCupoParqueaderoCarro, ExceptionPlaca, ExceptionTipoVehiculo, ExceptionTipoVehiculoIncorrecto, ExceptionCilindrajeRequerido, ExceptionCilindrajeIncorrecto {
        this.manejadorGestionarParqueadero.recibirCarro(comandoRegistroVehiculo);
    }

    @RequestMapping(method= RequestMethod.GET)
    public int consultarCantidadMoto() {
        return this.manejadorConsultarParqueadero.consultarCantidadMoto();
    }

    @PostMapping
    public void recibirMoto(@RequestBody ComandoRegistroVehiculo comandoRegistroVehiculo) throws ExceptionPlacaConLetraA, ExceptionCupoParqueaderoMoto, ExceptionPlaca, ExceptionTipoVehiculo, ExceptionTipoVehiculoIncorrecto, ExceptionCilindrajeRequerido, ExceptionCilindrajeIncorrecto {
        this.manejadorGestionarParqueadero.recibirMoto(comandoRegistroVehiculo);
    }

}
