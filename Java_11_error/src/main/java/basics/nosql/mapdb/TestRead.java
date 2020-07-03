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
import org.mapdb.Serializer;

import java.io.Writer;
import java.util.Scanner;

/**
 *
 * mapdb读写性能测试
 */
public class TestRead {

    static DB db = DBMaker.memoryDB().make();

    private static void write(String args) {
	HTreeMap map = db.hashMap("name").create();

	final long startFree = Runtime.getRuntime().freeMemory();
	final long startTotal = Runtime.getRuntime().totalMemory();
	final long start = System.currentTimeMillis();

	for (int i = 0; i < Integer.parseInt(args); i++) {
	    map.put(i, "aa");
	}
	final long endFree = Runtime.getRuntime().freeMemory();
	final long endTotal = Runtime.getRuntime().totalMemory();
	System.out.println("mapdb写用时：" + (System.currentTimeMillis() - start) + "ms");
	System.out.println("消耗内存：" + (endFree - startFree) / 1024);

    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.println("输入数测试数据量：");
	String count = "10000000"; // sc.nextLine(); // 读取字符串型输入
	System.out.println(count);
	System.out.println("SUCCESSED");

	write(count);
	final HTreeMap map = db.hashMap("name").open();
	// 剩余内存空间
	final long startFree = Runtime.getRuntime().freeMemory();
	// jvm可支配的最大内存
	final long startTotal = Runtime.getRuntime().totalMemory();

	final long start = System.currentTimeMillis();
	for (Object o : map.keySet()) {
	    map.get(o);
	}
	db.close();
	final long endFree = Runtime.getRuntime().freeMemory();
	final long endTotal = Runtime.getRuntime().totalMemory();
	System.out.println("mapdb读用时：" + (System.currentTimeMillis() - start) + "ms");
	System.out.println("消耗内存：" + (endFree - startFree) / 1024 / 1024);
	System.out.println("总核数：" + Runtime.getRuntime().availableProcessors());

    }

}

