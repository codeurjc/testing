package es.codeurjc.test.ejem;

import static org.junit.Assert.fail;

import org.junit.Test;

public class ExceptionTest {
	
	@Test
	public void arrayExceptionTest() {
		int[] array = {3,4,2};
		try {
			int value = array[4];
			fail("Array access out of range should "
					+ "throw ArrayIndexOutOfBoundsException");			
		} catch(ArrayIndexOutOfBoundsException e) {			
		}
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void arrayExceptionTest2() {
		int[] array = {3,4,2};
		int value = array[4];
	}
}