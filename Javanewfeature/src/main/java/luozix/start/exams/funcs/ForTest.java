/**
 * 
 */
package luozix.start.exams.funcs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xiaoy
 *
 */
public class ForTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intary = { 1, 2, 3, 4 };
		forDisplay(intary);
		foreachDisplay(intary);

		int[] arr = { 1, 2, 3, 4, 5 };

		System.out.println("----------使用 for 循环------------");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("---------使用 For-Each 循环-------------");

		// 增强的 for 循环 For-Each
		for (int element : arr) {
			System.out.println(element);
		}

		System.out.println("---------For-Each 循环二维数组-------------");

		// 遍历二维数组
		int[][] arr2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int[] row : arr2) {
			for (int element : row) {
				System.out.println(element);
			}
		}

		// 以三种方式遍历集合 List
		List<String> list = new ArrayList<String>();

		list.add("Google");
		list.add("Runoob");
		list.add("Taobao");

		System.out.println("----------方式1：普通for循环-----------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("----------方式2：使用迭代器-----------");
		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}

		System.out.println("----------方式3：For-Each 循环-----------");
		for (String str : list) {
			System.out.println(str);
		}

		int sum = 0;
		sum = sumvarargs(new int[] { 10, 12, 33 });
		System.out.println("数字相加之和为: " + sum);

		vaTest(1, 2, 3);
		vaTest("测试: ", 10, 20);
		vaTest(true, false, false);
	}

	public static void forDisplay(int[] a) {
		System.out.println("使用 for 循环数组");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void foreachDisplay(int[] data) {
		System.out.println("使用 foreach 循环数组");
		for (int a : data) {
			System.out.print(a + " ");
		}
	}

	static int sumvarargs(int... intArrays) {
		int sum, i;
		sum = 0;
		for (i = 0; i < intArrays.length; i++) {
			sum += intArrays[i];
		}
		return (sum);
	}

	static void vaTest(int... no) {
		System.out.print("vaTest(int ...): " + "参数个数: " + no.length + " 内容: ");
		for (int n : no)
			System.out.print(n + " ");
		System.out.println();
	}

	static void vaTest(boolean... bl) {
		System.out.print("vaTest(boolean ...) " + "参数个数: " + bl.length + " 内容: ");
		for (boolean b : bl)
			System.out.print(b + " ");
		System.out.println();
	}

	static void vaTest(String msg, int... no) {
		System.out.print("vaTest(String, int ...): " + msg + "参数个数: " + no.length + " 内容: ");
		for (int n : no)
			System.out.print(n + " ");
		System.out.println();
	}
}
