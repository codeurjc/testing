package es.codeurjc.test.ejem;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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