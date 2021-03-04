/**
 * Project Name:java11_in_action File Name:Sample.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.venkat.iterator Date:2021年3月4日下午6:16:13 Copyright (c)
 * 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Sample.java @Package luozix.start.pattern.lambdasGofPattern.venkat.iterator @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:16:13
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.venkat.iterator;
/**
 * ClassName:Sample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:16:13 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.util.stream.IntStream;

public class Sample {
  public static int factorial(int number) {
    int product = 1;
    for (int i = 1; i <= number; i++) {
      product *= i;
    }
    return product;
  }

  public static int factorialFunctional(int number) {
    return IntStream.rangeClosed(1, number).reduce(1, (product, index) -> product * index);
  }

  public static void main(String[] args) {
    System.out.println(factorial(5));
    System.out.println(factorialFunctional(5));
  }
}
