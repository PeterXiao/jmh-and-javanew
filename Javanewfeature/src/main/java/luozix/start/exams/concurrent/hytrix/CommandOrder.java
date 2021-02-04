/**  
* @Title: CommandOrder.java
* @Package luozix.start.exams.concurrent.hytrix
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:42:43
* @version V1.0  
*/
package luozix.start.exams.concurrent.hytrix;

/**
* @ClassName: CommandOrder
* @Description: TODO(订单服务)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:42:43
*
*/

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class CommandOrder extends HystrixCommand<String> {

	private final static Logger LOGGER = LoggerFactory.getLogger(CommandOrder.class);

	private String orderName;

	public CommandOrder(String orderName) {

		super(Setter.withGroupKey(
				// 服务分组
				HystrixCommandGroupKey.Factory.asKey("OrderGroup"))
				// 线程分组
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("OrderPool"))

				// 线程池配置
				.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)
						.withKeepAliveTimeMinutes(5).withMaxQueueSize(10).withQueueSizeRejectionThreshold(10000))

				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
						.withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)));
		this.orderName = orderName;
	}

	@Override
	public String run() throws Exception {

		LOGGER.info("orderName=[{}]", orderName);

		TimeUnit.MILLISECONDS.sleep(100);
		return "OrderName=" + orderName;
	}

}
