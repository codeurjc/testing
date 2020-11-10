package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Sum4Test {
	
	@ParameterizedTest(name = "{index}: {0}+{1}= {2}")
	@MethodSource("values")
	public void test(int a, int b, int result) {
		assertEquals(a + b, result);
	}
	
	public static Collection<Object[]> values() {
		
		Object[][] values = {
				{0, 0, 0},
				{1, 1, 2}
		};
		return Arrays.asList(values);		
	}	
}