package es.codeurjc.test.ejem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertJTest {
	
	@Test
	public void testAssertTrue() {
		String name = "pepe";
		assertTrue(name.equals("juan"));
	}
	
	@Test
	public void testAssertEquals() {
		String name = "pepe";
		assertEquals(name,"juan");
	}
	
	@Test
	public void testAssertThatEquals() {
		String name = "pepe";
		//assertThat(name, equalTo("juan"));
		assertThat(name).isEqualTo("juan");				
	}	
	
	@Test
	public void testAssertStartsWith() {
		String name = "pepe";
		assertTrue(name.startsWith("ju"));
	}
	
	@Test
	public void testAssertThatStartsWith() {
		String name = "pepe";
		//assertThat(name, startsWith("ju"));
		assertThat(name).startsWith("ju");
	}
	
	@Test
	public void arrayExceptionTest() {
		int[] array = {3,4,2};
		
		ArrayIndexOutOfBoundsException e = 
				assertThrows(ArrayIndexOutOfBoundsException.class, 
						() -> {int value = array[4];});
	}
	
	@Test
	public void arrayAssertExceptionTest() {
		assertThatThrownBy(()->{
			int[] array = {3,4,2};
			int value = array[4];	
		}).isInstanceOf(ArrayIndexOutOfBoundsException.class);		
	}
}