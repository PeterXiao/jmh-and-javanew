/**
 * Project Name:java11_in_action File Name:StreamParallelArrays.java Package Name:luozix.start.java8
 * Date:2021年3月3日上午11:28:28 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: StreamParallelArrays.java @Package luozix.start.java8 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:28:28
 * @version V1.0
 */
package luozix.start.java8;
/**
 * ClassName:StreamParallelArrays <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午11:28:28 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @ClassName: StreamParallelArrays @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:28:28
 * @version
 * @since JDK 1.8
 */
public class StreamParallelArrays {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午11:28:28.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // 并行数组
    long[] arrayOfLong = new long[20000];

    Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
    Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
    System.out.println();

    Arrays.parallelSort(arrayOfLong);
    Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
    System.out.println();
  }
}
