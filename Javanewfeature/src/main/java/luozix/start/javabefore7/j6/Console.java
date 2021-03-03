/**
 * Project Name:java11_in_action File Name:Console.java Package Name:luozix.start.javabefore7.j6
 * Date:2021年3月3日上午10:33:21 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Console.java @Package luozix.start.javabefore7.j6 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:33:21
 * @version V1.0
 */
package luozix.start.javabefore7.j6;

/**
 * ClassName:Console <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午10:33:21 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Console @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:33:21
 * @version
 * @since JDK 1.8
 */
public class Console {

  /**
   * @Title: main @Description: TODO 用Console开发控制台程序
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午10:33:21.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    java.io.Console console = System.console();

    if (console != null) {
      String user = new String(console.readLine(" Enter User: ", new Object[0]));
      String pwd = new String(console.readPassword(" Enter Password: ", new Object[0]));
      console.printf(" User name is:%s ", new Object[] {user});
      console.printf(" Password is:%s ", new Object[] {pwd});
    } else {
      System.out.println(" No Console! ");
    }
  }
}
