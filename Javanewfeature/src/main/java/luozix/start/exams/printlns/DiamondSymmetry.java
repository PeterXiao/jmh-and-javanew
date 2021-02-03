/**
 * 
 */
package luozix.start.exams.printlns;

/**
 * @author xiaoy
 *
 */
public class DiamondSymmetry {
	public static void main(String[] args) {
		print(8);// 输出 8 行的菱形
	}

	public static void print(int size) {
		if (size % 2 == 0) {
			size++;// 计算菱形大小
		}

		// 第一个和第二个for 循环中的代码一样。
		for (int i = 0; i < size / 2 + 1; i++) {
			for (int j = 0; j < (size / 2) - i; j++) {
				System.out.print(" ");// 输出左上角位置的空白
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");// 输出菱形上左半部边缘
			}
			System.out.println();
		}
		for (int i = size / 2 - 1; i >= 0; i--) {
			for (int j = 0; j < (size / 2) - i; j++) {
				System.out.print(" ");// 输出菱形左下角空白
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");// 输出菱形下半部边缘
			}
			System.out.println();
		}
	}
}
