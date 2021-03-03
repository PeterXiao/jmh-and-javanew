/**
 * Project Name:java11_in_action File Name:AutoBoxing.java Package Name:luozix.start.javabefore7.j5
 * Date:2021年3月3日上午10:19:19 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: AutoBoxing.java @Package luozix.start.javabefore7.j5 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:19:19
 * @version V1.0
 */
package luozix.start.javabefore7.j5;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
/**
 * ClassName:AutoBoxing <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午10:19:19 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: AutoBoxing @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:19:19
 * @version
 * @since JDK 1.8
 */
public class AutoBoxing {

  /**
   * @Title: main @Description: 自动装箱、拆箱
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午10:19:19.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int a = new Integer(66);
    Integer b = 18;

    Boolean flag = true;
    boolean isBug = false;

    int[] arr = {1, 4, 5, 7};

    // for each
    for (int i : arr) {
      System.out.println(i);
    }

    List<String> names = Arrays.asList("nice", "hell", "A*熊x");
    for (String name : names) {
      System.out.println(name);
    }
    // 静态导入
    out.println("Hi let learn java 8.");
  }
  // 变长参数  VarArgs
  public static List<String> asList(String[] names) {
    return Arrays.asList(names);
  }
}
// 枚举
enum EnumDemo {
  RED,
  GREEN,
  YELLOW
}
