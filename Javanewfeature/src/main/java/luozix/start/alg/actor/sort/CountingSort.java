/**  
* @Title: CountingSort.java
* @Package luozix.start.alg.actor.sort
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午6:28:39
* @version V1.0  
*/
package luozix.start.alg.actor.sort;

import java.util.Arrays;

/**
* @ClassName: CountingSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午6:28:39
*
*/
public class CountingSort {

	public int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		int maxValue = getMaxValue(arr);

		return countingSort(arr, maxValue);
	}

	private int[] countingSort(int[] arr, int maxValue) {
		int bucketLen = maxValue + 1;
		int[] bucket = new int[bucketLen];

		for (int value : arr) {
			bucket[value]++;
		}

		int sortedIndex = 0;
		for (int j = 0; j < bucketLen; j++) {
			while (bucket[j] > 0) {
				arr[sortedIndex++] = j;
				bucket[j]--;
			}
		}
		return arr;
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

}
