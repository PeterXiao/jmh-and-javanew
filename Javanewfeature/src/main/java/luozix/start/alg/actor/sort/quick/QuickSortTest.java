/**  
* @Title: QuickSortTest.java
* @Package luozix.start.alg.actor.sort.quick
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午3:09:52
* @version V1.0  
*/
package luozix.start.alg.actor.sort.quick;

import java.util.Arrays;

/**
* @ClassName: QuickSortTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午3:09:52
*
*/
public class QuickSortTest {

	/**
	 * @throws Exception @param args @Title: main @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param args 设定文件 @return void 返回类型 @throws
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] list = { 4, 2, 7, 1, 3, 5 };
		QuickSortTest quickSortTest = new QuickSortTest();
		// quickSortTest.sort(list);

		System.out.println(Arrays.toString(quickSortTest.sort(list)));

		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };
	}

	public int[] sort(int[] sourceArray) throws Exception {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		return quickSort(arr, 0, arr.length - 1);
	}

	private int[] quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(arr, left, right);
			quickSort(arr, left, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, right);
		}
		// System.out.println(Arrays.toString(arr));
		return arr;
	}

	private int partition(int[] arr, int left, int right) {
		// 设定基准值（pivot）
		int pivot = left;
		int index = pivot + 1;
		for (int i = index; i <= right; i++) {
			if (arr[i] < arr[pivot]) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, pivot, index - 1);
		return index - 1;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

//	public static void quickSort(int a[], int l, int r) {
//		if (l >= r)
//			return;
//
//		int i = l;
//		int j = r;
//		int key = a[l];// 选择第一个数为key
//
//		while (i < j) {
//
//			while (i < j && a[j] >= key)// 从右向左找第一个小于key的值
//				j--;
//			if (i < j) {
//				a[i] = a[j];
//				i++;
//			}
//
//			while (i < j && a[i] < key)// 从左向右找第一个大于key的值
//				i++;
//
//			if (i < j) {
//				a[j] = a[i];
//				j--;
//			}
//		}
//		// i == j
//		a[i] = key;
//		quickSort(a, l, i - 1);// 递归调用
//		quickSort(a, i + 1, r);// 递归调用
//	}
}

//基本思想：（分治）
// 平均时间复杂度：O(N*logN)
//先从数列中取出一个数作为key值；
//将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
//对左右两个小数列重复第二步，直至各区间只有1个数。
//快速排序
//快速排序严重依赖于分区。它的运作方式如下所示。
//
//(1) 把数组分区。使轴到正确的位置上去。
//
//(2) 对轴左右的两个子数组递归地重复第1、2步，也就是说，两个子数组都各自分区，并形成各自的轴以及由轴分隔的更小的子数组。然后也对这些子数组分区，以此类推。
//
//(3) 当分出的子数组长度为0或1时，即达到基准情形，无须进一步操作。

//class SortableArray
//
//attr_reader :array
//
//def initialize(array)
//  @array = array
//end
//
//def partition!(left_pointer, right_pointer)
//
//  # 总是取最右的值作为轴
//  pivot_position = right_pointer
//  pivot = @array[pivot_position]
//
//  # 将右指针指向轴左边的一格
//  right_pointer -= 1
//
//  while true do
//
//    while @array[left_pointer] < pivot do
//      left_pointer += 1
//    end
//
//    while @array[right_pointer] > pivot do
//      right_pointer -= 1
//    end
//
//    if left_pointer >= right_pointer
//      break
//    else
//      swap(left_pointer, right_pointer)
//    end
//
//  end
//
//  # 最后将左指针的值与轴交换
//  swap(left_pointer, pivot_position)
//
//  # 根据快速排序的需要，返回左指针
//  # 具体原因接下来会解释
//  return left_pointer
//end
//
//def swap(pointer_1, pointer_2)
//  temp_value = @array[pointer_1]
//  @array[pointer_1] = @array[pointer_2]
//  @array[pointer_2] = temp_value
//end
//
//end

//def quicksort!(left_index, right_index)
//# 基准情形：分出的子数组长度为0或1
//if right_index - left_index <= 0
//  return
//end
//
//# 将数组分成两部分，并返回分隔所用的轴的索引
//pivot_position = partition!(left_index, right_index)
//
//# 对轴左侧的部分递归调用quicksort
//quicksort!(left_index, pivot_position - 1)
//
//# 对轴右侧的部分递归调用quicksort
//quicksort!(pivot_position + 1, right_index)
//end

//def quickselect!(kth_lowest_value, left_index, right_index)
//# 当子数组只剩一个格子——即达到基准情形时，
//# 那我们就找到所需的值了
//if right_index - left_index <= 0
//  return @array[left_index]
//end
//
//# 将数组分成两部分，并返回分隔所用的轴的索引
//pivot_position = partition!(left_index, right_index)
//
//if kth_lowest_value < pivot_position
//  quickselect!(kth_lowest_value, left_index, pivot_position - 1)
//elsif kth_lowest_value > pivot_position
//  quickselect!(kth_lowest_value, pivot_position + 1, right_index)
//else # 至此kth_lowest_value只会等于pivot_position
//  # 如果分区后返回的轴的索引等于kth_lowest_value，
//  # 那这个轴就是我们要找的值
//  return @array[pivot_position]
//end
//end