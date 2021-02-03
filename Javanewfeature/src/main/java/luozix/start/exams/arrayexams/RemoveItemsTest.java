/**
 * 
 */
package luozix.start.exams.arrayexams;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiaoy
 *
 */
public class RemoveItemsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> objArrayList = new ArrayList<>();
		objArrayList.clear();
		objArrayList.add(0, "第 0 个元素");
		objArrayList.add(1, "第 1 个元素");
		objArrayList.add(2, "第 2 个元素");
		System.out.println("数组删除元素前：" + objArrayList);
		objArrayList.remove(1);
		objArrayList.remove("第 0 个元素");
		System.out.println("数组删除元素后：" + objArrayList);

		int[] oldarray = new int[] { 3, 4, 5, 6, 7 };// 原始数组
		int num = 2; // 删除索引为 2 的元素，即删除第三个元素 5
		int[] newArray = new int[oldarray.length - 1];// 新数组，长度为原始数组减去 1

		for (int i = 0; i < newArray.length; i++) {
			// 判断元素是否越界
			if (num < 0 || num >= oldarray.length) {
				throw new RuntimeException("元素越界... ");
			}
			//
			if (i < num) {
				newArray[i] = oldarray[i];
			} else {
				newArray[i] = oldarray[i + 1];
			}
		}
		// 打印输出数组内容
		System.out.println(Arrays.toString(oldarray));
		oldarray = newArray;
		System.out.println(Arrays.toString(oldarray));
	}

}
