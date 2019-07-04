package co.com.ceiba.parqueadero.parqueadero.infraestructura.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "VEHICULO")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EntidadVehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column 
	private String tipoVehiculo;
	@Column
	private String placa;
	@Column
	private String cilindraje;
	@Column 
	private Date fechaIngreso;
	@Column 
	private Date fechaSalida;
	@Column 
	private long valor;
	
	
	public String getTipoVehiculo() {
		// TODO Auto-generated method stub
		return null;
	}


	




}
