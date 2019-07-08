package co.com.ceiba.parqueadero.parqueadero.infraestructura.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VEHICULO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntidadVehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "tipo_vehiculo", nullable = false)
	private String tipoVehiculo;
	
	@Column(name = "placa", nullable = false)
	private String placa;
	
	@Column(name = "cilindraje", nullable = true)
	private String cilindraje;
	
	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ingreso", nullable = false) 
	private Date fechaIngreso;
	
	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_salida", nullable = true)
	private Date fechaSalida;
	
	@Column(name = "precio", nullable = true) 
	private float precio;
	
	@Column(name = "estado", nullable = false)
	private boolean estado; 
	
}
