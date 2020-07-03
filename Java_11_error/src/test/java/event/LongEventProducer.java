/**
 *
 */
package event;

import java.nio.ByteBuffer;

/**
 * @author LiY
 * @time 下午11:00:52
 */
import com.lmax.disruptor.RingBuffer;

public class LongEventProducer {
	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void onData(ByteBuffer bb) {
		final long sequence = ringBuffer.next(); // Grab the next sequence
		try {
			final LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
			// for the sequence
			event.set(bb.getLong(0)); // Fill with data
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}
