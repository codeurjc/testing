package es.codeurjc.test.ejem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertJTest {
	
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
		//assertThat("pepe", equalTo("juan"));
		assertThat("pepe").isEqualTo("juan");
	}	
	
	@Test
	public void testAssertStartsWith() {
		assertTrue("pepe".startsWith("ju"));
	}
	
	@Test
	public void testAssertThatStartsWith() {
		//assertThat("pepe", startsWith("ju"));
		assertThat("pepe").startsWith("ju");
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void arrayExceptionTest() {
		int[] array = {3,4,2};
		int value = array[4];
	}
	
	@Test
	public void arrayAssertExceptionTest() {
		assertThatThrownBy(()->{
			int[] array = {3,4,2};
			int value = array[4];	
		}).isInstanceOf(ArrayIndexOutOfBoundsException.class);		
	}
}