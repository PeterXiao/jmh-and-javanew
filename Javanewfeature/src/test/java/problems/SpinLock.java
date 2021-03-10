/**
 * Project Name:java11_in_action File Name:SpinLock.java Package Name:problems
 * Date:2021年3月10日下午6:17:03 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: SpinLock.java @Package problems @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月10日 下午6:17:03
 * @version V1.0
 */
package problems;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ClassName:SpinLock <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月10日 下午6:17:03 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: SpinLock @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月10日 下午6:17:03
 * @version
 * @since JDK 1.8
 */
public class SpinLock {
  private AtomicReference<Thread> owner = new AtomicReference<Thread>();

  public void lock() {
    Thread currentThread = Thread.currentThread();
    // 如果锁未被占用，则设置当前线程为锁的拥有者
    while (!owner.compareAndSet(null, currentThread)) {}
  }

  public void unlock() {
    Thread currentThread = Thread.currentThread();
    // 只有锁的拥有者才能释放锁
    owner.compareAndSet(currentThread, null);
  }
}
