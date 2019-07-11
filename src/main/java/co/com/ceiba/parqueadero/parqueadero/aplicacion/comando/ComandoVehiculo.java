package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoVehiculo {

	private String tipoVehiculo;
	private String placa;
	private String cilindraje;
}
