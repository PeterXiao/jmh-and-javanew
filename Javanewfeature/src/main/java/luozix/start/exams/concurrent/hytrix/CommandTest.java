/**  
* @Title: CommandTest.java
* @Package luozix.start.exams.concurrent.hytrix
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:43:32
* @version V1.0  
*/
package luozix.start.exams.concurrent.hytrix;
/**
* @ClassName: CommandTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月4日 下午4:43:32
*
*/

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandTest {
	private final static Logger LOGGER = LoggerFactory.getLogger(CommandTest.class);
	
	/**
	 * @throws TimeoutException @throws ExecutionException @throws
	 * InterruptedException @param args @Title: main @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param args 设定文件 @return void 返回类型 @throws
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		CommandOrder commandPhone = new CommandOrder("手机");
		CommandOrder command = new CommandOrder("电视");

		// 阻塞方式执行
		String execute = commandPhone.execute();
		LOGGER.info("execute=[{}]", execute);

		// 异步非阻塞方式
		Future<String> queue = command.queue();
		String value = queue.get(200, TimeUnit.MILLISECONDS);
		LOGGER.info("value=[{}]", value);

		CommandUser commandUser = new CommandUser("张三");
		String name = commandUser.execute();
		LOGGER.info("name=[{}]", name);
	}

}
