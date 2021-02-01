/**
 * 
 */
package luozix.start.dataalais;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoy
 *
 */
public class TestData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		list.add("HAHAHAHA");
		// 第一种遍历方法使用 For-Each 遍历 List
		for (String str : list) { // 也可以改写 for(int i=0;i<list.size();i++) 这种形式
			System.out.println(str);
		}

		// 第二种遍历，把链表变为数组相关的内容进行遍历
		String[] strArray = new String[list.size()];
		list.toArray(strArray);
		for (int i = 0; i < strArray.length; i++) // 这里也可以改写为 for(String str:strArray) 这种形式
		{
			System.out.println(strArray[i]);
		}

		// 第三种遍历 使用迭代器进行相关遍历

		Iterator<String> ite = list.iterator();
		while (ite.hasNext())// 判断下一个元素之后有值
		{
			System.out.println(ite.next());
		}

		// Map 遍历
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

	}

}

//如何使用比较器
//TreeSet和TreeMap的按照排序顺序来存储元素. 然而，这是通过比较器来精确定义按照什么样的排序顺序。
//
//这个接口可以让我们以不同的方式来排序一个集合。
//
//序号	比较器方法描述
//1	使用 Java Comparator
//这里通过实例列出Comparator接口提供的所有方法
//总结
//Java集合框架为程序员提供了预先包装的数据结构和算法来操纵他们。
//
//集合是一个对象，可容纳其他对象的引用。集合接口声明对每一种类型的集合可以执行的操作。
//
//集合框架的类和接口均在java.util包中。
//
//任何对象加入集合类后，自动转变为Object类型，所以在取出的时候，需要进行强制类型转换。
