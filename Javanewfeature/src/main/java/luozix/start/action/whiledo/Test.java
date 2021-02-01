/**
 * 
 */
package luozix.start.action.whiledo;

/**
 * @author xiaoy
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 10;
		while (x < 20) {
			System.out.println("value of x is:" + x);
			x++;
			System.out.println("\n");
		}

		x = 10;
		do {
			System.out.println("value of x is:" + x);
			x++;
			System.out.println("\n");
		} while (x < 20);

		for (int i = 0; i < 20; i++) {
			System.out.println("value of x is:" + i);
			System.out.println("\n");
		}
	}

}
