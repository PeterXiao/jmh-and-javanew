package effectivejava.chapter5.item32;

import java.util.ArrayList;
import java.util.List;

// List as a typesafe alternative to a generic varargs parameter (page 149)
public class FlattenWithList {
    static <T> List<T> flatten(final List<List<? extends T>> lists) {
	final List<T> result = new ArrayList<>();
	for (final List<? extends T> list : lists) {
	    result.addAll(list);
	}
	return result;
    }

    public static void main(final String[] args) {
	final List<Integer> flatList = flatten(List.of(List.of(1, 2), List.of(3, 4, 5), List.of(6, 7)));
	System.out.println(flatList);
    }
}
