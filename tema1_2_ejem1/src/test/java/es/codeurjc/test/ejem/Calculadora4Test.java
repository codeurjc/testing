package es.codeurjc.test.ejem;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class Calculadora4Test {

	Calculadora calc;

	@Before
	public void setUp() {
		this.calc = new Calculadora();
	}

	@Test
	public void testSuma() {

		double res = calc.suma(1, 1);
		assertEquals("1+1 should be equal to 2", 2, res, 0);
	}

	@Test
	public void testResta() {

		double res = calc.resta(1, 1);
		assertEquals("1-1 should be equal to 0", 0, res, 0);
	}
}