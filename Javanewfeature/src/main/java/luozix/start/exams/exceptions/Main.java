/**
 * 
 */
package luozix.start.exams.exceptions;

/**
 * @author xiaoy
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String args[]) throws Exception {
		int n = 20, result = 0;
		try {
			result = n / 0;
			System.out.println("结果为" + result);
		} catch (ArithmeticException ex) {
			System.out.println("发算术异常: " + ex);
			try {
				throw new NumberFormatException();
			} catch (NumberFormatException ex1) {
				System.out.println("手动抛出链试异常 : " + ex1);
			}
		}

		Main mn = new Main();
		try {
			System.out.println(method(10, 20.0));
			System.out.println(method(10.0, 20));
			System.out.println(method(10.0, 20.0));
			System.out.println(mn.method(10));
		} catch (Exception ex) {
			System.out.println("exception occoure: " + ex);
		}

		int array[] = { 20, 20, 40 };
		int num1 = 15, num2 = 10;
		int resultlist = 10;
		try {
			resultlist = num1 / num2;
			System.out.println("The result is" + resultlist);
			for (int i = 5; i >= 0; i--) {
				System.out.println("The value of array is" + array[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	double method(int i) throws Exception {
		return i / 0;
	}

	boolean method(boolean b) {
		return !b;
	}

	static double method(int x, double y) throws Exception {
		return x + y;
	}

	static double method(double x, double y) {
		return x + y - 3;
	}
}
