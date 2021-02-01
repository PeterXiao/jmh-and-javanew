/**
 * 
 */
package luozix.start.action.exs;

/**
 * @author xiaoy
 *
 */
public class TestLogicAlg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a = true;
		boolean b = false;
		System.out.println("a && b = " + (a && b));
		System.out.println("a || b = " + (a || b));
		System.out.println("!(a && b) = " + !(a && b));

		int a1 = 5;// 定义一个变量；
		boolean b1 = (a1 < 4) && (a1++ < 10);
		System.out.println("使用短路逻辑运算符的结果为" + b1);
		System.out.println("a的结果为" + a1);

		String name = "James";
		boolean result = name instanceof String; // 由于 name 是 String 类型，所以返回真

		System.out.println(result);
	}

}
