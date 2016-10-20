public class Dispensador {

	private int id;
	private String nombre;
	private int cantidad;
	private int precio;

	public Dispensador(int id, String nombre, int cantidad, int precio) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Dispensador() {
	}

	public void dispensar(int id) {
		cantidad--;
	}

	public int getId() {
		return id;
	}

	public int getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "ID: " + id + " PRODUCTO: " + nombre + " PRECIO: " + precio / 100f + " €";
	}

	public int getValor() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void dispensar() {
		// TODO Auto-generated method stub
		
	}

}