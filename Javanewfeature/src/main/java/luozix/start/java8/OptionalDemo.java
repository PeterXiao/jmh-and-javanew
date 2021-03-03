/**
 * Project Name:java11_in_action File Name:OptionalDemo.java Package Name:luozix.start.java8
 * Date:2021年3月3日上午11:29:44 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: OptionalDemo.java @Package luozix.start.java8 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:29:44
 * @version V1.0
 */
package luozix.start.java8;

import java.util.Optional;

/**
 * ClassName:OptionalDemo <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午11:29:44 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: OptionalDemo @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:29:44
 * @version
 * @since JDK 1.8
 */
public class OptionalDemo {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午11:29:44.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // Optional
    Optional<String> fullName = Optional.ofNullable(null);
    System.out.println("Full Name is set? " + fullName.isPresent());
    System.out.println("Full Name: " + fullName.orElse("[none]"));
    System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));

    Optional<String> firstName = Optional.of("Tom");
    System.out.println("First Name is set? " + firstName.isPresent());
    System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
    System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
    System.out.println();
  }
}
