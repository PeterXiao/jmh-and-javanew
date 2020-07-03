/**
 *
 */
package basics.concurrent;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Office
 *
 */
public class TestAtomic {

    private static final int TASK_NUM = 1000;
    private static final int INCREMENT_PER_TASK = 10000;
    private static final int REPEAT = 10;

    private static long l = 0;

    public static void main(String[] args) throws Exception {
	repeatWithStatics(REPEAT, () -> testAtomicLong());
	repeatWithStatics(REPEAT, () -> testLongAdder());
	repeatWithStatics(REPEAT, () -> testLong());
    }

    public static void testAtomicLong() {
	AtomicLong al = new AtomicLong(0);
	execute(TASK_NUM, () -> repeat(INCREMENT_PER_TASK, () -> al.incrementAndGet()));
    }

    public static void testLong() {
	l = 0;
	execute(TASK_NUM, () -> repeat(INCREMENT_PER_TASK, () -> l++));
    }

    public static void testLongAdder() {
	LongAdder adder = new LongAdder();
	execute(TASK_NUM, () -> repeat(INCREMENT_PER_TASK, () -> adder.add(1)));
    }

    public static void repeatWithStatics(int n, Runnable runnable) {
	long[] elapseds = new long[n];

	ntimes(n).forEach(x -> {
	    long start = System.currentTimeMillis();
	    runnable.run();
	    long end = System.currentTimeMillis();
	    elapseds[x] = end - start;
	});

	System.out.printf("total: %d, %s\n", Arrays.stream(elapseds).sum(), Arrays.toString(elapseds));
    }

    private static void execute(int n, Runnable task) {
	try {
	    CountDownLatch latch = new CountDownLatch(n);
	    ExecutorService service = Executors.newFixedThreadPool(100);

	    Runnable taskWrapper = () -> {
		task.run();
		latch.countDown();
	    };

	    service.invokeAll(cloneTask(n, taskWrapper));
	    latch.await();
	    service.shutdown();
	} catch (Exception e) {
	}
    }

    private static Collection<Callable<Void>> cloneTask(int n, Runnable task) {
	return ntimes(n).mapToObj(x -> new Callable<Void>() {
	    @Override
	    public Void call() throws Exception {
		task.run();
		return null;
	    }
	}).collect(Collectors.toList());
    }

    private static void repeat(int n, Runnable runnable) {
	ntimes(n).forEach(x -> runnable.run());
    }

    private static IntStream ntimes(int n) {
	return IntStream.range(0, n);
    }

}
