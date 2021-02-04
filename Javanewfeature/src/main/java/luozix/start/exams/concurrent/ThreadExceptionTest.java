/**  
* @Title: ThreadExceptionTest.java
* @Package luozix.start.exams.concurrent
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:51:12
* @version V1.0  
*/
package luozix.start.exams.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: ThreadExceptionTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xiaoyu xiaoyulong07@outlook.com
 * @date 2021年2月4日 下午4:51:12 问题搞清楚后来想想为什么线程池在调度的时候执行的是 Runnable 的 run() 方法，而不是
 *       start() 方法呢？ threadPool 里面是run 而不是 start？
 */
public class ThreadExceptionTest {
	private final static Logger LOGGER = LoggerFactory.getLogger(ThreadExceptionTest.class);

	public static void main(String[] args) throws InterruptedException {

		ExecutorService execute = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		execute.execute(new Runnable() {
			@Override
			public void run() {
				LOGGER.info("=====11=======");
			}
		});

		TimeUnit.SECONDS.sleep(5);

		execute.execute(new Run1());

		// TimeUnit.SECONDS.sleep(5);
		//
		// execute.execute(new Run2());
		// execute.shutdown();

	}

	private static class Run1 implements Runnable {

		@Override
		public void run() {
			int count = 0;
			while (true) {
				count++;
				LOGGER.info("-------222-------------{}", count);

				if (count == 10) {
					System.out.println(1 / 0);
					try {
					} catch (Exception e) {
						LOGGER.error("Exception", e);
					}
				}

				if (count == 20) {
					LOGGER.info("count={}", count);
					break;
				}
			}
		}
	}

	private static class Run2 implements Runnable {

		public Run2() {
			LOGGER.info("run2 构造函数");
		}

		@Override
		public void run() {
			LOGGER.info("run222222222");
		}
	}
}