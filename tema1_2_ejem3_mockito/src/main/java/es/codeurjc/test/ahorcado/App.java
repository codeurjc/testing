package es.codeurjc.test.ahorcado;

public class App {

	public static void main(String[] args) {

		Consola consola = new Consola();
		consola.println("Bienvenido al juego del ahorcado");

		Jugador jugador = new Jugador(consola);
		
		JuegoAhorcado juegoAhorcado = new JuegoAhorcado(consola);		
		juegoAhorcado.jugar(jugador);

	}
}
