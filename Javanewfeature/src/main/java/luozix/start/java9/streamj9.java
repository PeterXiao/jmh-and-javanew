/**
 * 
 */
package luozix.start.java9;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xiaoy
 *
 */
public class streamj9 {
	interface InterfaceWithPrivateMethod {
		private long calculateSomething() {
			return 11L;
		}

		default int addOddNumbersToSomething(int... nums) {
			int start = 0;
			for (int num : nums) {
				start += num;
			}

			return start;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stream.iterate(0, i -> i < 5, i -> i + 1).forEach(System.out::println);
		List immutableList = List.of(2, 3);
		Map<Integer, String> immutableMap = Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five", 6, "six", 7,
				"seven", 8, "eight", 9, "nine", 10, "ten");
		System.out.println(immutableMap.get(1));

		// TODO Auto-generated method stub
		Stream.of("a", "b", "c", "", "e", "f").takeWhile(s -> !s.isEmpty()).forEach(System.out::print);

		Stream.of("a", "b", "c", "", "e", "f").dropWhile(s -> !s.isEmpty()).forEach(System.out::print);

		IntStream.iterate(3, x -> x < 10, x -> x + 3).forEach(System.out::println);

		long count = Stream.ofNullable(100).count();
		System.out.println(count);

		count = Stream.ofNullable(null).count();
		System.out.println(count);
	}

}

