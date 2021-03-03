/**
 * Project Name:java11_in_action File Name:Streams.java Package Name:luozix.start.java8
 * Date:2021年3月3日上午11:27:20 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Streams.java @Package luozix.start.java8 @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:27:20
 * @version V1.0
 */
package luozix.start.java8;

import java.util.Arrays;
import java.util.Collection;

/**
 * ClassName:Streams <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月3日 上午11:27:20 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Streams @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月3日 上午11:27:20
 * @version
 * @since JDK 1.8
 */
public class Streams {
  private enum Status {
    OPEN,
    CLOSED
  }

  private static final class Task {
    private final Status status;
    private final Integer points;

    Task(final Status status, final Integer points) {
      this.status = status;
      this.points = points;
    }

    public Integer getPoints() {
      return points;
    }

    public Status getStatus() {
      return status;
    }

    @Override
    public String toString() {
      return String.format("[%s, %d]", status, points);
    }
  }
  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年3月3日 上午11:27:20.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    final Collection<Task> tasks =
        Arrays.asList(
            new Task(Status.OPEN, 5), new Task(Status.OPEN, 13), new Task(Status.CLOSED, 8));

    // Calculate total points of all active tasks using sum()
    final long totalPointsOfOpenTasks =
        tasks
            .stream()
            .filter(task -> task.getStatus() == Status.OPEN)
            .mapToInt(Task::getPoints)
            .sum();

    System.out.println("Total points: " + totalPointsOfOpenTasks);
  }
}
