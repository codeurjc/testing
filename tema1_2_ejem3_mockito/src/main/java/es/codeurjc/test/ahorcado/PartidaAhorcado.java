package es.codeurjc.test.ahorcado;

public class PartidaAhorcado {

	public enum Resultado {
		PALABRA_ACERTADA, AHORCADO, LETRA_ACERTADA, LETRA_NO_ENCONTRADA, LETRA_VISIBLE
	}

	private Horca horca = new Horca();
	private Palabra palabra;

	public PartidaAhorcado(String palabra) {
		this.palabra = new Palabra(palabra);
	}
	
	//Test intended constructor
	protected PartidaAhorcado(Palabra palabra, Horca horca) {
		this.palabra = palabra;
		this.horca = horca;
	} 

	private Resultado probarLetra(Jugador jugador, String letra) {

		String nombre = jugador.getNombre();
		Consola consola = jugador.getConsola();

		if (palabra.letraVisibleEnPalabra(letra)) {
			consola.println(nombre + " la letra " + letra + " ya está en la palabra");
			return Resultado.LETRA_VISIBLE;
		}

		if (palabra.letraOcultaEnPalabra(letra)) {

			mostrar(jugador);

			if (palabra.palabraCompleta()) {
				consola.println(nombre + " felicidades. Has adivinado la palabra!");
				return Resultado.PALABRA_ACERTADA;
			} else {
				consola.println(nombre + " Letra encontrada!");
				return Resultado.LETRA_ACERTADA;
			}

		} else {

			horca.aniadirParteCuerpo();
			mostrar(jugador);

			if (horca.haPerdido()) {
				consola.println(nombre + " has perdido, te han ahorcado!");
				consola.println("El país es " + palabra.getPalabra());
				return Resultado.AHORCADO;
			} else {
				consola.println(nombre + " no se encuentra la letra");
				return Resultado.LETRA_NO_ENCONTRADA;
			}
		}
	}

	public void mostrar(Jugador jugador) {

		Consola consola = jugador.getConsola();

		consola.println(horca.toString());
		consola.println(palabra.toString());
	}

	public Resultado jugarPartida(Jugador jugador) {

		this.mostrar(jugador);

		Consola consola = jugador.getConsola();
		
		while (true) {

			consola.print(jugador.getNombre() + " selecciona una letra: ");
			String letra = consola.leerString();

			Resultado resultado = probarLetra(jugador, letra);

			if (resultado == Resultado.PALABRA_ACERTADA || resultado == Resultado.AHORCADO) {
				return resultado;
			}
		}
	}

}
