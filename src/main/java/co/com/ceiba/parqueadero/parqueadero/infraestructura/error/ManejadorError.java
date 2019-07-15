package co.com.ceiba.parqueadero.parqueadero.infraestructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionCupoParquederoLleno;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoNoPuedeIngresar;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionTipoVehiculoIncorrecto;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionValidadorArgumento;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoExiste;
import co.com.ceiba.parqueadero.parqueadero.dominio.excepcion.ExcepcionVehiculoNoExiste;



@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler  {

	private static final Logger EXCEPCIONES = LoggerFactory.getLogger(ManejadorError.class);
	private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";
	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();
	
	public ManejadorError() {
		CODIGOS_ESTADO.put(ExcepcionValidadorArgumento.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_ESTADO.put(ExcepcionCupoParquederoLleno.class.getSimpleName(), HttpStatus.FORBIDDEN.value());
		CODIGOS_ESTADO.put(ExcepcionVehiculoNoPuedeIngresar.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
        CODIGOS_ESTADO.put(ExcepcionTipoVehiculoIncorrecto.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionVehiculoExiste.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
        CODIGOS_ESTADO.put(ExcepcionVehiculoNoExiste.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception exception){
		ResponseEntity<Error> resultado;
		
		String excepcionNombre = exception.getClass().getSimpleName();
		String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);
        
        if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
        	EXCEPCIONES.error(excepcionNombre, exception);
            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resultado;
        
	}
}
