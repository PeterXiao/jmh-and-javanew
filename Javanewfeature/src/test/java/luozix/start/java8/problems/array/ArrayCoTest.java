/**
 * Project Name:java11_in_action File Name:ArrayCoTest.java Package
 * Name:luozix.start.java8.problems.array Date:2021年3月12日下午2:29:25 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ArrayCoTest.java @Package luozix.start.java8.problems.array @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月12日 下午2:29:25
 * @version V1.0
 */
package luozix.start.java8.problems.array;

import java.util.Arrays;

/**
 * ClassName:ArrayCoTest <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月12日 下午2:29:25 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: ArrayCoTest @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月12日 下午2:29:25
 * @version
 * @since JDK 1.8
 */
public class ArrayCoTest {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月12日 下午2:29:25.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    String[] array = {"a", "b", "c", "b", "d"};
    System.out.println("array.length:" + array.length);
    String[] arrayCopy = new String[10];
    System.out.println("arrayCopy.length:" + arrayCopy.length);
    System.arraycopy(array, 1, arrayCopy, 1, 4);
    System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(arrayCopy));
    array[2] = "cc";
    System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(arrayCopy));

    String[] arraycopy = {"a", "b", "c", "b", "d"};
    System.out.println("array.length:" + arraycopy.length);
    String[] arrayCopyed = Arrays.copyOf(arraycopy, 10);
    System.out.println("arrayCopyed.length:" + arrayCopyed.length);
    System.out.println(Arrays.toString(arraycopy));
    System.out.println(Arrays.toString(arrayCopyed));
    arraycopy[2] = "cc";
    System.out.println(Arrays.toString(arraycopy));
    System.out.println(Arrays.toString(arrayCopyed));
  }
}
