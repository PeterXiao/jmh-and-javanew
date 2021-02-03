/**
 * 
 */
package luozix.start.exams.arrayexams;

import java.util.Arrays;

/**
 * @author xiaoy
 *
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
		Arrays.sort(array);
		printArray("数组排序", array);
		int index = Arrays.binarySearch(array, 1);
		System.out.println("元素 1 所在位置（负数为不存在）：" + index);
		int newIndex = -index - 1;
		array = insertElement(array, 1, newIndex);
		printArray("数组添加元素 1", array);
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

	private static int[] insertElement(int original[], int element, int index) {
		int length = original.length;
		int destination[] = new int[length + 1];
		System.arraycopy(original, 0, destination, 0, index);
		destination[index] = element;
		System.arraycopy(original, index, destination, index + 1, length - index);
		return destination;
	}
}
//
//int low = fromIndex;//0
//int high = toIndex - 1;//Array.length -1
//
//while (low <= high) {
//    int mid = (low + high) >>> 1;
//    int midVal = a[mid];
//
//    if (midVal < key)
//    low = mid + 1;
//    else if (midVal > key)
//    high = mid - 1;
//    else
//    return mid; // key found
//}
//return -(low + 1);  // key not found.