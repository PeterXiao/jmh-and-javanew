/**
 * 
 */
package luozix.start.action.concurrent;

/**
 * @author xiaoy
 *
 */
public class Singleton {

	private static volatile Singleton singleton;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					// 防止指令重排
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}

//这里的 volatile 关键字主要是为了防止指令重排。
//
//如果不用 ，singleton = new Singleton();，这段代码其实是分为三步：
//
//分配内存空间。(1)
//初始化对象。(2)
//将 singleton 对象指向分配的内存地址。(3)
//加上 volatile 是为了让以上的三步操作顺序执行，反之有可能第二步在第三步之前被执行就有可能某个线程拿到的单例对象是还没有初始化的，以致于报错。
//
//总结
//volatile 在 Java 并发中用的很多，比如像 Atomic 包中的 value、以及 AbstractQueuedLongSynchronizer 中的 state 都是被定义为 volatile 来用于保证内存可见性。
//
//将这块理解透彻对我们编写并发程序时可以提供很大帮助。