/**
 * Project Name:java11_in_action File Name:DefaultThreadFactory.java Package
 * Name:luozix.start.reactive.async Date:2021年3月2日下午5:51:33 Copyright (c) 2021,
 * xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: DefaultThreadFactory.java @Package luozix.start.reactive.async @Description:
 * TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午5:51:33
 * @version V1.0
 */
package luozix.start.reactive.non;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:DefaultThreadFactory <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月2日 下午5:51:33 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: DefaultThreadFactory @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月2日 下午5:51:33
 * @version
 * @since JDK 1.8
 */
class DefaultThreadFactory implements ThreadFactory {
  private static final AtomicInteger poolNumber = new AtomicInteger(1);
  private final ThreadGroup group;
  private final AtomicInteger threadNumber = new AtomicInteger(1);
  private final String namePrefix;

  DefaultThreadFactory() {
    SecurityManager s = System.getSecurityManager();
    group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
    namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
  }

  @Override
  public Thread newThread(Runnable r) {
    Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
    if (t.isDaemon()) t.setDaemon(false);
    if (t.getPriority() != Thread.NORM_PRIORITY) t.setPriority(Thread.NORM_PRIORITY);
    return t;
  }
}
