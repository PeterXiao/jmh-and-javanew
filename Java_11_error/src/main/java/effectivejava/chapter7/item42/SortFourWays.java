package effectivejava.chapter7.item42;

import static java.util.Comparator.comparingInt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Sorting with function objects (Pages 193-4)
public class SortFourWays {
	public static void main(String[] args) {
		final List<String> words = Arrays.asList("1 ,2 ,3 ,4"); // args

		// Anonymous class instance as a function object - obsolete! (Page 193)
		Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(words);
		Collections.shuffle(words);

		// Lambda expression as function object (replaces anonymous class) (Page 194)
		Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(words);
		Collections.shuffle(words);

		// Comparator construction method (with method reference) in place of lambda
		// (Page 194)
		Collections.sort(words, comparingInt(String::length));
		System.out.println(words);
		Collections.shuffle(words);

		// Default method List.sort in conjunction with comparator construction method
		// (Page 194)
		words.sort(comparingInt(String::length));
		System.out.println(words);
	}
}
