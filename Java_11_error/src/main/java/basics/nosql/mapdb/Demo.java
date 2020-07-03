/**
 *
 */
package basics.nosql.mapdb;

/**
 * @author Office
 *
 */
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import java.util.Map;

/**
 *
 * 从内存中读取数据，测试是否成功
 */
public class Demo {
    public static void main(String[] args) {
	DB db = DBMaker.heapDB().make();
	HTreeMap map = db.hashMap("name").create();
	for (int i = 0; i < 10000; i++) {
	    map.put(i, "aa");
	}
	db.close();
	read();
    }

    private static void read() {
	DB db = DBMaker.heapDB().make();
	HTreeMap name = db.hashMap("name").open();
	System.out.println(name.get(1));
	db.close();
    }
}