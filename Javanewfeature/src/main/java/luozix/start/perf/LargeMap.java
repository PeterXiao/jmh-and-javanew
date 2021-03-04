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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
/**
 * @ClassName: LargeMap @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 下午6:03:35
 * @version
 * @since JDK 1.8
 */
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.ints.IntSets;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
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
  
  /**
   * Demonstrate standard JDK {@code ArrayList<Double>}
   * with some JDK 8 functionality.
   */  
  public void demonstrateJdkArrayListForDoubles()  
  {  
     final ArrayList<Double> doubles = new ArrayList<>();  
     doubles.add(15.5);  
     doubles.add(24.4);  
     doubles.add(36.3);  
     doubles.add(67.6);  
     doubles.add(10.0);  
     System.out.println("JDK ArrayList<Double>:");  
     System.out.println("\tDoubles List:" + doubles);  
  }  

  /**
   * Demonstrate use of DoubleArrayList and show how
   * similar using it is to using {@code ArrayList<Double>}.
   */  
  public void demonstrateFastUtilArrayListForDoubles()  
  {  
     // Demonstrate adding elements to DoubleArrayList is  
     // exactly like adding elements to ArrayList<Double>.  
     final DoubleArrayList doubles = new DoubleArrayList();  
     doubles.add(15.5);  
     doubles.add(24.4);  
     doubles.add(36.3);  
     doubles.add(67.6);  
     doubles.add(10.0);  
     System.out.println("FastUtil DoubleArrayList:");  // DoubleArrayList overrides toString()  
     System.out.println("\tDoubles List:" + doubles);  
  }
  /**
   * Demonstrate FastUtil's Double Stack.
   *
   * FastUtil's DoubleStack allows access to its
   * contents via push, pop, and peek. It is declared
   * as a DoubleArrayList type here so that the size()
   * method is available without casting.
   */  
  public void demonstrateFastUtilDoubleStack()  
  {  
     final DoubleArrayList stack = new DoubleArrayList();  
     stack.push(15.5);  
     stack.push(17.3);  
     stack.push(16.6);  
     stack.push(2.2);  
     System.out.println("FastUtil Stack of Doubles");  
     System.out.println("\tPeek:" + stack.peek(0) +"; After Size:" + stack.size());  
     System.out.println("\tPop: " + stack.pop() +"; After Size:" + stack.size());  
     System.out.println("\tPeek:" + stack.peek(0) +"; After Size:" + stack.size());  
  }
  /**
   * Demonstrate one of FastUtil's"equivalent"s of the
   * java.util.Collections class. FastUtil separates its
   * grouping of static methods into classes that are
   * specific to the data type of the collection and to
   * the data structure type of the collection.
   */  
  public void demonstrateFastUtilCollectionsClass()  
  {  
     final IntLinkedOpenHashSet integers = new IntLinkedOpenHashSet();  
     integers.add(5);  
     integers.add(7);  
     integers.add(3);  
     integers.add(1);  
     final IntSet unmodifiableIntegers = IntSets.unmodifiable(integers);  
     System.out.println("Unmodifiable Integers:");  
     System.out.println("\tClass:" + unmodifiableIntegers.getClass().getCanonicalName());  
     try  
     {  
        unmodifiableIntegers.add(15);  
     }  
     catch (Exception ex)  
     {  
         System.out.println("\tException caught:" + ex);  
     }  
  }
  /**
   * Demonstrate"traditional" Java iteration of a
   * FastUtil collection.
   */  
  public void demonstrateIterationWithIterator()  
  {  
     final LongOpenHashSet longs = new LongOpenHashSet();  
     longs.add(15);  
     longs.add(6);  
     longs.add(12);  
     longs.add(13);  
     longs.add(2);  
     final LongIterator longIterator = longs.iterator();  
     while (longIterator.hasNext())  
     {  
        final long longValue = longIterator.next();  
        System.out.print(longValue +"");  
     }  
  }  

  /**
   * Demonstrate iteration of a FastUtil collection
   * using Java's enhanced for-each approach.
   */  
  public void demonstrateIterationWithForEach()  
  {  
     final LongLinkedOpenHashSet longs = new LongLinkedOpenHashSet();  
     longs.add(15);  
     longs.add(6);  
     longs.add(12);  
     longs.add(13);  
     longs.add(2);  
     for (final long longValue : longs)  
     {  
         System.out.println(longValue +"");  
     }  
  }  

  /**
   * Demonstrate iteration of a FastUtil collection
   * using JDK 8 .forEach approach.
   */  
  public void demonstrateIterationWithJdk8ForEach()  
  {  
     final LongLinkedOpenHashSet longs = new LongLinkedOpenHashSet();  
     longs.add(15);  
     longs.add(6);  
     longs.add(12);  
     longs.add(13);  
     longs.add(2);  
     longs.forEach(longValue -> System.out.print(longValue +""));  
  } 
  
}
