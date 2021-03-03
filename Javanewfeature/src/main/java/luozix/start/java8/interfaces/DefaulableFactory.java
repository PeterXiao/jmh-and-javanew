/**
 * Project Name:java11_in_action File Name:DefaulableFactory.java Package
 * Name:luozix.start.java8.interfaces Date:2021年3月3日上午11:30:56 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: DefaulableFactory.java @Package luozix.start.java8.interfaces @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:30:56
 * @version V1.0
 */
package luozix.start.java8.interfaces;
/**
 * ClassName:DefaulableFactory <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午11:30:56 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: DefaulableFactory @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:30:56
 * @version
 * @since JDK 1.8
 */
import java.util.function.Supplier;

public interface DefaulableFactory {
  // Interfaces now allow static methods
  static Integer create(Supplier<Integer> supplier) {
    return supplier.get();
  }
}
