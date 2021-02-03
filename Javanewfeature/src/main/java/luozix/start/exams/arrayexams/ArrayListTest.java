/**
 * 
 */
package luozix.start.exams.arrayexams;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author xiaoy
 *
 */
public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] dataAStrings = new String[2][5];

		System.out.println("第一维数组长度： " + dataAStrings.length);

		System.out.println("第二维数组长度： " + dataAStrings[0].length);

		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int rows = array.length;
		int columns = array[0].length;

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("C");
		arrayList.add("D");
		arrayList.add("E");
		System.out.println("反转前排序: " + arrayList);
		Collections.reverse(arrayList);
		System.out.println("反转后排序: " + arrayList);
	}

	public static int[] reserve(int[] arr) {
		int[] arr1 = new int[arr.length];
		for (int x = 0; x < arr.length; x++) {
			arr1[x] = arr[arr.length - x - 1];
		}
		return arr1;
	}
}
