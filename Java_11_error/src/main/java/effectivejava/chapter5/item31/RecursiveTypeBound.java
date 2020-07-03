package effectivejava.chapter5.item31;

import java.util.Arrays;
import java.util.List;

// Using a recursive type bound with wildcards (Page 143)
public class RecursiveTypeBound {
    public static <E extends Comparable<? super E>> E max(final List<? extends E> list) {
	if (list.isEmpty()) {
	    throw new IllegalArgumentException("Empty list");
	}

	E result = null;
	for (final E e : list) {
	    if (result == null || e.compareTo(result) > 0) {
		result = e;
	    }
	}

	return result;
    }

    public static void main(final String[] args) {
	final List<String> argList = Arrays.asList(args);
	System.out.println(max(argList));
    }
}