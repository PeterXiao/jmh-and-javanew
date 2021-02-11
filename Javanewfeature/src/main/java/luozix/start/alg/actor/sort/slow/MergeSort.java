/**  
* @Title: MergeSort.java
* @Package luozix.start.alg.actor.sort.slow
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午12:14:42
* @version V1.0  
*/
package luozix.start.alg.actor.sort.slow;

import java.util.Arrays;

/**
* @ClassName: MergeSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午12:14:42
*
*/
public class MergeSort {

	// 将arr[l...mid]和arr[mid+1...r]两部分进行归并
	private static void merge(Comparable[] arr, int l, int mid, int r) {

		Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

		// 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {

			if (i > mid) { // 如果左半部分元素已经全部处理完毕
				arr[k] = aux[j - l];
				j++;
			} else if (j > r) { // 如果右半部分元素已经全部处理完毕
				arr[k] = aux[i - l];
				i++;
			} else if (aux[i - l].compareTo(aux[j - l]) < 0) { // 左半部分所指元素 < 右半部分所指元素
				arr[k] = aux[i - l];
				i++;
			} else { // 左半部分所指元素 >= 右半部分所指元素
				arr[k] = aux[j - l];
				j++;
			}
		}
	}

	// 递归使用归并排序,对arr[l...r]的范围进行排序
	private static void sort(Comparable[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = (l + r) / 2;
		sort(arr, l, mid);
		sort(arr, mid + 1, r);
		// 对于arr[mid] <= arr[mid+1]的情况,不进行merge
		// 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
		if (arr[mid].compareTo(arr[mid + 1]) > 0)
			merge(arr, l, mid, r);
	}

	public static void sort(Comparable[] arr) {

		int n = arr.length;
		sort(arr, 0, n - 1);
	}

	// 测试MergeSort
	public static void main(String[] args) {

		int N = 1000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		sort(arr);
		// 打印数组
		SortTestHelper.printArray(arr);
	}
}
