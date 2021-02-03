/**
 * 
 */
package luozix.start.exams.arrayexams;

import java.util.Arrays;

/**
 * @author xiaoy
 *
 */
public class FillArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[6];
		Arrays.fill(array, 100);
		for (int i = 0, n = array.length; i < n; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
		Arrays.fill(array, 3, 6, 50);
		for (int i = 0, n = array.length; i < n; i++) {
			System.out.println(array[i]);
		}

		String[] names = new String[] { "A", "B", "C" };
		String[] extended = new String[5];
		extended[3] = "D";
		extended[4] = "E";
		System.arraycopy(names, 0, extended, 0, names.length);
		for (String str : extended) {
			System.out.println(str);
		}

		int[] my_array = { 1, 2, 5, 5, 6, 6, 7, 2, 9, 2 };
		findDupicateInArray(my_array);
	}
//	Arrays.fill(arrayname ,starting index ,ending index ,value)
//	填充数应该是，
//	
//	大于等于 startindex(startindex <= index)，
//	
//	小于 endindex(endindex > index)。

	public static void findDupicateInArray(int[] a) {
		int count = 0;
		for (int j = 0; j < a.length; j++) {
			for (int k = j + 1; k < a.length; k++) {
				if (a[j] == a[k]) {
					count++;
				}
			}
			if (count == 1)
				System.out.println("重复元素 : " + a[j]);
			count = 0;
		}
	}
}
