/**
 * Project Name:java11_in_action File Name:Sample.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.venkat.lightweight_strategy Date:2021年3月4日下午6:16:49
 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Sample.java @Package
 * luozix.start.pattern.lambdasGofPattern.venkat.lightweight_strategy @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:16:49
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.venkat.lightweight_strategy;
/**
 * ClassName:Sample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:16:49 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Sample @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:16:49
 * @version
 * @since JDK 1.8
 */
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Sample {
  //  public static int totalValues(List<Integer> numbers) {
  //    int total = 0;
  //
  //    for(int number : numbers) {
  //      total += number;
  //    }
  //
  //    return total;
  //  }
  //
  //  public static int totalEvenValues(List<Integer> numbers) {
  //    int total = 0;
  //
  //    for(int number : numbers) {
  //      if(number % 2 == 0) total += number;
  //    }
  //
  //    return total;
  //  }
  //
  //  public static int totalOddValues(List<Integer> numbers) {
  //    int total = 0;
  //
  //    for(int number : numbers) {
  //      if(number % 2 != 0) total += number;
  //    }
  //
  //    return total;
  //  }
  //
  //  public static void main(String[] args) {
  //    List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
  //
  //    System.out.println(totalValues(values));
  //    System.out.println(totalEvenValues(values));
  //    System.out.println(totalOddValues(values));
  //  }

  public static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
    return numbers.stream().filter(selector).mapToInt(value -> value).sum();
  }

  public static void main(String[] args) {
    List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

    System.out.println(totalValues(values, value -> true));
    System.out.println(totalValues(values, value -> value % 2 == 0));
    System.out.println(totalValues(values, value -> value % 2 != 0));
  }
}
