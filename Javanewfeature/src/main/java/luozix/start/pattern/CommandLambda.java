/**  
* @Title: CommandLambda.java
* @Package luozix.start.pattern
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:07:22
* @version V1.0  
*/
package luozix.start.pattern;
/**
* @ClassName: CommandLambda
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月12日 下午11:07:22
*
*/

import java.util.ArrayList;
import java.util.List;

public class CommandLambda {

	/*
	 * Commands
	 */
	public static void log(String msg) {
		System.out.println("Logging:" + msg);
	}

	public static void save(String msg) {
		System.out.println("Saving:" + msg);
	}

	public static void send(String msg) {
		System.out.println("Sending:" + msg);
	}

	/*
	 * Executor
	 */
	public static void executor(List<Runnable> commands) {
		commands.forEach(Runnable::run);
	}

	public static void main(String[] args) {
		List<Runnable> commands = new ArrayList<>();
		commands.add(() -> log("Running command log"));
		commands.add(() -> save("Running command save"));
		commands.add(() -> send("Running command send"));

		executor(commands);
	}
}
