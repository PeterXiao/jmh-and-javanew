/**  
* @Title: BubbleSort.java
* @Package luozix.start.alg.actor.sort.slow
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午12:39:01
* @version V1.0  
*/
package luozix.start.alg.actor.sort.slow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: BubbleSort
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xiaoyu xiaoyulong07@outlook.com
 * @param <T>
 * @date 2021年2月8日 下午12:39:01
 *
 */
public class BubbleSort {

	/**
	 * @throws Exception @param args @Title: main @Description:
	 *                   TODO(这里用一句话描述这个方法的作用) @param @param args 设定文件 @return void
	 *                   返回类型 @throws
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] list = { 4, 2, 7, 1, 3, 5 };
		// Bsort(list);
		for (int i : Bsort(list)) {
			System.out.println(i);
		}
		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };
		System.out.println(hasDuplicateValueL(list));
		System.out.println(hasDuplicateValueL(lists));
	}

	public static int[] Bsort(int[] list) {

		int[] lists = Arrays.copyOf(list, list.length);

		int unsorted_until_index = lists.length;
		// System.out.println(unsorted_until_index);
		for (int i = 0; i < unsorted_until_index; i++) {
			boolean sorted = true;
			for (int j = 0; j < unsorted_until_index - i - 1; j++) {
				if (lists[j] > lists[j + 1]) {
					int tmp = lists[j];
					lists[j] = lists[j + 1];
					lists[j + 1] = tmp;
					sorted = false;
				}
			}
			if (sorted) {
				break;
			}
		}

		return lists;
	}

	public static int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		for (int i = 1; i < arr.length; i++) {
			// 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
			boolean flag = true;

			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;

					flag = false;
				}
			}

			if (flag) {
				break;
			}
		}
		return arr;
	}

	public static void swap(int a, int b) {
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
	}

	public static boolean hasDuplicateValue(int[] arr) {
		boolean flag = false;
		for (var i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j && arr[i] == arr[j])
					return true;

			}
		}

		return flag;

	}

	public static boolean hasDuplicateValueL(int[] array) {
		boolean flag = false;
		Set<Integer> existingNumbers = new HashSet<>();
		for (var i = 0; i < array.length; i++) {
			if (!existingNumbers.contains(array[i])) {
				existingNumbers.add(array[i]);
	        } else {
	            return true;
	        }
		}

		return flag;

	}

	public static void BubbleSort(int[] arr) {

		int temp;// 临时变量
		for (int i = 0; i < arr.length - 1; i++) { // 表示趟数，一共arr.length-1次。
			for (int j = arr.length - 1; j > i; j--) {

				if (arr[j] < arr[j - 1]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}
//	针对问题：
//	数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，后面的比较没有意义的。
//
//	方案：
//	设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
//	这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。
	public static void BubbleSortUpdate(int[] arr) {

		int temp;// 临时变量
		boolean flag;// 是否交换的标志
		for (int i = 0; i < arr.length - 1; i++) { // 表示趟数，一共 arr.length-1 次

			// 每次遍历标志位都要先置为false，才能判断后面的元素是否发生了交换
			flag = false;

			for (int j = arr.length - 1; j > i; j--) { // 选出该趟排序的最大值往后移动

				if (arr[j] < arr[j - 1]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					flag = true; // 只要有发生了交换，flag就置为true
				}
			}
			// 判断标志位是否为false，如果为false，说明后面的元素已经有序，就直接return
			if (!flag)
				break;
		}
	}

}
