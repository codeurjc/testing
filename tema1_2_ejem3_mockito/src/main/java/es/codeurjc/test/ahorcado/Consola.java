package es.codeurjc.test.ahorcado;

import java.util.Scanner;

public class Consola {

	private Scanner scanner = new Scanner(System.in).useDelimiter(System
			.getProperty("line.separator"));

	public Consola() {
	}

	public void println(String mensaje) {
		System.out.println(mensaje);		
	}

	public void print(String mensaje) {
		System.out.print(mensaje);
	}

	public String leerString() {
		return scanner.next().trim();
	}

	public int leerInt() {
		return scanner.nextInt();
	}

}
