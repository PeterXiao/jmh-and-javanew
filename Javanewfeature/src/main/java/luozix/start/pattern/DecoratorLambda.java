/**  
* @Title: DecoratorLambda.java
* @Package luozix.start.pattern
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:07:53
* @version V1.0  
*/
package luozix.start.pattern;
/**
* @ClassName: DecoratorLambda
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:07:53
*
*/

import java.util.function.DoubleUnaryOperator;

public class DecoratorLambda {

	public static class DefaultSalaryCalculator implements DoubleUnaryOperator {

		@Override
		public double applyAsDouble(double grossAnnual) {
			return grossAnnual / 12;
		}

	}

	public static class Taxes {
		public static double countryTaxes(double ammount) {
			return ammount * 0.5;
		}

		public static double healthTaxes(double ammount) {
			return ammount - 100;
		}

		public static double pensionTaxes(double ammount) {
			return ammount - 160;
		}

	}

	public static void main(String[] args) {
		double calc = new DefaultSalaryCalculator().andThen(Taxes::countryTaxes).andThen(Taxes::healthTaxes)
				.andThen(Taxes::pensionTaxes).applyAsDouble(55000.00);

		System.out.println(calc);

	}

}
