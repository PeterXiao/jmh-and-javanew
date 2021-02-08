/**  
* @Title: SelectSort.java
* @Package luozix.start.alg.actor.sort.slow
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午1:59:12
* @version V1.0  
*/
package luozix.start.alg.actor.sort.slow;

import java.util.Arrays;

import lombok.experimental.var;

/**
* @ClassName: SelectSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午1:59:12
*
*/
public class SelectSort {

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
		int[] list = { 4, 2, 7, 1, 3, 5 };
		// Bsort(list);
		for (int i : selectionSort(list)) {
			System.out.println(i);
		}
		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };

		for (int i : selectionSort(lists)) {
			System.out.println(i);
		}
	}

	public static int[] selectionSort(int[] array) {

		int[] lists = Arrays.copyOf(array, array.length);
		for (int i = 0; i < lists.length; i++) {
			int lowerNumberIndex = i;
			for (int j = i + 1; j < lists.length; j++) {
				if (lists[j] < lists[lowerNumberIndex]) {
					lowerNumberIndex = j;
				}
			}
			if (lowerNumberIndex != i) {
				var temp = lists[i];
				lists[i] = lists[lowerNumberIndex];
				lists[lowerNumberIndex] = temp;
			}

		}

		return lists;
	}
}
