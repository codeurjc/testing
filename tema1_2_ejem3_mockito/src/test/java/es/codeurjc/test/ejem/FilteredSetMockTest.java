package es.codeurjc.test.ejem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class FilteredSetMockTest {

	@Test
	public void notAllowedElementTest() {
		
		Predicate<String> filter = mock(Predicate.class);
		when(filter.test(any())).thenReturn(false);
		
		FilteredSet fSet = new FilteredSet(filter);
		boolean changed = fSet.add("elem");
		
		verify(filter).test("elem");
		
		assertThat(changed).isFalse();
		assertThat(fSet.size()).isEqualTo(0);
	}
	
	@Test
	public void notAllowedElementsTest() {
		
		Predicate<String> filter = mock(Predicate.class);
		when(filter.test(any())).thenReturn(false);
		
		FilteredSet fSet = new FilteredSet(filter);
		boolean changed1 = fSet.add("elem1");
		boolean changed2 = fSet.add("elem2");
		boolean changed3 = fSet.add("elem3");
		
		verify(filter).test("elem1");
		verify(filter).test("elem2");
		verify(filter).test("elem3");
		
		assertThat(changed1).isFalse();
		assertThat(changed2).isFalse();
		assertThat(changed3).isFalse();
		assertThat(fSet.size()).isEqualTo(0);
	}
	
	@Test
	public void allowedElementsTest() {
		
		Predicate<String> filter = mock(Predicate.class);
		when(filter.test(any())).thenReturn(true);
		
		FilteredSet fSet = new FilteredSet(filter);
		boolean changed1 = fSet.add("elem1");
		boolean changed2 = fSet.add("elem2");
		boolean changed3 = fSet.add("elem3");
		
		verify(filter).test("elem1");
		verify(filter).test("elem2");
		verify(filter).test("elem3");
		
		assertThat(changed1).isTrue();
		assertThat(changed2).isTrue();
		assertThat(changed3).isTrue();
		assertThat(fSet.size()).isEqualTo(3);
	}
	
	@Test
	public void allowedElementTest() {
		
		Predicate<String> filter = mock(Predicate.class);
		when(filter.test(any())).thenReturn(true);
		
		FilteredSet fSet = new FilteredSet(filter);
		boolean changed = fSet.add("elem");
		
		verify(filter).test("elem");
		
		assertThat(changed).isTrue();
		assertThat(fSet.size()).isEqualTo(1);
	}

}
