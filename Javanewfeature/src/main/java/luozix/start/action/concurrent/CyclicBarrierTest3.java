/**  
* @Title: CyclicBarrierTest3.java
* @Package luozix.start.action.concurrent
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月6日 上午11:03:55
* @version V1.0  
*/
package luozix.start.action.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
* @ClassName: CyclicBarrierTest3
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月6日 上午11:03:55
*
*/
public class CyclicBarrierTest3 {

	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

		Thread thread = new Thread(new Runnable() {

			@Override

			public void run() {

				try {

					c.await();

				} catch (Exception e) {

				}

			}

		});

		thread.start();

		thread.interrupt();

		try {

			c.await();

		} catch (Exception e) {

			System.out.println(c.isBroken());

}

	}

}
/*
 *  CountDownLatch的计数器只能使用一次，而CyclicBarrier的计数器可以使用reset()方法重置。
 * 所以CyclicBarrier能处理更为复杂的业务场景。例如，如果计算发生错误，可以重置计数器，并让线程重新执行一次。
 * 
 *  CyclicBarrier还提供其他有用的方法，比如getNumberWaiting方法可以获得Cyclic-Barrier阻塞的线程数量。
 * isBroken()方法用来了解阻塞的线程是否被中断。如下代码执行完之后会返回true。
 * 
 */