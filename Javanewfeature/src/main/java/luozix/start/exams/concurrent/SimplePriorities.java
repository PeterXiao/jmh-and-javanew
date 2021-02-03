/**
 * 
 */
package luozix.start.exams.concurrent;

/**
 * @author xiaoy
 *
 */
public class SimplePriorities extends Thread {
	private int countDown = 5;
	private volatile double d = 0;

	public SimplePriorities(int priority) {
		setPriority(priority);
		start();
	}

	@Override
	public String toString() {
		return super.toString() + ": " + countDown;
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 1; i < 100000; i++)
				d = d + (Math.PI + Math.E) / i;
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		new SimplePriorities(Thread.MAX_PRIORITY);
		for (int i = 0; i < 5; i++)
			new SimplePriorities(Thread.MIN_PRIORITY);
	}
}
