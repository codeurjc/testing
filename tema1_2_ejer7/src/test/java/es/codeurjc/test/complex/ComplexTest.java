package es.codeurjc.test.complex;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComplexTest {

	private Complex zero;

	@BeforeEach
	public void setUp() {
		zero = new Complex(0, 0);
	}

	@Test
	public void GivenZeroComplex_thenRealPartZeroAndImagPartZero() {
		assertThat(zero.getRealPart()).isEqualTo(0);
		assertThat(zero.getImaginaryPart()).isEqualTo(0);
	}

	@Test
	public void GivenZeroComplex_whenAddToComplex1_1_thenComplex1_1IsObtained() {

		assertThat(zero.add(new Complex(1, 1))).isEqualTo(new Complex(1, 1));
	}

	@Test
	public void GivenComplex1_1_whenAddToZero_thenComplex1_1IsObtained() {

		assertThat((new Complex(1, 1)).add(zero)).isEqualTo(new Complex(1, 1));
	}
	
	@Test
	public void GivenComplex0_0_whenReciprocal_thenExceptionIsThrown() {
		
		Complex zero = new Complex(0,0);
		
		assertThatThrownBy(() -> zero.reciprocal())
			.isInstanceOf(ArithmeticException.class)
			.hasMessage("division by zero");		
	}
}
