public class Visor {

	private String cambiarCentimosEuros(int precio) {
		// TODO Auto-generated method stub
		String euros = Float.toString(precio / 100f);
		return euros;
	}

	public void mostrarBienvenida() {
		System.out.println("BIENVENIDO!");
	}

	public void mostrarCompra(String nombre, int cantidad) {
		System.out.println("SE HA COMPRADO: " + nombre);
		System.out.println("CANTIDAD RESTANTE: " + cantidad);
	}

	public void mostrarDespedida() {
		System.out.println("GRACIAS POR SU COMPRA!");
	}

	public void mostrarProducto(String producto) {
		System.out.println(producto);
	}

	public void mostrarError(String error) {
		System.out.println("ERROR: " + error);
	}

	public void mostrarNombreProducto(String nombre) {
		System.out.println("NOMBRE PRODUCTO: " + nombre);
	}

	public void mostrarPrecio(int precio) {
		System.out.println("COSTE: " + cambiarCentimosEuros(precio) + " €");
	}

	public void mostrarSaldo(int saldo) {
		System.out.println("SALDO ACTUAL: " + cambiarCentimosEuros(saldo) + " €");
	}

	public void mostrarValorMoneda(int valor) {
		System.out.println("DEVOLVIENDO MONEDA DE " + cambiarCentimosEuros(valor) + " €");
	}

	public void mostrarMensaje(String string) {
		// TODO Auto-generated method stub
		
	}

}