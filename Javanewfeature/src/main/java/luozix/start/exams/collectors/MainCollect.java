/**
 * 
 */
package luozix.start.exams.collectors;

/**
 * @author xiaoy
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainCollect {

	/**
	 * @param args
	 */


	public static void main(String[] args) {
		// List集合的遍历
		listTest();
		// Set集合的遍历
		setTest();

		// 创建一个HashMap对象,并加入了一些键值对。
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("1", "PHP");
		maps.put("2", "Java");
		maps.put("3", "C");
		maps.put("4", "C++");
		maps.put("5", "HTML");

		// 传统的遍历map集合的方法1; keySet()
		// traditionalMethod1(maps);
		// 传统的遍历map集合的方法2; entrySet()
		// traditionalMethod2(maps);
		// 使用增强For循环来遍历map集合方法1; keySet()
		// strongForMethod1(maps);
		// 使用增强For循环来遍历map集合方法2; entrySet()
		strongForMethod2(maps);

		String[] coins = { "A", "B", "C", "D", "E" };
		List l = new ArrayList();
		for (int i = 0; i < coins.length; i++)
			l.add(coins[i]);
		ListIterator liter = l.listIterator();
		System.out.println("反转前");
		while (liter.hasNext())
			System.out.println(liter.next());
		Collections.reverse(l);
		liter = l.listIterator();
		System.out.println("反转后");
		while (liter.hasNext())
			System.out.println(liter.next());
		
		//del 集合数据
		System.out.println( "集合实例!\n" ); 
	      int size;
	      HashSet collection = new HashSet ();
	      String str1 = "Yellow", str2 = "White", str3 = 
	      "Green", str4 = "Blue";  
	      Iterator iterator;
	      collection.add(str1);    
	      collection.add(str2);   
	      collection.add(str3);   
	      collection.add(str4);
	      System.out.print("集合数据: ");  
	      iterator = collection.iterator();     
	      while (iterator.hasNext()){
	         System.out.print(iterator.next() + " ");  
	      }
	      System.out.println();
	      collection.remove(str2);
	      System.out.println("删除之后 [" + str2 + "]\n");
	      System.out.print("现在集合的数据是: ");
	      iterator = collection.iterator();     
	      while (iterator.hasNext()){
	         System.out.print(iterator.next() + " ");  
	      }
	      System.out.println();
	      size = collection.size();
			System.out.println("集合大小: " + size + "\n");
	}

	private static void setTest() {
		Set<String> set = new HashSet<String>();
		set.add("JAVA");
		set.add("C");
		set.add("C++");
		// 重复数据添加失败
		set.add("JAVA");
		set.add("JAVASCRIPT");

		// 使用iterator遍历set集合
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}

		// 使用增强for循环遍历set集合
		for (String s : set) {
			System.out.println(s);
		}
	}

	// 遍历list集合
	private static void listTest() {
		List<String> list = new ArrayList<String>();
		list.add("菜");
		list.add("鸟");
		list.add("教");
		list.add("程");
		list.add("www.runoob.com");

		// 使用iterator遍历
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}

		// 使用传统for循环进行遍历
		for (int i = 0, size = list.size(); i < size; i++) {
			String value = list.get(i);
			System.out.println(value);
		}

		// 使用增强for循环进行遍历
		for (String value : list) {
			System.out.println(value);
		}
	}

	private static void strongForMethod2(Map<String, String> maps) {
		Set<Entry<String, String>> set = maps.entrySet();
		for (Entry<String, String> entry : set) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
	}

	private static void strongForMethod1(Map<String, String> maps) {
		Set<String> set = maps.keySet();
		for (String s : set) {
			String key = s;
			String value = maps.get(s);
			System.out.println(key + " : " + value);
		}
	}

	// 使用entrySet()方法，获取maps集合中的每一个键值对，
	private static void traditionalMethod2(Map<String, String> maps) {
		Set<Map.Entry<String, String>> sets = maps.entrySet();
		// 取得迭代器遍历出对应的值。
		Iterator<Entry<String, String>> it = sets.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
	}

	// 使用keySet()方法，获取maps集合中的所有键，遍历键取得所对应的值。
	private static void traditionalMethod1(Map<String, String> maps) {
		Set<String> sets = maps.keySet();
		// 取得迭代器遍历出对应的值
		Iterator<String> it = sets.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = maps.get(key);
			System.out.println(key + " : " + value);
		}
	}
}