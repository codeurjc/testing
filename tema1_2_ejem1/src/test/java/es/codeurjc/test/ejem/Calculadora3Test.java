package es.codeurjc.test.ejem;

import org.junit.Test;
import static org.junit.Assert.*;

public class Calculadora3Test {

	@Test
	public void testSuma() {

		Calculadora calculadora = new Calculadora();
		double res = calculadora.suma(1, 1);
		assertEquals("1+1 should be equal to 2", 2, res, 0);
	}

	@Test
	public void testResta() {

		Calculadora calculadora = new Calculadora();
		double res = calculadora.resta(1, 1);
		assertEquals("1-1 should be equal to 0", 0, res, 0);
	}
}