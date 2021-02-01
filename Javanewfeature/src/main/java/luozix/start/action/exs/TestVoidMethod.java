/**
 * 
 */
package luozix.start.action.exs;

/**
 * @author xiaoy
 *
 */
public class TestVoidMethod {
	public static void main(String[] args) {
		printGrade(78.5);

		int num1 = 1;
		int num2 = 2;

		System.out.println("交换前 num1 的值为：" + num1 + " ，num2 的值为：" + num2);

		// 调用swap方法
		swap(num1, num2);
		System.out.println("交换后 num1 的值为：" + num1 + " ，num2 的值为：" + num2);

		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]: " + args[i]);
		}
	}

	public static void printGrade(double score) {
		if (score >= 90.0) {
			System.out.println('A');
		} else if (score >= 80.0) {
			System.out.println('B');
		} else if (score >= 70.0) {
			System.out.println('C');
		} else if (score >= 60.0) {
			System.out.println('D');
		} else {
			System.out.println('F');
		}
	}

	/** 交换两个变量的方法 */
	public static void swap(int n1, int n2) {
		System.out.println("\t进入 swap 方法");
		System.out.println("\t\t交换前 n1 的值为：" + n1 + "，n2 的值：" + n2);
		// 交换 n1 与 n2的值
		int temp = n1;
		n1 = n2;
		n2 = temp;

		System.out.println("\t\t交换后 n1 的值为 " + n1 + "，n2 的值：" + n2);
	}
	public static void nPrintln(String message, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(message);
		}
	}
}
