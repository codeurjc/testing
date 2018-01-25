package es.codeurjc.test.ejem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertionTest {
	
	@Test
	public void testAssertTrue() {
		assertTrue("pepe".equals("juan"));
	}
	
	@Test
	public void testAssertEquals() {
		assertEquals("pepe","juan");
	}
	
	@Test
	public void testAssertStartsWith() {
		assertTrue("pepe".startsWith("ju"));
	}
}