/**
 * Project Name:java11_in_action File Name:DecoratorLambda.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.examples.decorator Date:2021年3月4日下午6:03:35 Copyright
 * (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: DecoratorLambda.java @Package
 * luozix.start.pattern.lambdasGofPattern.examples.decorator @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:03:35
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.examples.decorator;
/**
 * ClassName:DecoratorLambda <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:03:35 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: DecoratorLambda @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:03:35
 * @version
 * @since JDK 1.8
 */
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

public class DecoratorLambda {

  public static class DefaultSalaryCalculator implements DoubleUnaryOperator {
    @Override
    public double applyAsDouble(double grossAnnual) {
      return grossAnnual / 12;
    }
  }

  public static void main(String[] args) {
    new DefaultSalaryCalculator()
        .andThen(Taxes::generalTax)
        .andThen(Taxes::regionalTax)
        .andThen(Taxes::healthInsurance)
        .applyAsDouble(80000.00);

    calculateSalary(
        80000.00,
        new DefaultSalaryCalculator(),
        Taxes::generalTax,
        Taxes::regionalTax,
        Taxes::healthInsurance);
  }

  public static double calculateSalary(double annualGross, DoubleUnaryOperator... taxes) {
    return Stream.of(taxes)
        .reduce(DoubleUnaryOperator.identity(), DoubleUnaryOperator::andThen)
        .applyAsDouble(annualGross);
  }
}
