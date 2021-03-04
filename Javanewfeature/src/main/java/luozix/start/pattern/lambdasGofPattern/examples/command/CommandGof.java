/**
 * Project Name:java11_in_action File Name:CommandGof.java Package
 * Name:luozix.start.pattern.lambdasGofPattern.examples.command Date:2021年3月4日下午6:01:22 Copyright
 * (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: CommandGof.java @Package
 * luozix.start.pattern.lambdasGofPattern.examples.command @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:01:22
 * @version V1.0
 */
package luozix.start.pattern.lambdasGofPattern.examples.command;
/**
 * ClassName:CommandGof <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月4日 下午6:01:22 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: CommandGof @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月4日 下午6:01:22
 * @version
 * @since JDK 1.8
 */
import java.util.ArrayList;
import java.util.List;

public class CommandGof {
  interface Command {
    void run();
  }

  public static class Logger implements Command {
    public final String message;

    public Logger(String message) {
      this.message = message;
    }

    @Override
    public void run() {
      System.out.println("Logging: " + message);
    }
  }

  public static class FileSaver implements Command {
    public final String message;

    public FileSaver(String message) {
      this.message = message;
    }

    @Override
    public void run() {
      System.out.println("Saving: " + message);
    }
  }

  public static class Mailer implements Command {
    public final String message;

    public Mailer(String message) {
      this.message = message;
    }

    @Override
    public void run() {
      System.out.println("Sending: " + message);
    }
  }

  public static class Executor {
    public void execute(List<Command> tasks) {
      for (Command task : tasks) {
        task.run();
      }
    }
  }

  public static void main(String[] args) {
    List<Command> tasks = new ArrayList<>();
    tasks.add(new Logger("Hi"));
    tasks.add(new FileSaver("Cheers"));
    tasks.add(new Mailer("Bye"));

    new Executor().execute(tasks);
  }
}
