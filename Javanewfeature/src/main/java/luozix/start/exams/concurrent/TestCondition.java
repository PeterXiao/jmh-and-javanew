/**  
* @Title: TestCondition.java
* @Package luozix.start.exams.concurrent
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午9:14:31
* @version V1.0  
*/
package luozix.start.exams.concurrent;
/**
* @ClassName: TestCondition
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月5日 下午9:14:31
*
*/
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class TestCondition {
	public static void main(String[] args) {
		final ReentrantLock reentrantLock = new ReentrantLock();
		final Condition condition = reentrantLock.newCondition();
		new Thread(new Runnable() {
			@Override
			public void run() {
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName() + "拿到锁了");
				System.out.println(Thread.currentThread().getName() + "等待信号");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "拿到信号");
				System.out.println(Thread.currentThread().getName() + "释放锁");
				reentrantLock.unlock();
			}
		}, "线程1").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName() + "拿到锁了");
				try {
					System.out.println(Thread.currentThread().getName() + "拿到锁后，sleep 3000");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "发出信号");
				condition.signalAll();
				try {
					Thread.sleep(3000);
					System.out.println(Thread.currentThread().getName() + "发出信后，sleep 3000");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "释放锁");
				reentrantLock.unlock();
			}
		}, "线程2").start();
	}
}