package es.codeurjc.test.ejem;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Calculadora5Test {

	Calculadora calc;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Before all tests");
	}
	
	@Before
	public void setUp() {
		System.out.println("Before test");
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
	
	@After
	public void teardown() {
		System.out.println("After test");
	}
	
	@AfterClass
	public static void teardownClass() {
		System.out.println("After all tests");
	}
}