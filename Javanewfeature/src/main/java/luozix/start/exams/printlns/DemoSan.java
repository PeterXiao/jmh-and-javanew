/**
 * 
 */
package luozix.start.exams.printlns;

/**
 * @author xiaoy
 *
 */
public class DemoSan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; i <= j; j--)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			for (int j = 1; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
		System.out.println("______________________________");
		print(4);

		System.out.println("______________________________");
		// 打印倒立的三角形
		for (int m = 1; m <= 4; m++) {
			// 打印空格
			for (int n = 0; n <= m; n++) {
				System.out.print(" ");
			}
			// 打印*
			for (int x = 1; x <= 7 - 2 * (m - 1); x++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("______________________________");

		printreduce(5);
		System.out.println("______________________________ \n");
		// 外层循环 每次打出一个*
		for (int i = 1; i <= 5; i++) {
			// 填充空格
			for (int j = 1; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			// 内层循环 每次打印一个*
			for (int k = 1; k <= 5; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("______________________________ \n");
		circle(10);
		System.out.println("______________________________ \n");
		printParallelogram(5);

		System.out.println("______________________________ \n");
		// 外层循环 每次输出一行*
		for (int i = 1; i <= 5; i++) {
			System.out.print("*");
			// 内层循环 每次输出一个*
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("______________________________ \n");
		print(5, 6);
	}

	public static void print(int size) {
		for (int i = size - 1; i >= 0; i--) {
			for (int j = 0; j < (size - 1) - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void printreduce(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = size; i <= j; j--)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			for (int j = 1; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	public static void circle(int r) {
		for (int y = 0; y <= 2 * r; y += 2) {
			int x = (int) Math.round(r - Math.sqrt(2 * r * y - y * y));
			int len = 2 * (r - x);
			// 圆左的空白
			for (int i = 0; i <= x; i++) {
				System.out.print(' ');
			}
			// 左半圆
			System.out.print('*');
			// 中间空白
			for (int j = 0; j <= len; j++) {
				System.out.print(' ');
			}
			// 右半圆
			System.out.println('*');
		}
	}

	public static void printParallelogram(int size) {
		// 第一个和第二个for 循环中的代码一样。
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < (size - 1) - i; j++) {
				System.out.print(" "); // 输出左上角位置的空白
			}
			for (int j = 0; j < size; j++) {
				System.out.print("*"); // 输出菱形上左半部边缘
			}
			System.out.println();
		}
	}

	private static void print(int L, int W) {
		for (int i = 1; i <= L; i++) {
			for (int j = 1; j <= W; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
