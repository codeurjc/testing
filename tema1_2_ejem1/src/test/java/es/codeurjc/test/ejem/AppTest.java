package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppTest {
	
	@Test
	public void testSuma() {
		String text = "Text";
		assertEquals("Text", text);
	}
	
	@Test
	public void testSuma2() {
		assertTrue(1+1 == 2);
	}
}
