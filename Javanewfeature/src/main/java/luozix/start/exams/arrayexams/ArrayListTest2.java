/**
 * 
 */
package luozix.start.exams.arrayexams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author xiaoy
 *
 */
public class ArrayListTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String[] runoobs = new String[3];
		runoobs[0] = "菜鸟教程";
		runoobs[1] = "菜鸟工具";
		runoobs[2] = "菜鸟笔记";
		for (int i = 0; i < runoobs.length; i++) {
			System.out.println(runoobs[i]);
		}

		for (String obj : runoobs) {
			System.out.println(obj + "\n");
		}

		ArrayList<String> runoobs1 = new ArrayList<String>();
		runoobs1.add("www.");
		runoobs1.add("runoob");
		runoobs1.add(".com");
		for (Iterator<String> iterator = runoobs1.iterator(); iterator.hasNext(); System.out.println(iterator.next())) {


		}

		Integer[] numbers = { 8, 2, 7, 1, 4, 9, 5 };
		int min = (int) Collections.min(Arrays.asList(numbers));
		int max = (int) Collections.max(Arrays.asList(numbers));
		System.out.println("最小值: " + min);
		System.out.println("最大值: " + max);
	}

}
