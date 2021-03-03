/**
 * Project Name:java11_in_action File Name:ScriptEngineDemo.java Package
 * Name:luozix.start.javabefore7.j6 Date:2021年3月3日上午10:28:08 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: ScriptEngineDemo.java @Package luozix.start.javabefore7.j6 @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:28:08
 * @version V1.0
 */
package luozix.start.javabefore7.j6;

import java.io.FileReader;

/**
 * ClassName:ScriptEngineDemo <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午10:28:08 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
/**
 * @ClassName: ScriptEngineDemo @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午10:28:08
 * @version
 * @since JDK 1.8
 */
public class ScriptEngineDemo {

  /**
   * @Title: main @Description: TODO对脚本语言的支持
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午10:28:08.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("ECMAScript");
    try {
      String jsPath = ScriptEngineDemo.class.getResource("/test.js").getPath();

      engine.eval(new FileReader(jsPath));

      Invocable invokableEngine = (Invocable) engine;

      Object ret = invokableEngine.invokeFunction("test", null);

      System.out.println("The result is : " + ret);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
