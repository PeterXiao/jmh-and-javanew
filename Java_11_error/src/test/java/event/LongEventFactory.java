/**
 *
 */
package event;

/**
 * @author LiY
 * @time 下午11:00:04
 */
import com.lmax.disruptor.EventFactory;

public class LongEventFactory implements EventFactory<LongEvent> {
	@Override
	public LongEvent newInstance() {
		return new LongEvent();
	}
}
