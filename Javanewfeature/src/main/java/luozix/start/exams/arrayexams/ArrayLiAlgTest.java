/**
 * 
 */
package luozix.start.exams.arrayexams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoy
 *
 */
public class ArrayLiAlgTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ary = { 1, 2, 3, 4, 5, 6 };
		int[] ary1 = { 1, 2, 3, 4, 5, 6 };
		int[] ary2 = { 1, 2, 3, 4 };
		System.out.println("数组 ary 是否与数组 ary1相等? ：" + Arrays.equals(ary, ary1));
		System.out.println("数组 ary 是否与数组 ary2相等? ：" + Arrays.equals(ary, ary2));

		ArrayList objArray = new ArrayList();
		ArrayList objArray2 = new ArrayList();
		objArray2.add(0, "common1");
		objArray2.add(1, "common2");
		objArray2.add(2, "notcommon");
		objArray2.add(3, "notcommon1");
		objArray.add(0, "common1");
		objArray.add(1, "common2");
		objArray.add(2, "notcommon2");
		System.out.println("array1 的元素" + objArray);
		System.out.println("array2 的元素" + objArray2);
		objArray.removeAll(objArray2);
		System.out.println("array1 与 array2 数组差集为：" + objArray);

		objArray2.add(0, "common1");
		objArray2.add(1, "common2");
		objArray2.add(2, "notcommon");
		objArray2.add(3, "notcommon1");
		objArray.add(0, "common1");
		objArray.add(1, "common2");
		objArray.add(2, "notcommon2");
		System.out.println("array1 数组元素：" + objArray);
		System.out.println("array2 数组元素：" + objArray2);
		objArray.retainAll(objArray2);
		System.out.println("array2 & array1 数组交集为：" + objArray);

		objArray2.add(0, "common1");
		objArray2.add(1, "common2");
		objArray2.add(2, "notcommon");
		objArray2.add(3, "notcommon1");
		objArray.add(0, "common1");
		objArray.add(1, "common2");
		System.out.println("objArray 的数组元素：" + objArray);
		System.out.println("objArray2 的数组元素：" + objArray2);
		System.out.println("objArray 是否包含字符串common2? ： " + objArray.contains("common2"));
		System.out.println("objArray2 是否包含数组 objArray? ：" + objArray2.contains(objArray));

		String[] arr1 = { "1", "2", "3" };
		String[] arr2 = { "4", "5", "6" };
		String[] result_union = union(arr1, arr2);
		System.out.println("并集的结果如下：");

		for (String str : result_union) {
			System.out.println(str);
		}

		int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
		Arrays.sort(array);
		printArray("数组排序结果为", array);
		int index = Arrays.binarySearch(array, 2);
		System.out.println("元素 2  在第 " + index + " 个位置");

	}

	// 求两个字符串数组的并集，利用set的元素唯一性
	public static String[] union(String[] arr1, String[] arr2) {
		Set<String> set = new HashSet<String>();

		for (String str : arr1) {
			set.add(str);
		}

		for (String str : arr2) {
			set.add(str);
		}

		String[] result = {};

		return set.toArray(result);
	}

	private static void printArray(String message, int array[]) {
		System.out.println(message + ": [length: " + array.length + "]");
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.println();
	}

}
