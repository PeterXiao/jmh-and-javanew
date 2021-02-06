/**  
* @Title: CyclicBarrierTest2.java
* @Package luozix.start.action.concurrent
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月6日 上午10:54:43
* @version V1.0  
*/
package luozix.start.action.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierTest2
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xiaoyu xiaoyulong07@outlook.com
 * @date 2021年2月6日 上午10:54:43
 *
 */
public class CyclicBarrierTest2 {

	static CyclicBarrier c = new CyclicBarrier(2, new A());

	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override

			public void run() {

				try {

					c.await();

				} catch (Exception e) {

				}

				System.out.println(1);

			}

		}).start();

		try {

			c.await();

		} catch (Exception e) {

		}

		System.out.println(2);

	}

	static class A implements Runnable {

		@Override

		public void run() {

			System.out.println(3);

		}

	}

}
