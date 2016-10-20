import java.util.List;

public class Retorno extends Tecla {

	Clasificador clasificador;

	@Override
	public void pulsar() {
		// TODO Auto-generated method stub
		try {
			clasificador.retornarMonedas();
		} catch (Exception e) {
			System.err.println("NO SE PUEDE DEVOLVER CAMBIO");
		}
	}

	public void setClasificador(Clasificador clasificador) {
		this.clasificador = clasificador;
	}

}