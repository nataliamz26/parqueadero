package co.com.ceiba.parqueadero.parqueadero.infraestructura.mapeo;



import co.com.ceiba.parqueadero.parqueadero.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueadero.infraestructura.modelo.EntidadVehiculo;


public final class MapeoVehiculo {

	private MapeoVehiculo() {
		
	}
	
	private static final MapeoVehiculo INSTANCIA = new MapeoVehiculo(); 


	public static MapeoVehiculo getInstance() {
		
		return INSTANCIA;
	}
	
	
	public Vehiculo convertirADominio(EntidadVehiculo entidadVehiculo) {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setId(entidadVehiculo.getId());
		vehiculo.setTipoVehiculo(entidadVehiculo.getTipoVehiculo());
		vehiculo.setPlaca(entidadVehiculo.getPlaca());
		vehiculo.setCilindraje(entidadVehiculo.getCilindraje());
		vehiculo.setFechaIngreso(entidadVehiculo.getFechaIngreso());
		vehiculo.setFechaSalida(entidadVehiculo.getFechaSalida());
		vehiculo.setPrecio(entidadVehiculo.getPrecio());
		vehiculo.setEstado(entidadVehiculo.isEstado());
		return vehiculo;
	}

	public EntidadVehiculo convertirAEntidad(Vehiculo vehiculo) {
		EntidadVehiculo entidadVehiculo = new EntidadVehiculo();	
		entidadVehiculo.setId(vehiculo.getId());
		entidadVehiculo.setTipoVehiculo(vehiculo.getTipoVehiculo());
		entidadVehiculo.setPlaca(vehiculo.getPlaca());
		entidadVehiculo.setCilindraje(vehiculo.getCilindraje());
		entidadVehiculo.setFechaIngreso(vehiculo.getFechaIngreso());
		entidadVehiculo.setFechaSalida(vehiculo.getFechaSalida());
		entidadVehiculo.setPrecio(vehiculo.getPrecio());
		entidadVehiculo.setEstado(vehiculo.isEstado());
		return entidadVehiculo;
	}	
		
	
	
}
