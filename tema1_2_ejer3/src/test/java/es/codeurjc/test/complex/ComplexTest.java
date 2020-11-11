package es.codeurjc.test.complex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComplexTest {

	private Complex zero;

	@BeforeEach
	public void setUp() {
		zero = new Complex(0, 0);
	}

	@Test
	public void givenZeroComplex_thenRealPartZeroAndImagPartZero() {
		assertEquals(0, zero.getRealPart(), 0.001);
		assertEquals(0, zero.getImaginaryPart(), 0.001);
	}

	@Test
	public void givenZeroComplex_whenAddToComplex1_1_thenComplex1_1IsObtained() {

		assertEquals(new Complex(1, 1), zero.add(new Complex(1, 1)));
	}

	@Test
	public void givenComplex1_1_whenAddToZero_thenComplex1_1IsObtained() {

		assertEquals(new Complex(1, 1), (new Complex(1, 1)).add(zero));
	}
}
