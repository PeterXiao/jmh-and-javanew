/**
 * 
 */
package luozix.start.exams.collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author xiaoy
 *
 */
public class ImmuCollect {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		List stuff = Arrays.asList(new String[] { "a", "b" });
		List list = new ArrayList(stuff);
		list = Collections.unmodifiableList(list);
		try {
			list.set(0, "new value");
		} catch (UnsupportedOperationException e) {
		}
		Set set = new HashSet(stuff);
		set = Collections.unmodifiableSet(set);
		Map map = new HashMap();
		map = Collections.unmodifiableMap(map);
		System.out.println("集合现在是只读");

		System.out.println("TreeMap 实例！\n");
		TreeMap tMap = new TreeMap();
		tMap.put(1, "Sunday");
		tMap.put(2, "Monday");
		tMap.put(3, "Tuesday");
		tMap.put(4, "Wednesday");
		tMap.put(5, "Thursday");
		tMap.put(6, "Friday");
		tMap.put(7, "Saturday");
		System.out.println("TreeMap 键：" + tMap.keySet());
		System.out.println("TreeMap 值：" + tMap.values());
		System.out.println("键为 5 的值为: " + tMap.get(5) + "\n");
		System.out.println("第一个键: " + tMap.firstKey() + " Value: " + tMap.get(tMap.firstKey()) + "\n");
		System.out.println("最后一个键: " + tMap.lastKey() + " Value: " + tMap.get(tMap.lastKey()) + "\n");
		System.out.println("移除第一个数据: " + tMap.remove(tMap.firstKey()));
		System.out.println("现在 TreeMap 键为: " + tMap.keySet());
		System.out.println("现在 TreeMap 包含: " + tMap.values() + "\n");
		System.out.println("移除最后一个数据: " + tMap.remove(tMap.lastKey()));
		System.out.println("现在 TreeMap 键为: " + tMap.keySet());
		System.out.println("现在 TreeMap 包含: " + tMap.values());
	}

//	public static Long getLong(final Map map, final Object key) {
//	    Number answer = getNumber(map, key);
//	    if (answer == null) {
//	       return null;
//	    } else if (answer instanceof Long) {
//	       return (Long) answer;
//	    }
//	    return new Long(answer.longValue());
//	}
//	
//	Long value1 = MapUtils.getLong(map, key);
//	Integer value2 = MapUtils.getInteger(map, key);
}
