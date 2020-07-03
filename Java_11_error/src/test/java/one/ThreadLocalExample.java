/**
 *
 */
package one;

/**
 * @author LiY
 * @time 下午10:46:38
 */
public class ThreadLocalExample {

	public static class MyRunnable implements Runnable {

		private final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		@Override
		public void run() {
			threadLocal.set((int) (Math.random() * 100D));

			try {
				Thread.sleep(2000);
			} catch (final InterruptedException e) {
			}

			System.out.println(threadLocal.get());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final MyRunnable sharedRunnableInstance = new MyRunnable();

		final Thread thread1 = new Thread(sharedRunnableInstance);
		final Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}

}
