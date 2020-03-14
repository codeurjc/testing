package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Calculadora5Test {

	Calculadora calc;

	@BeforeAll
	public static void setUpClass() {
		System.out.println("Before all tests");
	}
	
	@BeforeEach
	public void setUp() {
		System.out.println("Before test");
		this.calc = new Calculadora();
	}

	@Test
	public void testSuma() {
		double res = calc.suma(1, 1);
		assertEquals(2, res, 0, "1+1 should be equal to 2");
	}

	@Test
	public void testResta() {
		double res = calc.resta(1, 1);
		assertEquals(0, res, 0, "1-1 should be equal to 0");
	}
	
	@AfterEach
	public void teardown() {
		System.out.println("After test");
	}
	
	@AfterAll
	public static void teardownClass() {
		System.out.println("After all tests");
	}
}