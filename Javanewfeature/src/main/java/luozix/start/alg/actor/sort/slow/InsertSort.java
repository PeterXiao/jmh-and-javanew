/**  
* @Title: InsertSort.java
* @Package luozix.start.alg.actor.sort.slow
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午2:12:14
* @version V1.0  
*/
package luozix.start.alg.actor.sort.slow;

import java.util.ArrayList;
import java.util.List;

/**
* @ClassName: InsertSort
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午2:12:14
*
*/
public class InsertSort {

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
		// Bsort(list);
		for (int i : insertSort(list)) {
			System.out.println(i);
		}

		System.out.println("--------------------------------");
		int[] lists = { 4, 2, 7, 1, 1, 3, 5 };

		for (Object i : interSecction(list, lists)) {
			System.out.println(i);
		}
	}

	public static int[] insertSort(int[] array) {

		for (int i = 0; i < array.length; i++) {

			int position = i;
			int tempvalue = array[i];
			while (position > 0 && array[position - 1] > tempvalue) {
				array[position] = array[position - 1];
				position = position - 1;
			}
			array[position] = tempvalue;
		}

		return array;

	}

	public static void insert_sort(int array[], int lenth) {

		int temp;

		for (int i = 0; i < lenth - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				} else { // 不需要交换
					break;
				}
			}
		}
	}

	public static List interSecction(int[] array, int[] arraylist) {

		List<Integer> list = new ArrayList<>();
		for (int i : array) {
			for (int j : arraylist) {
				if (i == j) {
					list.add(i);
					break;
				}
			}
		}

		return list;

	}
}

//懂得区分最好、平均、最坏情况，是为当前场景选择最优算法以及给现有算法调优以适应环境变化的关键。
//以下是插入排序的Python实现。
//
//def insertion_sort(array):
//    for index in range(1, len(array)):
//
//    position = index
//    temp_value = array[index]
//
//    while position > 0 and array[position - 1] > temp_value:
//        array[position] = array[position - 1]
//        position = position - 1
//
//    array[position] = temp_value
//求两个数组交集
//function intersection(first_array, second_array){
//    var result = [];
//
//    for (var i = 0; i < first_array.length; i++) {
//        for (var j = 0; j < second_array.length; j++) {
//            if (first_array[i] == second_array[j]) {
//                result.push(first_array[i]);
//            }
//        }
//    }
//    return result;
//}