/**
 *
 */
package one;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author Office
 *
 */
public class ThreadPool {

	/**
	 * 线程池的基本大小
	 */
	static int corePoolSize = 10;
	/**
	 * 线程池最大数量
	 */
	static int maximumPoolSizeSize = 100;
	/**
	 * 线程活动保持时间
	 */
	static long keepAliveTime = 1;
	/**
	 * 任务队列
	 */
	static ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);

	public static void main(final String[] args) {
		final ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSizeSize, keepAliveTime,
				TimeUnit.SECONDS, workQueue, new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build());
		// 提交一个任务
		executor.execute(() -> System.out.println("ok"));
	}
}
