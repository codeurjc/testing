package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Calculadora2Test {

	@Test
	public void testSuma() {

		Calculadora calculadora = new Calculadora();
		double res = calculadora.suma(1, 1);
		assertEquals(2, res, 0);
	}

	@Test
	public void testResta() {

		Calculadora calculadora = new Calculadora();
		double res = calculadora.resta(1, 1);
		assertEquals(0, res, 0);
	}
}