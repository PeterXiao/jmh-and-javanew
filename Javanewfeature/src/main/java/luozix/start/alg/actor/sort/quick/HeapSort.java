/**  
* @Title: HeapSort.java
* @Package luozix.start.alg.actor.sort.quick
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:40:22
* @version V1.0  
*/
package luozix.start.alg.actor.sort.quick;

import java.util.Arrays;

/**
* @ClassName: HeapSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:40:22
*
*/
public class HeapSort {

	/**
	 * @throws Exception @param args @Title: main @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param args 设定文件 @return void 返回类型 @throws
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] list = { 4, 2, 7, 1, 3, 5 };
		// MinHeap_Sort(list, 3);
		HeapSort heapSort = new HeapSort();
		for (int i : heapSort.sort(list)) {
			System.out.println(i);
		}
		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };
	}

	public int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		int len = arr.length;

		buildMaxHeap(arr, len);

		for (int i = len - 1; i > 0; i--) {
			swap(arr, 0, i);
			len--;
			heapify(arr, 0, len);
		}
		return arr;
	}

	private void buildMaxHeap(int[] arr, int len) {
		for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
			heapify(arr, i, len);
		}
	}

	private void heapify(int[] arr, int i, int len) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;

		if (left < len && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < len && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, largest, len);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	// 构建最小堆
	public static void MakeMinHeap(int a[], int n) {
		for (int i = (n - 1) / 2; i >= 0; i--) {
			MinHeapFixdown(a, i, n);
		}
	}

	// 从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
	public static void MinHeapFixdown(int a[], int i, int n) {

		int j = 2 * i + 1; // 子节点
		int temp = 0;

		while (j < n) {
			// 在左右子节点中寻找最小的
			if (j + 1 < n && a[j + 1] < a[j]) {
				j++;
			}

			if (a[i] <= a[j])
				break;

			// 较大节点下移
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;

			i = j;
			j = 2 * i + 1;
		}
	}

	public static void MinHeap_Sort(int a[], int n) {
		int temp = 0;
		MakeMinHeap(a, n);

		for (int i = n - 1; i > 0; i--) {
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			MinHeapFixdown(a, 0, i);
		}
	}
}
//两种方法：
//
//大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
//小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
//创建一个堆 H[0……n-1]；
//
//把堆首（最大值）和堆尾互换；
//
//把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
//
//重复步骤 2，直到堆的尺寸为 1。