package effectivejava.chapter11.item79;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

// Simple test of ObservableSet - Page 319
public class Test3 {
	public static void main(final String[] args) {
		final ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

// Observer that uses a background thread needlessly
		set.addObserver(new SetObserver<>() {
			@Override
			public void added(final ObservableSet<Integer> s, final Integer e) {
				System.out.println(e);
				if (e == 23) {

					// final ExecutorService exec = Executors.newSingleThreadExecutor();
					final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
							.setNameFormat("thread-call-runner-%d").build();
					final int size = 2; // services.size();
					final ExecutorService exec = new ThreadPoolExecutor(size, size, 0L, TimeUnit.MILLISECONDS,
							new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
					try {
						exec.submit(() -> s.removeObserver(this)).get();
					} catch (ExecutionException | InterruptedException ex) {
						throw new AssertionError(ex);
					} finally {
						exec.shutdown();
					}
				}
			}
		});

		for (int i = 0; i < 100; i++) {
			set.add(i);
		}
	}
}