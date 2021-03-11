/**
 * Project Name:java11_in_action File Name:PersonTest.java Package
 * Name:luozix.start.java8.problems.junit5 Date:2021年3月11日下午5:05:32 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: PersonTest.java @Package luozix.start.java8.problems.junit5 @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月11日 下午5:05:32
 * @version V1.0
 */
package luozix.start.java8.problems.junit5;
/**
 * ClassName:PersonTest <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月11日 下午5:05:32 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: PersonTest @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月11日 下午5:05:32
 * @version
 * @since JDK 1.8
 */
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  void testExpectedException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          new Person("Joe", -1);
        });
  }

  @Test
  void testExpectedExceptionMessage() {
    final Exception e =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              new Person("Joe", -1);
            });
    assertThat(e.getMessage(), containsString("Invalid age"));
  }
}
