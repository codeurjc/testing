package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionTest {
	
	@Test
	public void arrayExceptionTest() {

		NumberFormatException ex = assertThrows(NumberFormatException.class, () -> {
			
			Integer.parseInt("No integer");
			
		});
		
		assertEquals("For input string: \"No integer\"", ex.getMessage());		
	}
}