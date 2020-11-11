package es.codeurjc.test.complex;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
		assertThat(zero.getRealPart(), equalTo(0.0));
		assertThat(zero.getImaginaryPart(), equalTo(0.0));
	}

	@Test
	public void givenZeroComplex_whenAddToComplex1_1_thenComplex1_1IsObtained() {

		assertThat(zero.add(new Complex(1, 1)), equalTo(new Complex(1, 1)));
	}

	@Test
	public void givenComplex1_1_whenAddToZero_thenComplex1_1IsObtained() {

		assertThat((new Complex(1, 1)).add(zero),equalTo(new Complex(1, 1)));
	}
	
	@Test
	public void givenComplex0_0_whenReciprocal_thenExceptionIsThrown() {
		
		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			
			zero.reciprocal();
			
		});
		
		assertThat(actual.getMessage(), containsString("division by zero"));
		
	}

}
