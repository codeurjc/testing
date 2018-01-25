package es.codeurjc.test.ejem;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class FilteredSet extends HashSet<String> {
	
	private static final long serialVersionUID = 5395084154644937258L;

	private Predicate<String> filter;

	public FilteredSet(Predicate<String> filter) {
		this.filter = filter;
	}
	
	@Override
	public boolean add(String element) {
		if(filter.test(element)) {
			return super.add(element);
		} else {
			return false;
		}
	}

	@Override
	public boolean addAll(Collection<? extends String> elements) {
		boolean changed = false;
		for(String element: elements) {
			changed |= add(element);
		}
		return changed;
	}

}
