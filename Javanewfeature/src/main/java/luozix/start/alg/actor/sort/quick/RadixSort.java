/**  
* @Title: RadixSort.java
* @Package luozix.start.alg.actor.sort.quick
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:50:18
* @version V1.0  
*/
package luozix.start.alg.actor.sort.quick;

import java.util.Arrays;

/**
* @ClassName: RadixSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:50:18
*
*/
//基本思想：
//BinSort想法非常简单，首先创建数组A[MaxValue]；然后将每个数放到相应的位置上（例如17放在下标17的数组位置）；最后遍历数组，即为排序后的结果。
public class RadixSort {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] list = { 4, 2, 7, 1, 3, 5 };
		RadixSort radixSort = new RadixSort();
		System.out.println(Arrays.toString(radixSort.sort(list)));
		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };
	}

	public int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		int maxDigit = getMaxDigit(arr);
		return radixSort(arr, maxDigit);
	}

	/**
	 * 获取最高位数
	 */
	private int getMaxDigit(int[] arr) {
		int maxValue = getMaxValue(arr);
		return getNumLenght(maxValue);
	}

	private int getMaxValue(int[] arr) {
		int maxValue = arr[0];
		for (int value : arr) {
			if (maxValue < value) {
				maxValue = value;
			}
		}
		return maxValue;
	}

	protected int getNumLenght(long num) {
		if (num == 0) {
			return 1;
		}
		int lenght = 0;
		for (long temp = num; temp != 0; temp /= 10) {
			lenght++;
		}
		return lenght;
	}

	private int[] radixSort(int[] arr, int maxDigit) {
		int mod = 10;
		int dev = 1;

		for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
			// 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
			int[][] counter = new int[mod * 2][0];

			for (int j = 0; j < arr.length; j++) {
				int bucket = ((arr[j] % mod) / dev) + mod;
				counter[bucket] = arrayAppend(counter[bucket], arr[j]);
			}

			int pos = 0;
			for (int[] bucket : counter) {
				for (int value : bucket) {
					arr[pos++] = value;
				}
			}
		}

		return arr;
	}

	/**
	 * 自动扩容，并保存数据
	 *
	 * @param arr
	 * @param value
	 */
	private int[] arrayAppend(int[] arr, int value) {
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = value;
		return arr;
	}
	public static void RadixSort(int A[], int temp[], int n, int k, int r, int cnt[]) {

		// A:原数组
		// temp:临时数组
		// n:序列的数字个数
		// k:最大的位数2
		// r:基数10
		// cnt:存储bin[i]的个数

		for (int i = 0, rtok = 1; i < k; i++, rtok = rtok * r) {

			// 初始化
			for (int j = 0; j < r; j++) {
				cnt[j] = 0;
			}
			// 计算每个箱子的数字个数
			for (int j = 0; j < n; j++) {
				cnt[(A[j] / rtok) % r]++;
			}
			// cnt[j]的个数修改为前j个箱子一共有几个数字
			for (int j = 1; j < r; j++) {
				cnt[j] = cnt[j - 1] + cnt[j];
			}
			for (int j = n - 1; j >= 0; j--) { // 重点理解
				cnt[(A[j] / rtok) % r]--;
				temp[cnt[(A[j] / rtok) % r]] = A[j];
			}
			for (int j = 0; j < n; j++) {
				A[j] = temp[j];
			}
		}
	}
}
//BinSort
//
//问题： 当序列中存在较大值时，BinSort 的排序方法会浪费大量的空间开销。
//RadixSort
//基本思想： 基数排序是在BinSort的基础上，通过基数的限制来减少空间的开销。
//（1）首先确定基数为10，数组的长度也就是10.每个数34都会在这10个数中寻找自己的位置。
//（2）不同于BinSort会直接将数34放在数组的下标34处，基数排序是将34分开为3和4，第一轮排序根据最末位放在数组的下标4处，第二轮排序根据倒数第二位放在数组的下标3处，然后遍历数组即可。