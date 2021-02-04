/**  
* @Title: CommandUser.java
* @Package luozix.start.exams.concurrent.hytrix
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:44:20
* @version V1.0  
*/
package luozix.start.exams.concurrent.hytrix;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
* @ClassName: CommandUser
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:44:20
*
*/
public class CommandUser extends HystrixCommand<String> {

	private final static Logger LOGGER = LoggerFactory.getLogger(CommandUser.class);

	private String userName;

	public CommandUser(String userName) {

		super(Setter.withGroupKey(
				// 服务分组
				HystrixCommandGroupKey.Factory.asKey("UserGroup"))
				// 线程分组
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("UserPool"))

				// 线程池配置
				.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)
						.withKeepAliveTimeMinutes(5).withMaxQueueSize(10).withQueueSizeRejectionThreshold(10000))

				// 线程池隔离
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
						.withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)));
		this.userName = userName;
	}

	@Override
	public String run() throws Exception {

		LOGGER.info("userName=[{}]", userName);

		TimeUnit.MILLISECONDS.sleep(100);
		return "userName=" + userName;
	}

}