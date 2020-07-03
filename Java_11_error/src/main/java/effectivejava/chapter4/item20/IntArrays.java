package effectivejava.chapter4.item20;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// Concrete implementation built atop skeletal implementation (Page 101)
public class IntArrays {
    static List<Integer> intArrayAsList(final int[] a) {
	Objects.requireNonNull(a);

	// The diamond operator is only legal here in Java 9 and later
	// If you're using an earlier release, specify <Integer>
	return new AbstractList<>() {
	    @Override
	    public Integer get(final int i) {
		return a[i]; // Autoboxing (Item 6)
	    }

	    @Override
	    public Integer set(final int i, final Integer val) {
		final int oldVal = a[i];
		a[i] = val; // Auto-unboxing
		return oldVal; // Autoboxing
	    }

	    @Override
	    public int size() {
		return a.length;
	    }
	};
    }

    public static void main(final String[] args) {
	final int[] a = new int[10];
	for (int i = 0; i < a.length; i++) {
	    a[i] = i;
	}

	final List<Integer> list = intArrayAsList(a);
	Collections.shuffle(list);
	System.out.println(list);
    }
}
