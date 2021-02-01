/**
 * 
 */
package luozix.start.action.cls;

/**
 * @author xiaoy
 *
 */
public class MyRunnable implements Runnable {
	private volatile boolean active;

	public void run() {
		active = true;
		while (active) // 第一行
		{
			// 代码
		}
	}

	public void stop() {
		active = false; // 第二行
	}
}
