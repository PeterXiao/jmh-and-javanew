/**
 *
 */
package basics.system;

/**
 * @author Office
 *
 */
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public final class ContextSwitchTest {
	static final int RUNS = 3;
	static final int ITERATES = 1000000;
	static AtomicReference turn = new AtomicReference();

	static final class WorkerThread extends Thread {
		volatile Thread other;
		volatile int nparks;

		@Override
		public void run() {
			final AtomicReference t = turn;
			final Thread other = this.other;
			if (turn == null || other == null) {
				throw new NullPointerException();
			}
			int p = 0;
			for (int i = 0; i < ITERATES; ++i) {
				while (!t.compareAndSet(other, this)) {
					LockSupport.park();
					++p;
				}
				LockSupport.unpark(other);
			}
			LockSupport.unpark(other);
			nparks = p;
			System.out.println("parks: " + p);

		}
	}

	static void test() throws Exception {
		final WorkerThread a = new WorkerThread();
		final WorkerThread b = new WorkerThread();
		a.other = b;
		b.other = a;
		turn.set(a);
		final long startTime = System.nanoTime();
		a.start();
		b.start();
		a.join();
		b.join();
		final long endTime = System.nanoTime();
		final int parkNum = a.nparks + b.nparks;
		System.out.println("Average time: " + (endTime - startTime) / parkNum + "ns");
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < RUNS; i++) {
			test();
		}
	}
}
