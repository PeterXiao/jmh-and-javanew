/**
 *
 */
package basics.lists;

/**
 * @author Office
 *
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayListTest {

    public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	list.add("Hello");
	list.add("World");
	list.add("HAHAHAHA");
	// 第一种遍历方法使用foreach遍历List
	for (String str : list) { // 也可以改写for(int i=0;i<list.size();i++)这种形式
	    System.out.println(str);
	}

	// 第二种遍历，把链表变为数组相关的内容进行遍历
	String[] strArray = new String[list.size()];
	list.toArray(strArray);
	for (int i = 0; i < strArray.length; i++) // 这里也可以改写为 foreach(String str:strArray)这种形式
	{
	    System.out.println(strArray[i]);
	}

	// 第三种遍历 使用迭代器进行相关遍历

	Iterator<String> ite = list.iterator();
	while (ite.hasNext())// 判断下一个元素之后有值
	{
	    System.out.println(ite.next());
	}

	Map<String, String> map = new HashMap<String, String>();
	map.put("1", "value1");
	map.put("2", "value2");
	map.put("3", "value3");

	// 第一种：普遍使用，二次取值
	System.out.println("通过Map.keySet遍历key和value：");
	for (String key : map.keySet()) {
	    System.out.println("key= " + key + " and value= " + map.get(key));
	}

	// 第二种
	System.out.println("通过Map.entrySet使用iterator遍历key和value：");
	Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
	while (it.hasNext()) {
	    Map.Entry<String, String> entry = it.next();
	    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
	}

	// 第三种：推荐，尤其是容量大时
	System.out.println("通过Map.entrySet遍历key和value");
	for (Map.Entry<String, String> entry : map.entrySet()) {
	    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
	}

	// 第四种
	System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
	for (String v : map.values()) {
	    System.out.println("value= " + v);
	}

	final String message = "message";
	List<String> messages = IntStream.range(1, 11).mapToObj(i -> {
	    char[] chars = new char[i];
	    Arrays.fill(chars, '.');
	    return message + String.valueOf(chars);
	}).collect(Collectors.toList());
	System.out.println(message);
	List<String> list1 = new ArrayList<String>();
	list1.add("好好学习");
	list1.add("天天向上");
	list1.add("不做码农");

	// 1.增强for
//      for(String s : list)
//          System.out.println(s);

	// 2.Iterator
//      Iterator i = list.iterator();
//      while(i.hasNext())
//          System.out.println(i.next());

	// 3.我偶然看到的，觉得很强。。。
//      for(Iterator i = list.iterator(); i.hasNext();)
//          System.out.println(i.next());

	// 4.forEach的Lambda表达式实现
//      list.forEach(a -> System.out.println(a));

	// 5.forEach的内部类实现
//      list.forEach(new Consumer<String>() {
//
//          @Override
//          public void accept(String t) {
//               System.out.println(t);
//          }
//      });

	// 6.我写了那么多，把这个给忘了。。
//      for(int i = 0; i < list.size(); i++)
//          System.out.println(list.get(i));

	// 7.ListIterator实现，是Iterator的
//      ListIterator<String> listi =  list.listIterator();
//      while(listi.hasNext())
//          System.out.println(listi.next());

	// 8.和上面第三条思路一样
	for (ListIterator<String> listi = list1.listIterator(); listi.hasNext();)
	    System.out.println(listi.next());
    }
}