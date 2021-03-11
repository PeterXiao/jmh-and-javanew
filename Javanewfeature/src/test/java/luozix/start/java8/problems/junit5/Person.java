/**
 * Project Name:java11_in_action File Name:Person.java Package
 * Name:luozix.start.java8.problems.junit5 Date:2021年3月11日下午5:04:35 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Person.java @Package luozix.start.java8.problems.junit5 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月11日 下午5:04:35
 * @version V1.0
 */
package luozix.start.java8.problems.junit5;
/**
 * ClassName:Person <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月11日 下午5:04:35 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Person @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月11日 下午5:04:35
 * @version
 * @since JDK 1.8
 */
public class Person {
  private final String name;
  private final int age;

  /**
   * Creates a person with the specified name and age.
   *
   * @param name the name
   * @param age the age
   * @throws IllegalArgumentException if the age is not greater than zero
   */
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    if (age <= 0) {
      throw new IllegalArgumentException("Invalid age:" + age);
    }
  }
}
