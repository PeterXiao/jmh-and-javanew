/**
 *
 */
package event;

import java.nio.ByteBuffer;

import com.lmax.disruptor.EventTranslatorOneArg;
/**
 * @author LiY
 * @time 下午11:02:17
 */
import com.lmax.disruptor.RingBuffer;

public class LongEventProducerWithTranslator {
	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR = (event, sequence, bb) -> event
			.set(bb.getLong(0));

	public void onData(ByteBuffer bb) {
		ringBuffer.publishEvent(TRANSLATOR, bb);
	}
}