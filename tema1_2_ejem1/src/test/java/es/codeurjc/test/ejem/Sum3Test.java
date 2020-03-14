package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Sum3Test {
	
	@ParameterizedTest
	@MethodSource("values")
	public void test(int argument) {
		assertTrue(argument > 0 && argument <= 5);
	}
	
	public static Stream<Integer> values() {
		return Stream.of(-1, 5, 10);
	}

}