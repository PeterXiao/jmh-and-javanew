package effectivejava.chapter11.item79;

import java.util.HashSet;

// Simple test of ObservableSet - Page 318
public class Test1 {
    public static void main(final String[] args) {
	final ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

	set.addObserver((s, e) -> System.out.println(e));

	for (int i = 0; i < 100; i++) {
	    set.add(i);
	}
    }
}
