package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionTest {
	
	@Test
	public void arrayExceptionTest2() {
		int[] array = {3,4,2};
		ArrayIndexOutOfBoundsException actual = 
				assertThrows(ArrayIndexOutOfBoundsException.class, 
						() -> {int value = array[4];});
		assertEquals("4", actual.getMessage());		
	}
}