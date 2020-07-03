/**
 *
 */
package event.perf;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

import event.LongEvent;

/**
 * @author LiY
 * @time 下午4:19:34
 */
public class LongEventProducer {
// 生产者持有RingBuffer实例，可以直接向RingBuffer实例中的entry写入数据
	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData(ByteBuffer bb) {
		final long sequence = ringBuffer.next(); // Grab the next sequence
		try {
//从ringBuffer实例中获取entry
			final LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
			// for the sequence
//生产者将数据写入entry
			event.set(bb.getLong(0)); // Fill with data
		} finally {
//生产者向ringBuffer提交数据变更
			ringBuffer.publish(sequence);
		}
	}
}
