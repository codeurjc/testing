package es.codeurjc.test.ejem;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Sum2Test {
	
	@Parameters(name = "{index}: {0}+{1}={2}")
	public static Collection<Object[]> data() {
		
		Object[][] values = {
			{ 0, 0, 0 }, 
			{ 1, 1, 2 },
			{ 2, 3, 5 },
			{ 5, 4, 9 }
		};
		
		return Arrays.asList(values);
	}

	@Parameter(0) public int opA;
	@Parameter(1) public int opB;
	@Parameter(2) public int result;

	@Test
	public void test() {
		assertEquals(result, opA + opB);
	}
}