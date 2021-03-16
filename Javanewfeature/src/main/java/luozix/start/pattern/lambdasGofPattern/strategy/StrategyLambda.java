/**
 * Project Name:java11_in_action File Name:StrategyLambda.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.strategy Date:2021年3月4日下午5:49:10 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: StrategyLambda.java @Package
 * luozix.start.pattern.lambdasGofPattern.strategy @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:49:10
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.strategy;
/**
 * ClassName:StrategyLambda <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:49:10 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: StrategyLambda @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:49:10
 * @version
 * @since JDK 1.8
 */
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class StrategyLambda {

  public static void publishText(
      String text, Predicate<String> filter, UnaryOperator<String> format) {
    if (filter.test(text)) {
      System.out.println(format.apply(text));
    }
  }

  public static void main(String[] args) {
    publishText("ERROR - something bad happened", s -> true, String::toUpperCase);
    publishText("DEBUG - I'm here", s -> s.length() < 20, String::toLowerCase);
  }
}
