/**  
* @Title: CLHLockV2.java
* @Package luozix.start.action.concurrent
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月6日 上午10:43:20
* @version V1.0  
*/
package luozix.start.action.concurrent;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
* @ClassName: CLHLockV2
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyu xiaoyulong07@outlook.com 
* @date 2021年2月6日 上午10:43:20
*
*/
public class CLHLockV2 {

	/**
	 * CLH锁节点状态 - 每个希望获取锁的线程都被封装为一个节点对象
	 */
	private static class CLHNodeV2 {

		/**
		 * 默认状态为true - 即处于等待状态或者加锁成功(换言之，即此节点处于有效的一种状态)
		 */
		volatile boolean active = true;

	}

	/**
	 * 隐式链表最末等待节点
	 */
	private volatile CLHNodeV2 tail = null;

	/**
	 * 线程对应CLH节点映射
	 */
	private ThreadLocal<CLHNodeV2> currentThreadNode = new ThreadLocal<>();

	/**
	 * 原子更新器
	 */
	private static final AtomicReferenceFieldUpdater UPDATER = AtomicReferenceFieldUpdater.newUpdater(CLHLockV2.class,
			CLHNodeV2.class, "tail");

	/**
	 * CLH加锁
	 */
	public void lock() {

		CLHNodeV2 cNode = currentThreadNode.get();

		if (cNode == null) {
			cNode = new CLHNodeV2();
			currentThreadNode.set(cNode);
		}

		// 通过这个操作完成隐式链表的维护，后继节点只需要在前驱节点的locked状态上自旋
		CLHNodeV2 predecessor = (CLHNodeV2) UPDATER.getAndSet(this, cNode);
		if (predecessor != null) {
			// 自旋等待前驱节点状态变更 - unlock中进行变更
			while (predecessor.active) {

			}
		}

		// 没有前驱节点表示可以直接获取到锁，由于默认获取锁状态为true，此时可以什么操作都不执行
		// 能够执行到这里表示已经成功获取到了锁
	}

	/**
	 * CLH释放锁
	 */
	public void unlock() {

		CLHNodeV2 cNode = currentThreadNode.get();

		// 只有持有锁的线程才能够释放
		if (cNode == null || !cNode.active) {
			return;
		}

		// 从映射关系中移除当前线程对应的节点
		currentThreadNode.remove();

		// 尝试将tail从currentThread变更为null，因此当tail不为currentThread时表示还有线程在等待加锁
		if (!UPDATER.compareAndSet(this, cNode, null)) {
			// 不仅只有当前线程，还有后续节点线程的情况 - 将当前线程的锁状态置为false，因此其后继节点的lock自旋操作可以退出
			cNode.active = false;
		}

	}

	/**
	 * 用例
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		final CLHLockV2 lock = new CLHLockV2();

		for (int i = 1; i <= 10; i++) {
			new Thread(generateTask(lock, String.valueOf(i))).start();
		}

	}

	private static Runnable generateTask(final CLHLockV2 lock, final String taskId) {
		return () -> {
			lock.lock();

			try {
				Thread.sleep(3000);
			} catch (Exception e) {

			}

			System.out.println(String.format("Thread %s Completed", taskId));
			lock.unlock();
		};
	}

}