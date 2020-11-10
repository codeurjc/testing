package es.codeurjc.test.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import es.codeurjc.test.complex.Complex;

public class ComplexAbsTest {

	@ParameterizedTest
	@CsvSource({
		"0, 0, 0",
		"1, 1, 1.41421",
		"2, 2, 2.82843",
		"5, 5, 7.07107",
		"10, 10, 14.1421",
		"10, 1, 10.0498",
		"20, 2, 20.099"
		})
	public void absoluteTest(double real, double imag, double abs) {

		Complex complex = new Complex(real, imag);
		assertEquals(complex.abs(), abs, 0.001);
	}
	
}
