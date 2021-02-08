/**  
* @Title: QuickSortTest.java
* @Package luozix.start.alg.actor.sort.quick
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午3:09:52
* @version V1.0  
*/
package luozix.start.alg.actor.sort.quick;
/**
* @ClassName: QuickSortTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月8日 下午3:09:52
*
*/
public class QuickSortTest {

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

}
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