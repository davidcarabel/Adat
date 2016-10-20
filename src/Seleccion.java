public class Seleccion extends Tecla {

	Clasificador clasificador;
	String nombreProducto;

	public Seleccion(Clasificador clasificador) {
		super();
		this.clasificador = clasificador;
	}

	@Override
	public void pulsar() {

		// hmBotones.get(nombreProducto).pulsar();

		clasificador.seleccionarProducto(this.nombreProducto);

	}

}