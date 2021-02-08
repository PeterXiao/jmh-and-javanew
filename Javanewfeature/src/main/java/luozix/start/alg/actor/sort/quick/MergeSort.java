/**  
* @Title: MergeSort.java
* @Package luozix.start.alg.actor.sort.quick
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:37:41
* @version V1.0  
*/
package luozix.start.alg.actor.sort.quick;
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
	* @param @param args    设定文件
	* @return void    返回类型
	* @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		int[] list = { 4, 2, 7, 1, 3, 5 };
		int[] temp = { 0, 0 };
		// merge_sort(list, 1, 3, temp);
		for (int i : list) {
			System.out.println(i);
		}
		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };

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
}
//基本思想：参考
//平均时间复杂度：O(NlogN)
//归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法的一个非常典型的应用。
//首先考虑下如何将2个有序数列合并。这个非常简单，只要从比较2个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数。然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可。