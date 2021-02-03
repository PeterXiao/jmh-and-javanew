/**
 * 
 */
package luozix.start.exams.concurrent;

/**
 * @author xiaoy
 *
 */
public class ThreadRun extends Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadRun t1 = new ThreadRun();
		t1.setName("thread1");
		t1.start();
		ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
		int noThreads = currentGroup.activeCount();
		Thread[] lstThreads = new Thread[noThreads];
		currentGroup.enumerate(lstThreads);
		for (int i = 0; i < noThreads; i++)
			System.out.println("线程号：" + i + " = " + lstThreads[i].getName());
	}

}
