package effectivejava.chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

// Frequency table implemented with map.merge, using lambda and method reference (Page 197)
public class Freq {
    public static void main(final String[] args) {
	final Map<String, Integer> frequencyTable = new TreeMap<>();

	for (final String s : args) {
	    frequencyTable.merge(s, 1, (count, incr) -> count + incr); // Lambda
	}
	System.out.println(frequencyTable);

	frequencyTable.clear();
	for (final String s : args) {
	    frequencyTable.merge(s, 1, Integer::sum); // Method reference
	}
	System.out.println(frequencyTable);

    }
}
