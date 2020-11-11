package es.codeurjc.test.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import es.codeurjc.test.complex.Complex;

public class ComplexAbsTest {

	@ParameterizedTest
	@MethodSource("values")
	public void absoluteTest(Complex complex, double result) {
		assertEquals(complex.abs(), result, 0.001);
	}
	
	public static Collection<Object[]> values() {
	    
		Object[][] data = {
			{ new Complex(0,0)  ,0       },
			{ new Complex(1,1)  ,1.41421 },
			{ new Complex(2,2)  ,2.82843 },
			{ new Complex(5,5)  ,7.07107 },
			{ new Complex(10,10),14.1421 },
			{ new Complex(10,1) ,10.0498 },
			{ new Complex(20,2) ,20.099  }
		};

	    return Arrays.asList(data);
	}
}
