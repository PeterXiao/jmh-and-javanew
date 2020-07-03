/**
 *
 */
package io;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author LiY
 *
 */
public class LockTest {

	/**
	 * （1）竞争资源。当系统中供多个进程共享的资源如打印机、公用队列等，其数目不足以满足进程的需要时，会引起诸进程的竞争而产生死锁。
	 *
	 * （2）进程间推进顺序非法。进程在运行过程中，请求和释放资源的顺序不当，也同样会导致产生进程死锁。 产生死锁的四个必要条件：
	 * 1.互斥（Mutual exclusion）：存在这样一种资源，它在某个时刻只能被分配给一个执行绪（也称为线程）使用；
	 * 2.持有（Hold and wait）：当请求的资源已被占用从而导致执行绪阻塞时，资源占用者不但无需释放该资源，而且还可以继续请求更多资源；
	 * 3.不可剥夺（No preemption）：执行绪获得到的互斥资源不可被强行剥夺，换句话说，只有资源占用者自己才能释放资源；
	 * 4.环形等待（Circular wait）：若干执行绪以不同的次序获取互斥资源，从而形成环形等待的局面，想象在由多个执行绪组成的环形链中，每个执行绪都在等待下一个执行绪释放它持有的资源。
	 *
	 * 在死锁的四个必要条件中，第二、三和四项条件比较容易消除。
	 * 1、静态分配：采用资源静态分配策略（进程资源静态分配方式是指一个进程在建立时就分配了它需要的全部资源），破坏"部分分配"条件；
	 * 2、可剥夺：允许进程剥夺使用其他进程占有的资源，从而破坏"不可剥夺"条件； 3、有序分配：采用资源有序分配法，破坏"环路"条件。
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		final ReadWriteLock rtLock = new ReentrantReadWriteLock();
//		rtLock.readLock().lock();
//		System.out.println("get readLock.");
//		rtLock.writeLock().lock();
//		System.out.println("blocking");
//
		final ReadWriteLock rtLock = new ReentrantReadWriteLock();
		rtLock.writeLock().lock();
		System.out.println("writeLock");

		rtLock.readLock().lock();
		System.out.println("get read lock");
		new Thread(() -> {
			synchronized (B.class) {
				try {
					Thread.sleep(1000);
				} catch (final InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (A.class) {

				}
			}
		}).start();
		new Thread(() -> {
			synchronized (A.class) {
				try {
					Thread.sleep(1000);
				} catch (final InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (B.class) {

				}
			}

		}).start();
	}

}

class A {

}

class B {

}
