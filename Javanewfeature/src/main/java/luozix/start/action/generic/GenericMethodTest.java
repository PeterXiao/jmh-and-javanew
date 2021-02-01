/**
 * 
 */
package luozix.start.action.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoy
 *
 */
public class GenericMethodTest {
	// 泛型方法 printArray
	public static <E> void printArray(E[] inputArray) {
		// 输出数组元素
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void getData(List<?> data) {
		System.out.println("data :" + data.get(0));
	}



	public static void getUperNumber(List<? extends Number> data) {
		System.out.println("data :" + data.get(0));
	}
	public static void main(String args[]) {
		// 创建不同类型数组： Integer, Double 和 Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("整型数组元素为:");
		printArray(intArray); // 传递一个整型数组

		System.out.println("\n双精度型数组元素为:");
		printArray(doubleArray); // 传递一个双精度型数组

		System.out.println("\n字符型数组元素为:");
		printArray(charArray); // 传递一个字符型数组

		List<String> name = new ArrayList<String>();
		List<Integer> age = new ArrayList<Integer>();
		List<Number> number = new ArrayList<Number>();

		name.add("icon");
		age.add(18);
		number.add(314);

		getData(name);
		getData(age);
		getData(number);

		// getUperNumber(name);// 1
		getUperNumber(age);// 2
		getUperNumber(number);// 3
	}
}
