/**  
* @Title: Sort.java
* @Package luozix.start.alg.actor.sort
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午2:55:03
* @version V1.0  
*/
package luozix.start.alg.actor.sort;
/**
* @ClassName: Sort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午2:55:03
*
*/
public class Sort {

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

	}

	private static void swap(Object[] arr, int i, int j) {
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void bubbleSort(int[] arr) {
		var lastIndex = arr.length - 1;

		for (var j = 0; j < lastIndex; j++) {
			for (var i = 0; i < lastIndex - j; i++) {
				if (arr[i] > arr[i + 1]) {
					var tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
	}

	public static void insertionSort(int[] arr) {
		for (var i = 1; i < arr.length; i++) {
			var tmp = arr[i];
			var j = i - 1;

			while (j >= 0 && arr[j] > tmp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = tmp;
		}
	}

	public static void quickSort(int[] arr, int left, int right) {
		var pivotIndex = left + (right - left) / 2;
		var pivotValue = arr[pivotIndex];
		var i = left;
		var j = right;
		while (i <= j) {
			while (arr[i] < pivotValue) {
				i++;
			}
			while (arr[j] > pivotValue) {
				j--;
			}
			if (i <= j) {
				var tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
			if (left < i) {
				quickSort(arr, left, j);
			}
			if (right > i) {
				quickSort(arr, i, right);
			}
		}
	}

	public static void selectionSort(int[] arr) {
		var len = arr.length;

		for (var i = 0; i < len - 1; i++) {
			var minIndex = i;

			for (var j = i + 1; j < len; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			var tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}
	}
}
