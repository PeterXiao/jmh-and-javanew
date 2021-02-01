/**
 * 
 */
package luozix.start.action.exs;

/**
 * @author xiaoy
 *
 */
public class selfAddMinus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 5;
		int b = 5;
		int x = 2 * ++a;
		int y = 2 * b++;
		System.out.println("自增运算符前缀运算后a=" + a + ",x=" + x);
		System.out.println("自增运算符后缀运算后b=" + b + ",y=" + y);

		int a1 = 10;
		int b1 = 20;
		System.out.println("a == b = " + (a1 == b1));
		System.out.println("a != b = " + (a1 != b1));
		System.out.println("a > b = " + (a1 > b1));
		System.out.println("a < b = " + (a1 < b1));
		System.out.println("b >= a = " + (b1 >= a1));
		System.out.println("b <= a = " + (b1 <= a1));
	}

}
