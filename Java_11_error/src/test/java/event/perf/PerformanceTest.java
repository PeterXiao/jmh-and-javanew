/**
 *
 */
package event.perf;

import java.nio.ByteBuffer;
import java.util.concurrent.ThreadFactory;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import event.LongEvent;
import event.LongEventFactory;

/**
 * @author LiY
 * @time 下午4:16:45
 */
public class PerformanceTest {
	public static void main(String[] args) throws Exception {
		// The ThreadFactory for create producer thread.
		final ThreadFactory producerFactory = new ProducerFactory();

		// The factory for the event
		final LongEventFactory eventFactory = new LongEventFactory();

		// Specify the size of the ring buffer, must be power of 2.
		final int bufferSize = 8;

		// Construct the Disruptor，创建Disruptor组件
		final Disruptor<LongEvent> disruptor = new Disruptor<>(eventFactory, bufferSize, producerFactory,
				ProducerType.SINGLE, new BlockingWaitStrategy());

		// Connect the handler，绑定消费者事件，可以是多个
		disruptor.handleEventsWith(new LongEventHandler());
		// disruptor.handleEventsWith(new LongEventHandler());

		// Start the Disruptor, starts all threads
		// running，启动Disruptor，启动所有线程，主要是消费者对应的EventProcessor侦听线程，消费者事件处理器开始侦听RingBuffer中的消息
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		final RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

		final LongEventProducer producer = new LongEventProducer(ringBuffer);

		final ByteBuffer bb = ByteBuffer.allocate(8);
		for (long l = 0; true; l++) {
			bb.putLong(0, l);
			// 生产者向RingBuffer中写入消息
			producer.onData(bb);
			Thread.sleep(10);
		}
	}
}
