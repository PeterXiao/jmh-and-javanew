/**
 * Project Name:java11_in_action File Name:CpuHighExample.java Package Name:luozix.start.problems
 * Date:2021年3月6日下午5:29:03 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: CpuHighExample.java @Package luozix.start.problems @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月6日 下午5:29:03
 * @version V1.0
 */
package luozix.start.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:CpuHighExample <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月6日 下午5:29:03 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: CpuHighExample @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月6日 下午5:29:03
 * @version
 * @since JDK 1.8
 */
public class CpuHighExample {

  public static void cpuHigh() {
    final List<String> list = new LinkedList<>();
    Thread thread1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                int count = 1;
                while (true) {
                  // 构造thread1为消耗很高cpu的线程
                  count = count + 1;
                }
              }
            });
    thread1.setName("thread1");
    Thread thread2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                while (true) {
                  try {
                    // 构造thread2为消耗很低cpu的线程
                    Thread.sleep(1000);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                }
              }
            });
    thread2.setName("thread2");
    thread1.start();
    thread2.start();
  }
}
