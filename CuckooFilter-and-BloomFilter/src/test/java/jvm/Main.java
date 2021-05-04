/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:Main.java Package Name:jvm
 * Date:2021年5月4日上午9:23:45 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Main.java @Package jvm @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年5月4日 上午9:23:45
 * @version V1.0
 */
package jvm;
/**
 * ClassName:Main <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年5月4日 上午9:23:45 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Main @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年5月4日 上午9:23:45
 * @version
 * @since JDK 1.8
 */
import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    // Generate data
    int arraySize = 32768;
    int data[] = new int[arraySize];

    Random rnd = new Random(0);
    for (int c = 0; c < arraySize; ++c) data[c] = rnd.nextInt() % 256;

    // !!! With this, the next loop runs faster
    Arrays.sort(data);

    // Test
    long start = System.nanoTime();
    long sum = 0;
    for (int i = 0; i < 100000; ++i) {
      for (int c = 0; c < arraySize; ++c) { // Primary loop
        if (data[c] >= 128) sum += data[c];
      }
    }

    System.out.println((System.nanoTime() - start) / 1000000000.0);
    System.out.println("sum = " + sum);

    //    StringUtils.repeat(null, 2) = null;
    //    StringUtils.repeat("", 0) = "";
    //    StringUtils.repeat("", 2) = "";
    //    StringUtils.repeat("a", 3) = "aaa";
    //    StringUtils.repeat("ab", 2) = "abab";
    //    StringUtils.repeat("a", -2) = "";
    System.out.println("ABC".isBlank()); // false

    System.out.println(" ABC ".isBlank()); // false

    System.out.println("  ".isBlank()); // true

    System.out.println("".isBlank()); // true
  }
}
