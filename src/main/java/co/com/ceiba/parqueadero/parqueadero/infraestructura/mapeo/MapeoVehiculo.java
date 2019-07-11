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
	
	
	public Vehiculo convertirADominio(EntidadVehiculo entidad) {
		Vehiculo dominio = new Vehiculo();
		dominio.setId(entidad.getId());
		dominio.setTipoVehiculo(entidad.getTipoVehiculo());
		dominio.setPlaca(entidad.getPlaca());
		dominio.setCilindraje(entidad.getCilindraje());
		dominio.setFechaIngreso(entidad.getFechaIngreso());
		dominio.setFechaSalida(entidad.getFechaSalida());
		dominio.setPrecio(entidad.getPrecio());
		dominio.setEstado(entidad.isEstado());
		return dominio;
	}

	public EntidadVehiculo convertirAEntidad(Vehiculo dominio) {
		EntidadVehiculo entidad = new EntidadVehiculo();	
		entidad.setId(dominio.getId());
		entidad.setTipoVehiculo(dominio.getTipoVehiculo());
		entidad.setPlaca(dominio.getPlaca());
		entidad.setCilindraje(dominio.getCilindraje());
		entidad.setFechaIngreso(dominio.getFechaIngreso());
		entidad.setFechaSalida(dominio.getFechaSalida());
		entidad.setPrecio(dominio.getPrecio());
		entidad.setEstado(dominio.isEstado());
		return entidad;
	}	
		
	
	
}
