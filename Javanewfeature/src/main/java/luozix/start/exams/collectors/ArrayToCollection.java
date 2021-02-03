/**
 * 
 */
package luozix.start.exams.collectors;

import java.io.IOException;
import java.util.ArrayList;
/**
 * @author xiaoy
 *
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArrayToCollection {
	public static void main(String args[]) throws IOException {
		int n = 5; // 5 个元素
		String[] name = new String[n];
		for (int i = 0; i < n; i++) {
			name[i] = String.valueOf(i);
		}
		List<String> list = Arrays.asList(name);
		System.out.println();
		for (String li : list) {
			String str = li;
			System.out.print(str + " ");
		}

		String[] coins = { "Penny", "nickel", "dime", "Quarter", "dollar" };
		Set<String> set = new TreeSet<String>();
		for (int i = 0; i < coins.length; i++) {
			set.add(coins[i]);
		}
		System.out.println(Collections.min(set));
		System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER));
		for (int i = 0; i <= 10; i++) {
			System.out.print("-");
		}
		System.out.println("");
		System.out.println(Collections.max(set));
		System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));

		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("1", "1st");
		hMap.put("2", "2nd");
		hMap.put("3", "3rd");
		Collection cl = hMap.values();
		Iterator itr = cl.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("集合实例!\n");
		int size;
		HashSet collection = new HashSet();
		String str1 = "Yellow", str2 = "White", str3 = "Green", str4 = "Blue";
		Iterator iterator;
		collection.add(str1);
		collection.add(str2);
		collection.add(str3);
		collection.add(str4);
		System.out.print("集合数据: ");
		iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		size = collection.size();
		if (collection.isEmpty()) {
			System.out.println("集合是空的");
		} else {
			System.out.println("集合长度: " + size);
		}
		System.out.println();

		// 如何使用 Collections 类 Collections.shuffle() 方法来打乱集合元素的顺序：

		List<Integer> list1 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			list1.add(new Integer(i));
		System.out.println("打乱前:");
		System.out.println(list1);

		for (int i = 1; i < 6; i++) {
			System.out.println("第" + i + "次打乱：");
			Collections.shuffle(list1);
			System.out.println(list1);
		}
	}
}
