/**
 *
 */
package http;

import java.util.concurrent.CountDownLatch;

public class LatchTest {
	public static void main(String[] args) throws InterruptedException {
		final Runnable taskTemp = new Runnable() {

// 注意，此处是非线程安全的，留坑
			private int iCounter;

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					// 发起请求
					HttpClientOp.doGet("https://www.baidu.com/");
					iCounter++;
					System.out.println(
							System.nanoTime() + " [" + Thread.currentThread().getName() + "] iCounter = " + iCounter);
					try {
						Thread.sleep(1L);
					} catch (final InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		final LatchTest latchTest = new LatchTest();
		latchTest.startTaskAllInOnce(5, taskTemp);
	}

	public long startTaskAllInOnce(int threadNums, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(threadNums);
		for (int i = 0; i < threadNums; i++) {
			final Thread t = new Thread() {
				@Override
				public void run() {
					try {
						// 使线程在此等待，当开始门打开时，一起涌入门中
						startGate.await();
						try {
							task.run();
						} finally {
							// 将结束门减1，减到0时，就可以开启结束门了
							endGate.countDown();
						}
					} catch (final InterruptedException ie) {
						ie.printStackTrace();
					}
				}
			};
			t.start();
		}
		final long startTime = System.nanoTime();
		System.out.println(startTime + " [" + Thread.currentThread() + "] All thread is ready, concurrent going...");
		// 因开启门只需一个开关，所以立马就开启开始门
		startGate.countDown();
		// 等等结束门开启
		endGate.await();
		final long endTime = System.nanoTime();
		System.out.println(endTime + " [" + Thread.currentThread() + "] All thread is completed.");
		return endTime - startTime;
	}
}
