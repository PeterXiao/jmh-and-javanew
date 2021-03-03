/**
 * Project Name:java11_in_action File Name:TryWithResource.java Package
 * Name:luozix.start.javabefore7.j7 Date:2021年3月3日上午10:43:16 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: TryWithResource.java @Package luozix.start.javabefore7.j7 @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:43:16
 * @version V1.0
 */
package luozix.start.javabefore7.j7;
/**
 * ClassName:TryWithResource <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午10:43:16 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import luozix.start.javabefore7.j6.ScriptEngineDemo;
/**
 * @ClassName: TryWithResource try-with-resource @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:43:16
 * @version
 * @since JDK 1.8
 */
public class TryWithResource {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午10:43:16.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String path = ScriptEngineDemo.class.getResource("/test.js").getPath();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String str = br.readLine();
      while (null != str) {
        System.out.println(str);
        str = br.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 捕获多异常
    try {
      BufferedReader reader = new BufferedReader(new FileReader(""));
      Connection con = null;
      Statement stmt = con.createStatement();
    } catch (IOException | SQLException e) {
      // 捕获多个异常，e就是final类型的
      e.printStackTrace();
    }
  }
}
