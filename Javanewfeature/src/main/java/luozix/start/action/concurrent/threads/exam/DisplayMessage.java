/**
 * 
 */
package luozix.start.action.concurrent.threads.exam;

/**
 * @author xiaoy
 *
 */
//文件名 : DisplayMessage.java
//通过实现 Runnable 接口创建线程
public class DisplayMessage implements Runnable {
	private String message;

	public DisplayMessage(String message) {
		this.message = message;
}

@Override
public void run() {
	while (true) {
		System.out.println(message);
	}
}
}