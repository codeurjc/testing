package es.codeurjc.test.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import es.codeurjc.test.complex.Complex;

public class ComplexAbs2Test {

	static class ComplexAndValue {

		public Complex complex;
		public double value;

		public ComplexAndValue(Complex complex, double value) {
			this.complex = complex;
			this.value = value;
		}
	}

	@ParameterizedTest
	@MethodSource("values")
	public void absoluteTest(ComplexAndValue complexAndValue) {

		Complex complex = complexAndValue.complex;
		double abs = complexAndValue.value;

		assertEquals(complex.abs(), abs, 0.001);
	}

	public static Stream<ComplexAndValue> values() {
		return Stream.of(
			new ComplexAndValue(new Complex(0, 0), 0), 
			new ComplexAndValue(new Complex(1, 1), 1.41421),
			new ComplexAndValue(new Complex(2, 2), 2.82843), 
			new ComplexAndValue(new Complex(5, 5), 7.07107),
			new ComplexAndValue(new Complex(10, 10), 14.1421), 
			new ComplexAndValue(new Complex(10, 1), 10.0498),
			new ComplexAndValue(new Complex(20, 2), 20.099)
		);
	}

}
