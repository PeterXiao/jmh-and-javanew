/**
 * 
 */
package luozix.start.action.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author xiaoy
 *
 */
public class ThreadPoolLocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Executors.newFixedThreadPool(10, new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build());

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 10, TimeUnit.SECONDS,
				new LinkedBlockingQueue(10));

		for (int i = 0; i < 15; i++) {
			threadPoolExecutor.submit(new MyThread(i + 1));
		}

	}

	static class MyThread implements Runnable {
		private int index;

		public MyThread(int index) {
			this.index = index;
		}

		@Override
		public void run() {
			System.out.println(this.index);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Test
	public void test01() throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(2,
				new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build());
		final LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
		for (int i = 1; i <= 10; i++) {
			deque.add(i + "");
		}
		es.submit(new Runnable() {
			@Override
			public void run() {
				while (!deque.isEmpty()) {
					System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
				}
			}
		});
		es.submit(new Runnable() {
			@Override
			public void run() {
				while (!deque.isEmpty()) {
					System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
				}
			}
		});
		Thread.sleep(10000l);
	}

	@Test
	public void test02() throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(2,
				new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build());
		final LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
		for (int i = 1; i <= 500; i++) {
			deque.add(i + "");
		}
		Future<String> result = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				while (!deque.isEmpty()) {
					System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
				}
				return "done";
			}
		});
		System.out.println(result.isDone());
		// get方法会阻塞
		System.out.println(result.get());
		System.out.println("exec next");
	}

	@Test
	public void test03() throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(2,
				new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build());
		final LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
		for (int i = 1; i <= 5000; i++) {
			deque.add(i + "");
		}
		Future<String> result = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				while (!deque.isEmpty() && !Thread.currentThread().isInterrupted()) {
					System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
				}
				return "done";
			}
		});

		try {
			System.out.println(result.get(10, TimeUnit.MILLISECONDS));
		} catch (TimeoutException e) {
			System.out.println("cancel result: " + result.cancel(true));
			System.out.println("is cancelled: " + result.isCancelled());
		}
		Thread.sleep(2000l);
	}

	@Test
	public void test04() throws Exception {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2,
				new ThreadFactoryBuilder().setNameFormat("thread-schedule-runner-%d").build());
		Future<String> result = ses.schedule(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("exec task");
				return "ok";
			}
		}, 10, TimeUnit.SECONDS);
		Thread.sleep(15000);
	}

	@Test
	public void test05() throws Exception {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2,
				new ThreadFactoryBuilder().setNameFormat("thread-schedule-runner-%d").build());
		Future<String> result = ses.schedule(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("exec task");
				try {
					Thread.sleep(5000l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("exec done, take 5 seconds");
				return "ok";
			}
		}, 10, TimeUnit.SECONDS);
		Thread.sleep(11000);
		result.cancel(true);
		Thread.sleep(10000);
	}

	@Test
	public void test06() throws Exception {
		ScheduledExecutorService sec = Executors.newScheduledThreadPool(2,
				new ThreadFactoryBuilder().setNameFormat("thread-schedule-runner-%d").build());
		sec.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println("exec");
			}
		}, 0, 5, TimeUnit.SECONDS);
		Thread.sleep(16000l);
	}

	@Test
	public void test07() throws Exception {
		ScheduledExecutorService sec = Executors.newScheduledThreadPool(2,
				new ThreadFactoryBuilder().setNameFormat("thread-schedule-runner-%d").build());
		sec.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println("exec");
				try {
					Thread.sleep(3000l);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, 0, 5, TimeUnit.SECONDS);
		Thread.sleep(17000l);
	}

	@Test
	public void test09() throws Exception {
		ScheduledExecutorService sec = Executors.newScheduledThreadPool(2,
				new ThreadFactoryBuilder().setNameFormat("thread-schedule-runner-%d").build());
		sec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("exec");
				try {
					Thread.sleep(3000l);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, 0, 5, TimeUnit.SECONDS);
		Thread.sleep(16000l);
	}

//	public static ExecutorService newSingleThreadExecutor() {
//	    return new FinalizableDelegatedExecutorService
//	        (new ThreadPoolExecutor(1, 1,
//	                                0L, TimeUnit.MILLISECONDS,
//	                                new LinkedBlockingQueue<Runnable>()));
//	}
}
