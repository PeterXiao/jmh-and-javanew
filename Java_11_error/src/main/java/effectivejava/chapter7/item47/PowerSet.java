package effectivejava.chapter7.item47;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
    // Returns the power set of an input set as custom collection (Page 218)
    public static final <E> Collection<Set<E>> of(final Set<E> s) {
	final List<E> src = new ArrayList<>(s);
	if (src.size() > 30) {
	    throw new IllegalArgumentException("Set too big " + s);
	}
	return new AbstractList<>() {
	    @Override
	    public int size() {
		return 1 << src.size(); // 2 to the power srcSize
	    }

	    @Override
	    public boolean contains(final Object o) {
		return o instanceof Set && src.containsAll((Set) o);
	    }

	    @Override
	    public Set<E> get(int index) {
		final Set<E> result = new HashSet<>();
		for (int i = 0; index != 0; i++, index >>= 1) {
		    if ((index & 1) == 1) {
			result.add(src.get(i));
		    }
		}
		return result;
	    }
	};
    }

    public static void main(final String[] args) {
	final Set s = new HashSet(Arrays.asList(args));
	System.out.println(PowerSet.of(s));
    }
}