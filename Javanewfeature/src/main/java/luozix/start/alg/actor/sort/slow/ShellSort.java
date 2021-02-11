/**  
* @Title: ShellSort.java
* @Package luozix.start.alg.actor.sort.slow
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:16:24
* @version V1.0  
*/
package luozix.start.alg.actor.sort.slow;
/**
* @ClassName: ShellSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午5:16:24
*
*/
public class ShellSort {

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
		shell_sort(list, 6);
		for (int i : list) {
			System.out.println(i);
		}
		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };

		for (int i : shellsort(list, 6)) {
			System.out.println(i);
		}

		int N = 2000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
		ShellSort.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}

	public static int[] shellsort(int list[], int lenth) {
		int temp = 0;
		int incre = lenth;
		int[] array = list;
		while (true) {
			incre = incre / 2;
			for (int i = 0; i < incre; i++) { // 根据增量分为若干子序列
				for (int k = i + incre; k < lenth; k += incre) {
					for (int j = k; j > i; j -= incre) {
						if (array[j] < array[j - incre]) {
							temp = array[j - incre];
							array[j - incre] = array[j];
							array[j] = temp;

						} else {
							break;
						}
					}
				}


			}
			if (incre == 1) {
				break;
			}
		}
		return array;

	}

	public static void shellSort(int[] arr) {
		int length = arr.length;
		int temp;
		for (int step = length / 2; step >= 1; step /= 2) {
			for (int i = step; i < length; i++) {
				temp = arr[i];
				int j = i - step;
				while (j >= 0 && arr[j] > temp) {
					arr[j + step] = arr[j];
					j -= step;
				}
				arr[j + step] = temp;
			}
		}
	}
	public static void shell_sort(int array[], int lenth) {

		int temp = 0;
		int incre = array.length;

		while (true) {
			incre = incre / 2;

			for (int k = 0; k < incre; k++) { // 根据增量分为若干子序列

				for (int i = k + incre; i < lenth; i += incre) {

					for (int j = i; j > k; j -= incre) {
						if (array[j] < array[j - incre]) {
							temp = array[j - incre];
							array[j - incre] = array[j];
							array[j] = temp;
						} else {
							break;
						}
					}
				}
			}

			if (incre == 1) {
				break;
			}
		}
	}

	// 核心代码---开始
	public static void sort(Comparable[] arr) {
		int j;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				Comparable tmp = arr[i];
				for (j = i; j >= gap && tmp.compareTo(arr[j - gap]) < 0; j -= gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = tmp;
			}
		}
	}
	// 核心代码---结束

}


//基本思想：
//在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
//然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。