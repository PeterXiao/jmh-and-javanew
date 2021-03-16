/**
 * Project Name:java11_in_action File Name:CommandLambda.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.command Date:2021年3月4日下午5:43:11 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: CommandLambda.java @Package luozix.start.pattern.lambdasGofPattern.command @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:43:11
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:CommandLambda <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午5:43:11 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: CommandLambda @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午5:43:11
 * @version
 * @since JDK 1.8
 */
public class CommandLambda {
  public static void log(String message) {
    System.out.println("Logging: " + message);
  }

  public static void save(String message) {
    System.out.println("Saving: " + message);
  }

  public static void send(String message) {
    System.out.println("Sending: " + message);
  }

  public static void execute(List<Runnable> tasks) {
    tasks.forEach(Runnable::run);
  }

  public static void main(String[] args) {
    List<Runnable> tasks = new ArrayList<>();
    tasks.add(() -> log("Hi"));
    tasks.add(() -> save("Cheers"));
    tasks.add(() -> send("Bye"));

    execute(tasks);
  }
}
