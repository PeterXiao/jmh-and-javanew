/**  
* @Title: MergeSort.java
* @Package luozix.start.alg.actor.sort.quick
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:37:41
* @version V1.0  
*/
package luozix.start.alg.actor.sort.quick;

import java.util.Arrays;

/**
* @ClassName: MergeSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:37:41
*
*/
public class MergeSort {

	/**
	 * @param args
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args 设定文件
	 * @return void 返回类型
	 * @throws Exception
	 * @throws 作为一种典型的分而治之思想的算法应用，归并排序的实现由两种方法：
	 * 
	 *                                          自上而下的递归（所有递归的方法都可以用迭代重写，所以就有了第 2
	 *                                          种方法）； 自下而上的迭代；
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		int[] list = { 4, 2, 7, 1, 3, 5 };
		sort(list);
		for (int i : list) {
			System.out.println(i);
		}

		System.out.println(Arrays.toString(list));
		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };

	}

	public static void sort(int[] arr) {
		int[] temp = new int[arr.length];// 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		sort(arr, 0, arr.length - 1, temp);
	}

	private static void sort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(arr, left, mid, temp);// 左边归并排序，使得左子序列有序
			sort(arr, mid + 1, right, temp);// 右边归并排序，使得右子序列有序
			merge(arr, left, mid, right, temp);// 将两个有序子数组合并操作
		}
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;// 左序列指针
		int j = mid + 1;// 右序列指针
		int t = 0;// 临时数组指针
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid) {// 将左边剩余元素填充进temp中
			temp[t++] = arr[i++];
		}
		while (j <= right) {// 将右序列剩余元素填充进temp中
			temp[t++] = arr[j++];
		}
		t = 0;
		// 将temp中的元素全部拷贝到原数组中
		while (left <= right) {
			arr[left++] = temp[t++];
		}
	}

	// 将有序数组a[]和b[]合并到c[]中
	void MemeryArray(int a[], int n, int b[], int m, int c[]) {
		int i, j, k;

		i = j = k = 0;
		while (i < n && j < m) {
			if (a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}

		while (i < n)
			c[k++] = a[i++];

		while (j < m)
			c[k++] = b[j++];
	}

	public static void merge_sort(int a[], int first, int last, int temp[]) {

		if (first < last) {
			int middle = (first + last) / 2;
			merge_sort(a, first, middle, temp);// 左半部分排好序
			merge_sort(a, middle + 1, last, temp);// 右半部分排好序
			mergeArray(a, first, middle, last, temp); // 合并左右部分
		}
	}

	// 合并 ：将两个序列a[first-middle],a[middle+1-end]合并
	public static void mergeArray(int a[], int first, int middle, int end, int temp[]) {
		int i = first;
		int m = middle;
		int j = middle + 1;
		int n = end;
		int k = 0;
		while (i <= m && j <= n) {
			if (a[i] <= a[j]) {
				temp[k] = a[i];
				k++;
				i++;
			} else {
				temp[k] = a[j];
				k++;
				j++;
			}
		}
		while (i <= m) {
			temp[k] = a[i];
			k++;
			i++;
		}
		while (j <= n) {
			temp[k] = a[j];
			k++;
			j++;
		}

		for (int ii = 0; ii < k; ii++) {
			a[first + ii] = temp[ii];
		}
	}

//	public static int[] sort(int[] sourceArray) throws Exception {
//		// 对 arr 进行拷贝，不改变参数内容
//		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
//
//		if (arr.length < 2) {
//			return arr;
//		}
//		int middle = (int) Math.floor(arr.length / 2);
//
//		int[] left = Arrays.copyOfRange(arr, 0, middle);
//		int[] right = Arrays.copyOfRange(arr, middle, arr.length);
//
//		return merge(sort(left), sort(right));
//	}
//
//	protected static int[] merge(int[] left, int[] right) {
//		int[] result = new int[left.length + right.length];
//		int i = 0;
//		while (left.length > 0 && right.length > 0) {
//			if (left[0] <= right[0]) {
//				result[i++] = left[0];
//				left = Arrays.copyOfRange(left, 1, left.length);
//			} else {
//				result[i++] = right[0];
//				right = Arrays.copyOfRange(right, 1, right.length);
//			}
//		}
//
//		while (left.length > 0) {
//			result[i++] = left[0];
//			left = Arrays.copyOfRange(left, 1, left.length);
//		}
//
//		while (right.length > 0) {
//			result[i++] = right[0];
//			right = Arrays.copyOfRange(right, 1, right.length);
//		}
//
//		return result;
//	}

}

//申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
//
//设定两个指针，最初位置分别为两个已经排序序列的起始位置；
//
//比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
//
//重复步骤 3 直到某一指针达到序列尾；
//
//将另一序列剩下的所有元素直接复制到合并序列尾。
//基本思想：参考
//平均时间复杂度：O(NlogN)
//归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法的一个非常典型的应用。
//首先考虑下如何将2个有序数列合并。这个非常简单，只要从比较2个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数。然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可。