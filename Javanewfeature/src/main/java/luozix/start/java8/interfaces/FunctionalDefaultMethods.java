/**
 * Project Name:java11_in_action File Name:FunctionalDefaultMethods.java Package
 * Name:luozix.start.java8.interfaces Date:2021年3月3日上午11:32:02 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: FunctionalDefaultMethods.java @Package luozix.start.java8.interfaces @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:32:02
 * @version V1.0
 */
package luozix.start.java8.interfaces;
/**
 * ClassName:FunctionalDefaultMethods <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午11:32:02 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: FunctionalDefaultMethods @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:32:02
 * @version
 * @since JDK 1.8
 */
// functional interface 也可以有默认方法
@FunctionalInterface
public interface FunctionalDefaultMethods {

  void method();

  default void defaultMethod() {}
}
