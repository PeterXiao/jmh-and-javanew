/**
 * Project Name:java11_in_action File Name:LargeMap.java Package Name:luozix.start.perf
 * Date:2021年3月3日下午6:03:35 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: LargeMap.java @Package luozix.start.perf @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 下午6:03:35
 * @version V1.0
 */
package luozix.start.perf;
/**
 * ClassName:LargeMap <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 下午6:03:35 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName: LargeMap @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 下午6:03:35
 * @version
 * @since JDK 1.8
 */
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

public class LargeMap {

  public static final int NumRecords = 60000000;
  private static Int2IntOpenHashMap intOpenHashMap = new Int2IntOpenHashMap(NumRecords, 0.5f);
  private static Object2IntMap<String> string2IntMap = new Object2IntOpenHashMap<String>(1000000);

  static {
    intOpenHashMap.defaultReturnValue(-1);
    string2IntMap.defaultReturnValue(-1);
  }

  public static void add(String key, int value) {

    int hash = key.hashCode();
    int found = intOpenHashMap.get(hash);
    if (found == -1) {
      intOpenHashMap.put(hash, value);
    } else {
      string2IntMap.put(key, value);
    }
  }

  public static int get(String key) {
    if (string2IntMap.containsKey(key)) {
      return string2IntMap.get(key);
    } else {
      return intOpenHashMap.get(key.hashCode());
    }
  }

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<String, Integer>(20);
    final Random random = new Random();
    Runtime runtime = Runtime.getRuntime();
    int k = 1;
    System.gc();
    long time = System.nanoTime();
    long freeMemory = Runtime.getRuntime().freeMemory();
    long totalMemory = Runtime.getRuntime().totalMemory();
    long t1 = System.nanoTime();
    for (int i = 0; i < NumRecords; i++) {
      k = random.nextInt();
      String key = new BigInteger(130, random).toString(50);
      int value = random.nextInt();

      if (i % 1000000 == 0) {
        long l = System.nanoTime();
        System.out.println("the counter is " + i + " ," + (l - time));
        time = l;
      }
      LargeMap.add(key, value);
    }
    long t2 = System.nanoTime();
    long freeMemory1 = Runtime.getRuntime().freeMemory();
    System.gc();
    System.out.println("time taken to add is : " + (t2 - t1));
    System.out.println("initial Free Memory :" + freeMemory);
    System.out.println("final Free Memory :" + freeMemory1);
    System.out.println("total Memory :" + totalMemory);
  }
}
