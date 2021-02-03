/**
 * 
 */
package luozix.start.exams.funcs;

/**
 * @author xiaoy
 *
 */

class MainClass {
	int height;

	MainClass() {
		System.out.println("无参数构造函数");
		height = 4;
	}

	MainClass(int i) {
		System.out.println("房子高度为 " + i + " 米");
		height = i;
	}

	void info() {
		System.out.println("房子高度为 " + height + " 米");
	}

	void info(String s) {
		System.out.println(s + ": 房子高度为 " + height + " 米");
	}
}
public class MyClass {
	public static void main(String[] args) {
		MainClass t = new MainClass(3);
		t.info();
		t.info("重载方法");
		// 重载构造函数
		new MyClass();

		Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };
		System.out.println("输出整型数组:");
		printArray(integerArray);
		System.out.println("\n输出双精度型数组:");
		printArray(doubleArray);
		System.out.println("\n输出字符型数组:");
		printArray(characterArray);
	}

	public static void printArray(Integer[] inputArray) {
		for (Integer element : inputArray) {
			System.out.printf("%s ", element);
			System.out.println();
		}
	}

	public static void printArray(Double[] inputArray) {
		for (Double element : inputArray) {
			System.out.printf("%s ", element);
			System.out.println();
		}
	}

	public static void printArray(Character[] inputArray) {
		for (Character element : inputArray) {
			System.out.printf("%s ", element);
			System.out.println();
		}
	}
}
