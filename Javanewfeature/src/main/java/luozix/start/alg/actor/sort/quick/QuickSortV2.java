/**  
* @Title: QuickSortV2.java
* @Package luozix.start.alg.actor.sort.quick
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月10日 下午12:16:51
* @version V1.0  
*/
package luozix.start.alg.actor.sort.quick;

import luozix.start.alg.actor.sort.slow.SortTestHelper;

/**
 * @ClassName: QuickSortV2
 * @Description: TODO(随机化快速排序)
 * @author xiaoyu xiaoyulong07@outlook.com
 * @date 2021年2月10日 下午12:16:51
 *
 */
public class QuickSortV2 {

	/**
	 * @param args
	* @Title: main
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param args    设定文件
	* @return void    返回类型
	* @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Quick Sort也是一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		sort(arr);
		SortTestHelper.printArray(arr);
	}


	// 交换值
	private static void swap(Object[] arr, int i, int j) {
		Object tObject = arr[i];
		arr[i] = arr[j];
		arr[j] = tObject;

	}
// 对arr[l..r]部分进行partition 操作 分块
	// 返回p,使得arr[l,..p-1]<arr[p],; arr[p+1]..r]>arr[p]
	private static int partition(Comparable[] arr, int l, int r) {
		// 随机在arr[l..r]的范围中选择一个数值作为标定点pivot
		swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
		Comparable v = arr[l];
		// arr[l+1...j] < v ; arr[j+1...i) > v
		int j = l;
		for (int i = l + 1; i < r; i++) {
			{
				if (arr[i].compareTo(v) < 0) {
					j++;
					swap(arr, j, i);
				}
			}
			Comparable comparable = arr[i];

		}
		return j;
	}

	// 递归使用快速排序,对arr[l...r]的范围进行排序
	private static void sort(Comparable[] arr, int l, int r) {
		if (l>=r) {
			return;
			
		}
		int p =partition(arr, l, r);
		sort(arr, l, p-1);
		sort(arr, p+1, r);
		
		
		
	}
	
	private static void sort(Comparable[] arr) {
		int n = arr.length;
		sort(arr, 0, n - 1);

	}

}
