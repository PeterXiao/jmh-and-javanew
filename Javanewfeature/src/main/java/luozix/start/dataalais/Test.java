/**
 * 
 */
package luozix.start.dataalais;

import java.util.HashMap;

/**
 * @author xiaoy
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建 HashMap 对象 Sites
		HashMap<Integer, String> Sites = new HashMap<Integer, String>();
		// 添加键值对
		Sites.put(1, "Google");
		Sites.put(2, "Runoob");
		Sites.put(3, "Taobao");
		Sites.put(4, "Zhihu");
		System.out.println(Sites);

		// 创建 HashMap 对象 Sites
		HashMap<String, String> SitesStr = new HashMap<String, String>();
		// 添加键值对
		SitesStr.put("one", "Google");
		SitesStr.put("two", "Runoob");
		SitesStr.put("three", "Taobao");
		SitesStr.put("four", "Zhihu");
		System.out.println(SitesStr);

		System.out.println(Sites.get(3));

		Sites.remove(4);
		System.out.println(Sites);

		// 输出 key 和 value
		for (Integer i : Sites.keySet()) {
			System.out.println("key: " + i + " value: " + Sites.get(i));
		}
		// 返回所有 value 值
		for (String value : Sites.values()) {
			// 输出每一个value
			System.out.print(value + ", ");
		}

		Sites.clear();
		System.out.println(Sites);

		System.out.println(SitesStr.size());
	}

}
