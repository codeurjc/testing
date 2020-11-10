package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {
	
	@Test
	public void testSuma() {
		
		//Given
		List<String> list = new ArrayList<>();
		
		//When 
		list.add("Hola");

		//Then
		assertTrue(list.size() == 1);
	}
	
}
