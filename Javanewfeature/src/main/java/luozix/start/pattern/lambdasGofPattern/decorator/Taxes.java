/**
 * Project Name:java11_in_action File Name:Taxes.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.decorator Date:2021年3月4日下午5:44:23 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Taxes.java @Package luozix.start.pattern.lambdasGofPattern.decorator @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:44:23
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.decorator;
/**
 * ClassName:Taxes <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:44:23 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Taxes @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:44:23
 * @version
 * @since JDK 1.8
 */
public class Taxes {
  public static double generalTax(double salary) {
    return salary * 0.8;
  }

  public static double regionalTax(double salary) {
    return salary * 0.95;
  }

  public static double healthInsurance(double salary) {
    return salary - 200.0;
  }
}
