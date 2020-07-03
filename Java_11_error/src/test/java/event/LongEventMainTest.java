/**
 *
 */
package event;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.RingBuffer;
/**
 * @author LiY
 * @time 下午11:05:02
 */
import com.lmax.disruptor.dsl.Disruptor;

public class LongEventMainTest {
	public static void handleEvent(final LongEvent event, final long sequence, final boolean endOfBatch) {
		System.out.println(event);
	}

	public static void translate(final LongEvent event, final long sequence, final ByteBuffer buffer) {
		event.set(buffer.getLong(0));
	}

	public static void main(final String[] args) throws Exception {
		// Executor that will be used to construct new threads for consumers
		// final Executor executor = Executors.newCachedThreadPool();
		final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d")
				.build();
		final int size = 2; // services.size();
		final ExecutorService executorService = new ThreadPoolExecutor(size, size, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(), namedThreadFactory);

		// Specify the size of the ring buffer, must be power of 2.
		final int bufferSize = 1024;

		// Construct the Disruptor
		final Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, executorService);

		// Connect the handler
		disruptor.handleEventsWith(LongEventMainTest::handleEvent);

		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		final RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

		final ByteBuffer bb = ByteBuffer.allocate(8);
		for (long l = 0; true; l++) {
			bb.putLong(0, l);
			ringBuffer.publishEvent(LongEventMainTest::translate, bb);
			Thread.sleep(10);
		}

		// .....
//        // Construct the Disruptor with a SingleProducerSequencer
//        Disruptor<LongEvent> disruptor = new Disruptor(
//            factory, bufferSize, ProducerType.SINGLE, new BlockingWaitStrategy(), executor);
//        //.....
	}
}
