package basics.cache;

import java.util.*;

public class TestClass {
    public static Map<String, Object> ListToMap(List<Map<String, Object>> list, String key) {
	Map<String, Object> map = new HashMap<>();
	for (Map<String, Object> m : list) {
	    String id = m.get(key) + "";
	    if (!map.containsKey(id)) {
		map.put(id, new ArrayList<Map<String, Object>>());
	    }
	    List<Map<String, Object>> temp = (List<Map<String, Object>>) map.get(id);
	    temp.add(m);
	}
	return map;
    }

    public static void main(String[] args) {
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        List< Map<String,Object>> testData1 = new ArrayList<>();
        List< Map<String,Object>> testData2 = new ArrayList<>();
        map1.put("id","001");
        map1.put("name","小明");
        map2.put("id","002");
        map2.put("name","小李");
        testData1 = testData(100);
        testData1.add(map1);
        testData1.add(map2);
        testData2 = testData(10000);
        //下面我们找出testData1中id=001和002在testData2中的年龄
        //
        long begin1 = Calendar.getInstance().getTimeInMillis();
        for(Map<String,Object> m1: testData1){
            for (Map<String,Object> m2: testData2){
                if(m1.get("id").equals(m2.get("id"))){
                   m1.put("age",m2.get("age"));
                }
            }
        }
        long end1 =Calendar.getInstance().getTimeInMillis();
        System.out.println("第一种方法的执行时间"+(end1-begin1) );
        //第二种方法先把testData2转map
        long begin2 =Calendar.getInstance().getTimeInMillis();
        Map  mm = ListToMap(testData2,"id");
        for(Map<String,Object> m1: testData1){
            m1.put("age",((List< Map<String,Object>>)mm.get(m1.get("id"))).get(0).get("age"));
        }
        long end2 =Calendar.getInstance().getTimeInMillis();
        System.out.println("第二种方法的执行时间"+(end2-begin2) );
    }

    public static List<Map<String, Object>> testData(int k) {
	List<Map<String, Object>> list = new ArrayList<>();
	for (int i = 0; i < k; i++) {
	    Map<String, Object> m = new HashMap<>();
	    m.put("id", i + "");
	    m.put("age", i);
	    list.add(m);
	}
	Map<String, Object> map5 = new HashMap<>();
	Map<String, Object> map6 = new HashMap<>();
	map5.put("id", "001");
	map5.put("age", 26);
	map6.put("id", "002");
	map6.put("age", 27);
	list.add(map5);
	list.add(map6);
	return list;
    }
}