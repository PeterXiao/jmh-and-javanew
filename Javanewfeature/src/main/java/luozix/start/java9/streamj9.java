/**
 * 
 */
package luozix.start.java9;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xiaoy
 *
 */
public class streamj9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
