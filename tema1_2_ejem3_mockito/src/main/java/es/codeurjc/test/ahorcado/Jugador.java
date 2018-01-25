package es.codeurjc.test.ahorcado;

public class Jugador {

	private Consola consola;
	private String nombre;

	public Jugador(Consola consola) {
		this.consola = consola;
	}

	public Consola getConsola() {
		return consola;
	}

	public String getNombre() {
		return nombre;
	}

	public void leeNombre() {
		consola.print("Cómo te llamas? ");
		this.nombre = consola.leerString();
	}
}
