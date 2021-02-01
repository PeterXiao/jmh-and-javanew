/**
 * 
 */
package luozix.start.dataalais;

/**
 * @author xiaoy
 *
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RunoobTestTime extends Object {

	private List synchedList;

	public RunoobTestTime() {
		// 创建一个同步列表
		synchedList = Collections.synchronizedList(new LinkedList());
	}

	// 删除列表中的元素
	public String removeElement() throws InterruptedException {
		synchronized (synchedList) {

			// 列表为空就等待，等待 10 秒加上 500 纳秒
			while (synchedList.isEmpty()) {
				System.out.println("List is empty...");
				synchedList.wait(10000, 500);
				System.out.println("Waiting...");
			}
			String element = (String) synchedList.remove(0);

			return element;
		}
	}

	// 添加元素到列表
	public void addElement(String element) {
		System.out.println("Opening...");
		synchronized (synchedList) {

			// 添加一个元素，并通知元素已存在
			synchedList.add(element);
			System.out.println("New Element:'" + element + "'");

			synchedList.notifyAll();
			System.out.println("notifyAll called!");
		}
		System.out.println("Closing...");
	}

	public static void main(String[] args) {
		final RunoobTestTime demo = new RunoobTestTime();

		Runnable runA = new Runnable() {

			@Override
			public void run() {
				try {
					String item = demo.removeElement();
					System.out.println("" + item);
				} catch (InterruptedException ix) {
					System.out.println("Interrupted Exception!");
				} catch (Exception x) {
					System.out.println("Exception thrown.");
				}
			}
		};

		Runnable runB = new Runnable() {

			// 执行添加元素操作，并开始循环
			@Override
			public void run() {
				demo.addElement("Hello!");
			}
		};

		try {
			Thread threadA1 = new Thread(runA, "Google");
			threadA1.start();

			Thread.sleep(500);

			Thread threadA2 = new Thread(runA, "Runoob");
			threadA2.start();

			Thread.sleep(500);

			Thread threadB = new Thread(runB, "Taobao");
			threadB.start();

			Thread.sleep(1000);

			threadA1.interrupt();
			threadA2.interrupt();
		} catch (InterruptedException x) {
		}
	}
}