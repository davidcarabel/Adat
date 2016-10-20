import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Clasificador {

	public intermediario inter;

	private int saldo = 0;
	private int numMonedas = 0;
	Visor visor;
	TreeMap<Integer, Deposito> depositos;
	HashMap<String, Dispensador> dispensadores;

	public Clasificador() {

	}

	public void insertarMoneda(int moneda) {
		depositos.get(moneda).sumar();
		saldo = saldo + moneda;
		numMonedas++;
		visor.mostrarSaldo(saldo);
	}

	public void retornarMonedas() {

		if (numMonedas == 0) {
			visor.mostrarError("No hay monedas que retornar.");

		} else {

			Set<?> set = depositos.entrySet();
			Iterator<?> it = set.iterator();

			while (it.hasNext()) {

				Map.Entry entry = (Map.Entry) it.next();

				while (saldo != 0) {

					Integer key = (Integer) entry.getKey();
					Deposito value = (Deposito) entry.getValue();

					if (saldo >= key) {

						if (value.getCantidad() > 0) {
							saldo -= value.getValor();
							value.restar();
							System.out.println("Devuelve moneda de " + value.getValor() + "cent.\n");

						} else {
							entry = (Map.Entry) it.next();

						}
					} else {
						entry = (Map.Entry) it.next();
					}
				}

			}

		}

	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void setVisor(Visor visor) {
		this.visor = visor;
	}

	public void seleccionarProducto(String nombreProducto) {
		int precio = dispensadores.get(nombreProducto).getValor();
		int cantidad = dispensadores.get(nombreProducto).getCantidad();
		visor.mostrarPrecio(precio);
		visor.mostrarSaldo(saldo);

		if (saldo >= precio) {
			if (cantidad > 0) {
				visor.mostrarMensaje("Realizando compra\n.\n.\n.");
				saldo -= precio;
				System.out.println("Cantidad de producto: " + cantidad);
				dispensadores.get(nombreProducto).dispensar();
				retornarMonedas();
			} else {
				visor.mostrarMensaje("Sin existencias.");
				retornarMonedas();
			}
		} else {
			System.out.println("No hay saldo suficiente, te faltan " + (precio - saldo) + "cent.\n");
		}
	}

	public void setIntermediario(intermediario intermediario) {
		this.inter = intermediario;
	}

	public void setDepositos(TreeMap<Integer, Deposito> depositos) {
		this.depositos = depositos;
	}

	public void setDispensadores(HashMap<String, Dispensador> dispensadores) {
		this.dispensadores = dispensadores;
	}

	public void setDepositos(ArrayList<Deposito> leerFicheroYCrearDepositos) {
		// TODO Auto-generated method stub

	}

	public void setDispensadores(ArrayList<Dispensador> leerFicheroYCrearDispensadores) {
		// TODO Auto-generated method stub

	}

	public float getSaldo() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Dispensador> getDispensadores() {
		// TODO Auto-generated method stub
		return null;
	}

	public void seleccionarProducto(int id) {
		// TODO Auto-generated method stub
		
	}

}