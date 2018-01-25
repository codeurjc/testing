package es.codeurjc.test.complex;

import org.junit.Test;

import es.codeurjc.test.complex.Complex;

import static org.junit.Assert.*;

public class ComplexTest {

	@Test
	public void GivenZeroComplex_thenRealPartZeroAndImagPartZero() {

		Complex complex = new Complex(0, 0);

		assertEquals(0, complex.getRealPart(), 0.001);
		assertEquals(0, complex.getImaginaryPart(), 0.001);

	}

	@Test
	public void GivenZeroComplex_whenAddToComplex1_1_thenComplex1_1IsObtained() {

		assertEquals(new Complex(1, 1),
				(new Complex(0, 0)).add(new Complex(1, 1)));

	}

	@Test
	public void GivenComplex1_1_whenAddToZero_thenComplex1_1IsObtained() {

		assertEquals(new Complex(1, 1),
				(new Complex(1, 1)).add(new Complex(0, 0)));
	}

}
