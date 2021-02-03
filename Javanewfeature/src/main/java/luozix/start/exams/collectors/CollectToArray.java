/**
 * 
 */
package luozix.start.exams.collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author xiaoy
 *
 */
public class CollectToArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("菜");
		list.add("鸟");
		list.add("教");
		list.add("程");
		list.add("www.runoob.com");
		String[] s1 = list.toArray(new String[0]);
		for (int i = 0; i < s1.length; ++i) {
			String contents = s1[i];
			System.out.print(contents);
		}

		List list1 = Arrays.asList("one Two three Four five six".split(" "));
		System.out.println("List :" + list1);
		Collections.rotate(list1, 3);
		System.out.println("rotate: " + list1);

		List listmax = Arrays.asList("one Two three Four five six one three Four".split(" "));
		System.out.println(listmax);
		System.out.println("最大值: " + Collections.max(listmax));
		System.out.println("最小值: " + Collections.min(listmax));

		Hashtable ht = new Hashtable();
		ht.put("1", "One");
		ht.put("2", "Two");
		ht.put("3", "Three");
		Enumeration e = ht.keys();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

		Enumeration e1 = ht.elements();
		while (e1.hasMoreElements()) {
			System.out.println(e1.nextElement());
		}

		List lnkLst = new LinkedList();
		lnkLst.add("element1");
		lnkLst.add("element2");
		lnkLst.add("element3");
		lnkLst.add("element4");
		displayAll(lnkLst);
		List aryLst = new ArrayList();
		aryLst.add("x");
		aryLst.add("y");
		aryLst.add("z");
		aryLst.add("w");
		displayAll(aryLst);
		Set hashSet = new HashSet();
		hashSet.add("set1");
		hashSet.add("set2");
		hashSet.add("set3");
		hashSet.add("set4");
		displayAll(hashSet);
		SortedSet treeSet = new TreeSet();
		treeSet.add("1");
		treeSet.add("2");
		treeSet.add("3");
		treeSet.add("4");
		displayAll(treeSet);
		LinkedHashSet lnkHashset = new LinkedHashSet();
		lnkHashset.add("one");
		lnkHashset.add("two");
		lnkHashset.add("three");
		lnkHashset.add("four");
		displayAll(lnkHashset);
		Map map1 = new HashMap();
		map1.put("key1", "J");
		map1.put("key2", "K");
		map1.put("key3", "L");
		map1.put("key4", "M");
		displayAll(map1.keySet());
		displayAll(map1.values());
		SortedMap map2 = new TreeMap();
		map2.put("key1", "JJ");
		map2.put("key2", "KK");
		map2.put("key3", "LL");
		map2.put("key4", "MM");
		displayAll(map2.keySet());
		displayAll(map2.values());
		LinkedHashMap map3 = new LinkedHashMap();
		map3.put("key1", "JJJ");
		map3.put("key2", "KKK");
		map3.put("key3", "LLL");
		map3.put("key4", "MMM");
		displayAll(map3.keySet());
		displayAll(map3.values());

		List listL = Arrays.asList("one Two three Four five six one three Four".split(" "));
		System.out.println("List :" + listL);
		Collections.replaceAll(listL, "one", "hundrea");
		System.out.println("replaceAll: " + listL);
	}
	
	static void displayAll(Collection col) {
		Iterator itr = col.iterator();
		while (itr.hasNext()) {
			String str = (String) itr.next();
			System.out.print(str + " ");
		}
		System.out.println();
	}
//	//排序
//	Collections.sort(list, new Comparator<Map<String,Object>>() {
//	  @Override
//	  public int compare(Map<String, Object> o1, Map<String, Object> o2) {
//	    //根据分数进行判断
//	    return (Float.valueOf((String)o2.get("score"))).compareTo(Float.valueOf((String)o1.get("score")));
//	  }
//	});

}
