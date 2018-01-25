package es.codeurjc.test.complex;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ComplexTest {

	private Complex zero;

	@Before
	public void setUp() {
		zero = new Complex(0, 0);
	}

	@Test
	public void GivenZeroComplex_thenRealPartZeroAndImagPartZero() {
		assertThat(zero.getRealPart(), equalTo(0.0));
		assertThat(zero.getImaginaryPart(), equalTo(0.0));
	}

	@Test
	public void GivenZeroComplex_whenAddToComplex1_1_thenComplex1_1IsObtained() {

		assertThat(zero.add(new Complex(1, 1)), equalTo(new Complex(1, 1)));
	}

	@Test
	public void GivenComplex1_1_whenAddToZero_thenComplex1_1IsObtained() {

		assertThat((new Complex(1, 1)).add(zero),equalTo(new Complex(1, 1)));
	}
}
