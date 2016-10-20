import java.util.*;

public class intermediario {
	Clasificador clasificador;
	Retorno retorno;
	Scanner scan;
	List<Seleccion> teclas;

	public intermediario() {
		Ficheros ficheros = new Ficheros();

		clasificador = new Clasificador();
		ficheros.setClasificador(clasificador);
		clasificador.setDepositos(Ficheros.leerFicheroYCrearDepositos());
		clasificador.setDispensadores(Ficheros.leerFicheroYCrearDispensadores());
		retorno = new Retorno();
		retorno.setClasificador(clasificador);

		scan = new Scanner(System.in);
	}

	public void empezar() {

		int opcion = 0; // OPCION A ELEGIR POR USUARIO
		boolean salir = false;
		System.out.println("MENU");
		while (!salir) { // HASTA Q NO SE SELECCIONE OPCION (4 SALIR)
			System.out.println("1. Insertar Monedas" + "\n" + "2. Seleccionar Producto" + "\n" + "3. Retornar Monedas"
					+ "\n" + "4. Salir y guardar");

			try {
				opcion = scan.nextInt();

				switch (opcion) {
				case 1:
					insertarMoneda();
					break;
				case 2:
					seleccionarProducto();
					break;
				case 3:
					retornarMonedas();
					break;
				case 4:
					guardar();
					salir = true;
					break;
				default: // No VALIDO
					System.out.println("Opcion invalida");
					break;
				}
			} catch (InputMismatchException e) {
				scan.next();
				System.out.println("Solo numeros");
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}

		}
		System.exit(1);
	}

	public void insertarMoneda() {
		System.out.println("Escoja que moneda desea añadir: " + "\n" + "1. 2.00 €" + "\n" + "2. 1.00 €" + "\n"
				+ "3. 0.50 €" + "\n" + "4. 0.20 €" + "\n" + "5. 0.10 €" + "\n" + "6. 0.05 €" + "\n" + "7. Atrás");
		int opcion = scan.nextInt();
		switch (opcion) {
		case 1:
			System.out.println("Has insertado una moneda de 2.00 €");
			clasificador.insertarMoneda(200);
			insertarMoneda();
			break;
		case 2:
			System.out.println("Has insertado una moneda de 1.00 €");
			clasificador.insertarMoneda(100);
			insertarMoneda();
			break;
		case 3:
			System.out.println("Has insertado una moneda de 0.50 €");
			clasificador.insertarMoneda(50);
			insertarMoneda();
			break;
		case 4:
			System.out.println("Has insertado una moneda de 0.20 €");
			clasificador.insertarMoneda(20);
			insertarMoneda();
			break;
		case 5:
			System.out.println("Has insertado una moneda de 0.10 €");
			clasificador.insertarMoneda(10);
			insertarMoneda();
			break;
		case 6:
			System.out.println("Has insertado una moneda de 0.05 €");
			clasificador.insertarMoneda(5);
			insertarMoneda();
			break;
		case 7:
			System.out.println("Volviendo atrás");

			System.out.println("SALDO ACTUAL: " + clasificador.getSaldo() / 100f + " €");
			empezar();
			break;
		default:
			System.out.println("Escoja una opcion válida");
			break;
		}
	}

	public void retornarMonedas() {
		retorno.pulsar();
	}

	public void seleccionarProducto() {

		System.out.println("Lista de productos: ");
		List<Dispensador> dispensadores = clasificador.getDispensadores();
		teclas = Ficheros.getTeclasSeleccion();
		for (int i = 0; i < dispensadores.size(); i++) {
			Dispensador dispensador = dispensadores.get(i);
			System.out.println(dispensador.toString());
		}
		System.out.println("Elija un producto");
		try {
			int opcion = scan.nextInt();
			if (opcion < dispensadores.size() && opcion > 0) {
				teclas.get(opcion).pulsar(opcion);
			}
		} catch (InputMismatchException e) {
			scan.next();
		}
		empezar();
	}

	public void guardar() {

	}
}