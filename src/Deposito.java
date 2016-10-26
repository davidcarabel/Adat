public class Deposito {

	public Deposito(int valor, int cantidad) {
		super();
		this.valor = valor;
		this.cantidad = cantidad;
	}

	private int valor;
	private int cantidad;

	public void sumar() {
		cantidad++;
	}

	public void restar() {
		cantidad--;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getValor() {
		return valor;
	}

}