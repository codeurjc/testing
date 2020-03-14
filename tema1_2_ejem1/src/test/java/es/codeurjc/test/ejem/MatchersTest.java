package es.codeurjc.test.ejem;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MatchersTest {
	
	@Test
	public void testAssertTrue() {
		assertTrue("pepe".equals("juan"));
	}
	
	@Test
	public void testAssertEquals() {
		assertEquals("pepe","juan");
	}
	
	@Test
	public void testAssertThatEquals() {
		assertThat("pepe", equalTo("juan"));
	}

	@Test
	public void testAssertStartsWith() {
		assertTrue("pepe".startsWith("ju"));
	}
	
	@Test
	public void testAssertThatStartsWith() {
		assertThat("pepe", startsWith("ju"));
	}
}