package es.codeurjc.test.ahorcado;

import java.util.HashSet;
import java.util.Set;

public class Palabra {

	private String palabra;
	private char[] visualizacion;
	private int letrasOcultasPalabra;
	private Set<String> letrasOcultas = new HashSet<String>(); 

	public Palabra(String palabra) {
		this.palabra = palabra.toUpperCase();
		crearVisualizacion();
	}

	private void crearVisualizacion() {

		visualizacion = new char[palabra.length()];

		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == ' ') {
				visualizacion[i] = ' ';
			} else {
				visualizacion[i] = '-';
				letrasOcultasPalabra++;
			}
		}
		
		char[] abecedario = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
		for(int i=0; i<abecedario.length; i++){
			letrasOcultas.add(Character.toString(abecedario[i]));
		}
	}

	public boolean letraOcultaEnPalabra(String letra) {

		char letraChar = Character.toUpperCase(letra.charAt(0));

		boolean acierto = false;
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == letraChar) {
				visualizacion[i] = letraChar;
				acierto = true;
				letrasOcultasPalabra--;
			}
		}
		
		letrasOcultas.remove(letra);
		
		return acierto;
	}

	public boolean letraVisibleEnPalabra(String letra) {

		char letraChar = Character.toUpperCase(letra.charAt(0));

		for (int i = 0; i < visualizacion.length; i++) {
			if (visualizacion[i] == letraChar) {
				return true;
			}
		}
		return false;
	}

	public boolean palabraCompleta() {
		return letrasOcultasPalabra == 0;
	}

	public String toString() {
		return "País: " + new String(visualizacion);
	}

	public String getPalabra() {
		return palabra;
	}

	public Set<String> getLetrasOcultas() {
		return letrasOcultas;
	}

}
