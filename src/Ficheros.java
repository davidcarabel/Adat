import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {

	private static int[] valorMonedas = { 200, 100, 50, 20, 10, 5 };
	private static ArrayList<Seleccion> teclasSeleccion = new ArrayList<Seleccion>();
	private static Clasificador clasificador;

	public void setClasificador(Clasificador clasificador) {
		Ficheros.clasificador = clasificador;
	}

	public static ArrayList<Deposito> leerFicheroYCrearDepositos() {
		BufferedReader br;
		ArrayList<Deposito> depositos = new ArrayList<Deposito>();
		try {
			br = new BufferedReader(new FileReader("monedas.txt"));
			try {
				depositos = new ArrayList<Deposito>();
				String line;
				while ((line = br.readLine()) != null) {
					String[] cantidadMonedasStr = line.split(", ");
					int[] cantidadMonedas = new int[cantidadMonedasStr.length];
					for (int i = 0; i < cantidadMonedasStr.length; i++) {
						cantidadMonedas[i] = Integer.parseInt(cantidadMonedasStr[i]);
						depositos.add(new Deposito(valorMonedas[i], cantidadMonedas[i]));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return depositos;
	}

	public static ArrayList<Dispensador> leerFicheroYCrearDispensadores() {
		BufferedReader br;
		ArrayList<Dispensador> dispensadores = new ArrayList<Dispensador>();

		try {
			br = new BufferedReader(new FileReader("productos.txt"));
			String line;
			String[] productosStr;
			Seleccion seleccion;
			while ((line = br.readLine()) != null) {
				try {
					productosStr = line.split(",");
					dispensadores.add(new Dispensador(Integer.parseInt(productosStr[0]), productosStr[1],
							Integer.parseInt(productosStr[2]), Integer.parseInt(productosStr[3])));
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
				seleccion = new Seleccion();
				teclasSeleccion.add(seleccion);
				seleccion.setClasificador(clasificador);

			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
		return dispensadores;
	}

	public static void escribirFicheroYActualizarDepositos(List<Deposito> depositos) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("monedas.txt"), "utf-8"))) {
			writer.write("something");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void escribirFicheroYActualizarDispensadores(List<Dispensador> dispensadores) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileOutputStream("productos.txt"));
			for (Dispensador dispensador : dispensadores)
				pw.println(dispensador.getId() + "," + dispensador.getNombre() + "," + dispensador.getCantidad() + ","
						+ dispensador.getPrecio());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Seleccion> getTeclasSeleccion() {
		return teclasSeleccion;
	}
}