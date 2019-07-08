package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando.manejador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoVehiculo {

	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
}
