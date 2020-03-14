package es.codeurjc.test.complex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.codeurjc.test.complex.Complex;

public class ComplexTest {

	private Complex zero;

	@BeforeEach
	public void setUp() {
		zero = new Complex(0, 0);
	}

	@Test
	public void givenZero_thenRealPartIsZero_And_ImagPartIsZero() {
		
		assertEquals(0, zero.getRealPart(), 0.001);
		assertEquals(0, zero.getImaginaryPart(), 0.001);
	}

	@Test
	public void givenZeroAndOne_whenZeroAddToOne_thenOneIsObtained() {

		//Given
		Complex one = new Complex(1, 1);
		
		//When
		Complex result = zero.add(one);
		
		//Then		
		assertEquals(new Complex(1, 1), result);
	}

	@Test
	public void givenZeroAndOne_whenOneAddZero_thenOneIsObtained() {

		//Given
		Complex one = new Complex(1, 1);
		
		//When
		Complex result = one.add(zero);
		
		//Then		
		assertEquals(new Complex(1, 1), result);
	}
}
