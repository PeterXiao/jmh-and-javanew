/**
 * Project Name:java11_in_action File Name:DecoratorGof.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.decorator Date:2021年3月4日下午5:44:44 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: DecoratorGof.java @Package luozix.start.pattern.lambdasGofPattern.decorator @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:44:44
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.decorator;
/**
 * ClassName:DecoratorGof <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:44:44 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: DecoratorGof @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:44:44
 * @version
 * @since JDK 1.8
 */
public class DecoratorGof {

  interface SalaryCalculator {
    double calculate(double grossAnnual);
  }

  public static class DefaultSalaryCalculator implements SalaryCalculator {

    @Override
    public double calculate(double grossAnnual) {
      return grossAnnual / 12;
    }
  }

  public abstract static class AbstractTaxDecorator implements SalaryCalculator {
    private final SalaryCalculator salaryCalculator;

    public AbstractTaxDecorator(SalaryCalculator salaryCalculator) {
      this.salaryCalculator = salaryCalculator;
    }

    protected abstract double applyTax(double salary);

    @Override
    public final double calculate(double grossAnnual) {
      double salary = salaryCalculator.calculate(grossAnnual);
      return applyTax(salary);
    }
  }

  public static class GeneralTaxDecorator extends AbstractTaxDecorator {
    public GeneralTaxDecorator(SalaryCalculator salaryCalculator) {
      super(salaryCalculator);
    }

    @Override
    protected double applyTax(double salary) {
      return Taxes.generalTax(salary);
    }
  }

  public static class RegionalTaxDecorator extends AbstractTaxDecorator {
    public RegionalTaxDecorator(SalaryCalculator salaryCalculator) {
      super(salaryCalculator);
    }

    @Override
    protected double applyTax(double salary) {
      return Taxes.regionalTax(salary);
    }
  }

  public static class HealthInsuranceDecorator extends AbstractTaxDecorator {
    public HealthInsuranceDecorator(SalaryCalculator salaryCalculator) {
      super(salaryCalculator);
    }

    @Override
    protected double applyTax(double salary) {
      return Taxes.healthInsurance(salary);
    }
  }

  public static void main(String[] args) {
    System.out.println(
        new HealthInsuranceDecorator(
                new RegionalTaxDecorator(new GeneralTaxDecorator(new DefaultSalaryCalculator())))
            .calculate(30000.00));
  }
}
