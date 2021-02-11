/**  
* @Title: QuickSort3Ways.java
* @Package luozix.start.alg.actor.sort.slow
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午12:55:40
* @version V1.0  
*/
package luozix.start.alg.actor.sort.slow;
/**
* @ClassName: QuickSort3Ways
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午12:55:40
*
*/
/**
 * 三路快速排序
 */
public class QuickSort3Ways {
	// 核心代码---开始
	// 递归使用快速排序,对arr[l...r]的范围进行排序
	private static void sort(Comparable[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		// 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
		swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
		Comparable v = arr[l];
		int lt = l; // arr[l+1...lt] < v
		int gt = r + 1; // arr[gt...r] > v
		int i = l + 1; // arr[lt+1...i) == v
		while (i < gt) {
			if (arr[i].compareTo(v) < 0) {
				swap(arr, i, lt + 1);
				i++;
				lt++;
			} else if (arr[i].compareTo(v) > 0) {
				swap(arr, i, gt - 1);
				gt--;
			} else { // arr[i] == v
				i++;
			}
		}
		swap(arr, l, lt);
		sort(arr, l, lt - 1);
		sort(arr, gt, r);
	}
	// 核心代码---结束

	public static void sort(Comparable[] arr) {

		int n = arr.length;
		sort(arr, 0, n - 1);
	}

	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// 测试 QuickSort3Ways
	public static void main(String[] args) {

		// 三路快速排序算法也是一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		sort(arr);
		SortTestHelper.printArray(arr);
	}
}