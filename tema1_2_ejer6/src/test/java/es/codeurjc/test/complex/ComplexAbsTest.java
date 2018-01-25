package es.codeurjc.test.complex;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ComplexAbsTest {

	@Parameters(name="{index}: ({0}).abs() == {1}")
	public static Collection<Object[]> data(){
		
	    Object[][] data = {
	    	{ new Complex(0,0),0 },
	        { new Complex(1,1),1.41421},
			{ new Complex(2,2),2.82843},
			{ new Complex(5,5),7.07107},
			{ new Complex(10,10),14.1421},
			{ new Complex(0,0),0},
			{ new Complex(10,1),10.0498},
			{ new Complex(20,2),20.099}
	    };
	    
	    return Arrays.asList(data);
	}
	
	@Parameter(0) public Complex complex;
	@Parameter(1) public double absolute;

	@Test
	public void absoluteTest() {

		assertEquals(complex.abs(), absolute, 0.001);
	}
}
