/**  
* @Title: SortUtils.java
* @Package luozix.start.alg.actor.sort
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午1:23:39
* @version V1.0  
*/
package luozix.start.alg.actor.sort;

import java.util.Arrays;
import java.util.List;

/**
* @ClassName: SortUtils
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午1:23:39
*
*/
public class SortUtils<T> {
	/**
	 * Helper method for swapping places in array
	 *
	 * @param array The array which elements we want to swap
	 * @param idx   index of the first element
	 * @param idy   index of the second element
	 */
	static <T> boolean swap(T[] array, int idx, int idy) {
		T swap = array[idx];
		array[idx] = array[idy];
		array[idy] = swap;
		return true;
	}

	/**
	 * This method checks if first element is less than the other element
	 *
	 * @param v first element
	 * @param w second element
	 * @return true if the first element is less than the second element
	 */
	static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * This method checks if first element is greater than the other element
	 *
	 * @param v first element
	 * @param w second element
	 * @return true if the first element is greater than the second element
	 */
	static <T extends Comparable<T>> boolean greater(T v, T w) {
		return v.compareTo(w) > 0;
	}

	/**
	 * Prints a list
	 *
	 * @param toPrint - a list which should be printed
	 */
	static void print(List<?> toPrint) {
		toPrint.stream().map(Object::toString).map(str -> str + " ").forEach(System.out::print);

		System.out.println();
	}

	/**
	 * Prints an array
	 *
	 * @param toPrint - an array which should be printed
	 */
	static void print(Object[] toPrint) {
		System.out.println(Arrays.toString(toPrint));
	}

	/**
	 * Swaps all position from {@param left} to @{@param right} for {@param array}
	 *
	 * @param array is an array
	 * @param left  is a left flip border of the array
	 * @param right is a right flip border of the array
	 */
	static <T extends Comparable<T>> void flip(T[] array, int left, int right) {
		while (left <= right) {
			swap(array, left++, right--);
		}
	}
}
