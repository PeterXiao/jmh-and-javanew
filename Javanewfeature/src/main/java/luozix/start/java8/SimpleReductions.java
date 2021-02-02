/**
 * 
 */
package luozix.start.java8;

import java.util.stream.IntStream;

/**
 * @author xiaoy
 *
 */
public class SimpleReductions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = IntStream.range(0, 100).filter(n -> n % 2 == 0).reduce(0, Integer::sum);
		System.out.println("Sum of odd numbers: " + result);

		int powResult = IntStream.range(0, 100).map(x -> x * x).reduce(0, Integer::sum);
		System.out.println("Sum of powed numbers: " + powResult);
	}

}
