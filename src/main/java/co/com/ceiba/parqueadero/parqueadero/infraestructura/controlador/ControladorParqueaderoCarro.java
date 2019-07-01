package co.com.ceiba.parqueadero.parqueadero.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.ComandoSolicitudIngresoCarro;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorConsultarParqueadero;
import co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador.ManejadorGestionarParqueadero;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.CupoParqueaderoException;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.PlacaConLetraAException;


@RestController
@RequestMapping("/parqueadero/carro")
@CrossOrigin("*")
public class ControladorParqueaderoCarro {

	private ManejadorGestionarParqueadero manejadorGestionarParqueadero;
    private ManejadorConsultarParqueadero manejadorConsultarParqueadero;

    @Autowired
    public void ParkingController(ManejadorGestionarParqueadero manejadorGestionarParqueadero, ManejadorConsultarParqueadero manejadorConsultarParqueadero){
        this.manejadorGestionarParqueadero = manejadorGestionarParqueadero;
        this.manejadorConsultarParqueadero = manejadorConsultarParqueadero;
    }

    @RequestMapping(method= RequestMethod.GET)
    public int consultarCantidadCarros() {
        return this.manejadorConsultarParqueadero.consultarCantidadCarros();
    }

    @PostMapping
    public void recibirCarro(@RequestBody ComandoSolicitudIngresoCarro comandoSolicitudIngresoCarro) throws PlacaConLetraAException, CupoParqueaderoException {
        this.manejadorGestionarParqueadero.recibirCarro(comandoSolicitudIngresoCarro);
    }

	
}
