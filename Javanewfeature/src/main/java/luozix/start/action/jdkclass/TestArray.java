/**
 * 
 */
package luozix.start.action.jdkclass;

/**
 * @author xiaoy
 *
 */
public class TestArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 数组大小
		int size = 10;
		// 定义数组
		double[] myList = new double[size];
		myList[0] = 5.6;
		myList[1] = 4.5;
		myList[2] = 3.3;
		myList[3] = 13.2;
		myList[4] = 4.0;
		myList[5] = 34.33;
		myList[6] = 34.0;
		myList[7] = 45.45;
		myList[8] = 99.993;
		myList[9] = 11123;
		// 计算所有元素的总和
		double total = 0;
		for (int i = 0; i < size; i++) {
			total += myList[i];
		}
		System.out.println("总和为： " + total);

		double[] myList1 = { 1.9, 2.9, 3.4, 3.5 };

		// 打印所有数组元素
		for (int i = 0; i < myList1.length; i++) {
			System.out.println(myList1[i] + " ");
		}
		// 计算所有元素的总和
		double total1 = 0;
		for (int i = 0; i < myList1.length; i++) {
			total1 += myList1[i];
		}
		System.out.println("Total is " + total1);
		// 查找最大元素
		double max = myList1[0];
		for (int i = 1; i < myList1.length; i++) {
			if (myList1[i] > max)
				max = myList1[i];
		}
		System.out.println("Max is " + max);
		printArray(new int[] { 3, 1, 2, 6, 4, 2 });
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static int[] reverse(int[] list) {
		int[] result = new int[list.length];

		for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
			result[j] = list[i];
		}
		return result;
	}

}

/*
 * 
 * For-Each 循环 JDK 1.5 引进了一种新的循环类型，被称为 For-Each 循环或者加强型循环，它能在不使用下标的情况下遍历数组。
 * 
 * 语法格式如下：
 * 
 * for(type element: array) { System.out.println(element); }
 * 
 */
