/**
 * Project Name:java11_in_action File Name:SwitchString.java Package
 * Name:luozix.start.javabefore7.j7 Date:2021年3月3日上午10:44:41 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: SwitchString.java @Package luozix.start.javabefore7.j7 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:44:41
 * @version V1.0
 */
package luozix.start.javabefore7.j7;
/**
 * ClassName:SwitchString <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午10:44:41 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: SwitchString @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:44:41
 * @version
 * @since JDK 1.8
 */
public class SwitchString {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午10:44:41.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // switch对String的支持
    String bis = "java";
    switch (bis) {
      case "java":
        break;
      case "python":
        break;
      case "ruby":
        break;
      default:
        break;
    }

    EnumDemo enumDemo = EnumDemo.GREEN;

    switch (enumDemo) {
      case RED:
        break;
      case YELLOW:
        break;
      default:
        break;
    }
    // 数字下划线支持
    int num = 1234_5678_9;
    float num2 = 222_33F;
    long num3 = 123_000_111L;
    long tenSenconds = 10_000L;
  }
}
// 枚举
enum EnumDemo {
  RED,
  GREEN,
  YELLOW
}
