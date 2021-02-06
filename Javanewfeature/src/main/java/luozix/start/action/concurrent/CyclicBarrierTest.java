/**  
* @Title: CyclicBarrierTest.java
* @Package luozix.start.action.concurrent
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月6日 上午10:50:13
* @version V1.0  
*/
package luozix.start.action.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xiaoyu xiaoyulong07@outlook.com
 * @date 2021年2月6日 上午10:50:13
 *
 */
public class CyclicBarrierTest {

	static CyclicBarrier c = new CyclicBarrier(2);

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

}

//CyclicBarrier（int parties，Runnable barrier Action）