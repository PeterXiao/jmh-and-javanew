/**
 *
 */
package log;

import com.lmax.disruptor.EventHandler;

/**
 * @author LiY
 * @time 下午11:07:08
 */
public class ClearingEventHandler<T> implements EventHandler<ObjectEvent<T>> {
	@Override
	public void onEvent(ObjectEvent<T> event, long sequence, boolean endOfBatch) {
		// Failing to call clear here will result in the
		// object associated with the event to live until
		// it is overwritten once the ring buffer has wrapped
		// around to the beginning.
		event.clear();
	}
}
