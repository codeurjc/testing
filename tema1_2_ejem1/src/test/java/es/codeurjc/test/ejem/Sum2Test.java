package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Sum2Test {
	
	@ParameterizedTest
	@CsvSource({
		"0, 0, 0",
		"1, 1, 2",
		"2, 3, 5", 
		"5, 4, 9"
	})
	public void test(int opA, int opB, int result) {
		assertEquals(result, opA + opB);
	}

}