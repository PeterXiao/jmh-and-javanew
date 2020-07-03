/**
 *
 */
package event.perf;

import com.lmax.disruptor.EventHandler;

import event.LongEvent;

/**
 * @author LiY
 * @time 下午4:19:04
 */
//消费者实现EventHandler接口
public class LongEventHandler implements EventHandler<LongEvent> {
//event为从RingBuffer entry中读取的事件内容，消费者从event中读取数据，并完成业务逻辑处理
	@Override
	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
		System.out.println(Thread.currentThread().getName() + " say : process LONG Event: " + event);
	}
}
