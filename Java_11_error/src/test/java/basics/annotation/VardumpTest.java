package basics.annotation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Obj {
    public int mi = 123;
    public String ms = "abc";
}

class Bean {
    private int i;
    private String[] strs;
    private Obj obj;

    public void setI(int i) {
	this.i = i;
    }

    public void setStrs(String[] strs) {
	this.strs = strs;
    }

    public void setObj(Obj obj) {
	this.obj = obj;
    }

    public int getI() {
	return i;
    }

    public String[] getStrs() {
	return strs;
    }

    public Obj getObj() {
	return obj;
    }
}
class VardumpTest {

    @org.junit.jupiter.api.Test
    public void t1() {
	Object[] objects = { 1, '2', "3", true, null };
	String[][] strings = { { "aaa", "bbb", "aaa", "bbb" }, { "aaa", "bbb", "aaa", "bbb" } };
	HashMap<Object, Object> map = new HashMap<Object, Object>();
	map.put("aaa", 1);
	map.put("bbb", 1.5f);
	map.put("ccc", true);
	map.put(5.5f, '5');
	map.put(1, "12345");
	map.put(true, objects);
	map.put('g', strings);
	List<Object> list = new ArrayList<Object>();
	list.add("abc");
	list.add('a');
	list.add(true);
	list.add(map);
	list.add(null);
	Bean bean = new Bean();
	bean.setI(12345);
	bean.setObj(new Obj());
	bean.setStrs(new String[] { "11111", "fffffffff", "fdddddddd" });
	list.add(bean);
	Vardump.print(list);
    }

}
