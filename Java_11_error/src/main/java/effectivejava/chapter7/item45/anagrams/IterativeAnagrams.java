package effectivejava.chapter7.item45.anagrams;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// Prints all large anagram groups in a dictionary iteratively (Page 204)
public class IterativeAnagrams {
    public static void main(final String[] args) throws IOException {
	final File dictionary = new File(args[0]);
	final int minGroupSize = Integer.parseInt(args[1]);

	final Map<String, Set<String>> groups = new HashMap<>();
	try (Scanner s = new Scanner(dictionary)) {
	    while (s.hasNext()) {
		final String word = s.next();
		groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
	    }
	}

	for (final Set<String> group : groups.values()) {
	    if (group.size() >= minGroupSize) {
		System.out.println(group.size() + ": " + group);
	    }
	}
    }

    private static String alphabetize(final String s) {
	final char[] a = s.toCharArray();
	Arrays.sort(a);
	return new String(a);
    }
}