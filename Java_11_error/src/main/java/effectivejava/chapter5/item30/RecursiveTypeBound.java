package effectivejava.chapter5.item30;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

// Using a recursive type bound to express mutual comparability (Pages 137-8)
public class RecursiveTypeBound {
    // Returns max value in a collection - uses recursive type bound
    public static <E extends Comparable<E>> E max(final Collection<E> c) {
	if (c.isEmpty()) {
	    throw new IllegalArgumentException("Empty collection");
	}

	E result = null;
	for (final E e : c) {
	    if (result == null || e.compareTo(result) > 0) {
		result = Objects.requireNonNull(e);
	    }
	}

	return result;
    }

    public static void main(final String[] args) {
	final List<String> argList = Arrays.asList(args);
	System.out.println(max(argList));
    }
}