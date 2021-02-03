/**
 * 
 */
package luozix.start.exams.funcs;

/**
 * @author xiaoy
 *
 */
public class Hano {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nDisks = 5;
		doTowers(nDisks, 'A', 'B', 'C');

		for (int counter = 0; counter <= 10; counter++) {
			System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacci(counter));
		}

		for (int counter = 0; counter <= 10; counter++) {
			System.out.printf("%d! = %d\n", counter, factorial(counter));
		}
	}

	public static void doTowers(int topN, char from, char inter, char to) {
		if (topN == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
		} else {
			doTowers(topN - 1, from, to, inter);
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			doTowers(topN - 1, inter, from, to);
		}
	}

	public static long fibonacci(long number) {
		if ((number == 0) || (number == 1))
			return number;
		else
			return fibonacci(number - 1) + fibonacci(number - 2);
	}

	public static long factorial(long number) {
		if (number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}
}
