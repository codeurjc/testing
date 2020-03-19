package es.codeurjc.test.ejem;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class FilteredSetTest {

	@Test
	public void notAllowedElementTest() {
		
		Predicate<String> filter = elem -> false;
		FilteredSet fSet = new FilteredSet(filter);
		boolean changed = fSet.add("elem");
		
		assertThat(changed).isFalse();
		assertThat(fSet.size()).isEqualTo(0);
	}
	
	@Test
	public void allowedElementTest() {
		
		Predicate<String> filter = elem -> true;
		FilteredSet fSet = new FilteredSet(filter);
		boolean changed = fSet.add("elem");
		
		assertThat(changed).isTrue();
		assertThat(fSet.size()).isEqualTo(1);
	}

}
