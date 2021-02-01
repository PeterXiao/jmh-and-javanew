/**
 * 
 */
package luozix.start.action;

/**
 * @author xiaoy
 *
 */
public class Testalg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		int c = 25;
		int d = 25;
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));
		System.out.println("a * b = " + (a * b));
		System.out.println("b / a = " + (b / a));
		System.out.println("b % a = " + (b % a));
		System.out.println("c % a = " + (c % a));
		System.out.println("a++   = " + (a++));
		System.out.println("a--   = " + (a--));
		// 查看 d++ 与 ++d 的不同
		System.out.println("d++   = " + (d++));
		System.out.println("++d   = " + (++d));
	}

	@org.junit.jupiter.api.Test
	public static void nameAddSelf() {
		int a = 3;// 定义一个变量；
		int b = ++a;// 自增运算
		int c = 3;
		int d = --c;// 自减运算
		System.out.println("进行自增运算后的值等于" + b);
		System.out.println("进行自减运算后的值等于" + d);
	}

}
