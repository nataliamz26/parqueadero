package co.com.ceiba.parqueadero.parqueadero.aplicacion.comando;

public class ComandoResultado<T> {

	private T valor;

	public ComandoResultado(T valor) {
		this.valor = valor;
	}
	
	public T getValor() {
		return valor;
	}
	
}
